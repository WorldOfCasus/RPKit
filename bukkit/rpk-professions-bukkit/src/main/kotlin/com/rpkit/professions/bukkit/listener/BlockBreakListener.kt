/*
 * Copyright 2021 Ren Binden
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.professions.bukkit.listener

import com.rpkit.characters.bukkit.character.RPKCharacterService
import com.rpkit.core.bukkit.extension.addLore
import com.rpkit.core.service.Services
import com.rpkit.itemquality.bukkit.itemquality.RPKItemQuality
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfileService
import com.rpkit.professions.bukkit.RPKProfessionsBukkit
import com.rpkit.professions.bukkit.profession.RPKCraftingAction
import com.rpkit.professions.bukkit.profession.RPKProfessionService
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import kotlin.math.roundToInt
import kotlin.random.Random


class BlockBreakListener(private val plugin: RPKProfessionsBukkit) : Listener {

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val bukkitPlayer = event.player
        if (bukkitPlayer.gameMode == GameMode.CREATIVE || bukkitPlayer.gameMode == GameMode.SPECTATOR) return
        val minecraftProfileService = Services[RPKMinecraftProfileService::class.java]
        if (minecraftProfileService == null) {
            event.isDropItems = false
            return
        }
        val characterService = Services[RPKCharacterService::class.java]
        if (characterService == null) {
            event.isDropItems = false
            return
        }
        val professionService = Services[RPKProfessionService::class.java]
        if (professionService == null) {
            event.isDropItems = false
            return
        }
        val minecraftProfile = minecraftProfileService.getPreloadedMinecraftProfile(bukkitPlayer)
        if (minecraftProfile == null) {
            event.isDropItems = false
            return
        }
        val character = characterService.getPreloadedActiveCharacter(minecraftProfile)
        if (character == null) {
            event.isDropItems = false
            return
        }
        val professions = professionService.getPreloadedProfessions(character)
        if (professions == null) {
            event.isDropItems = false
            return
        }
        val professionLevels = professions
            .associateWith { profession -> professionService.getPreloadedProfessionLevel(character, profession) ?: 1 }
        val itemsToDrop = mutableListOf<ItemStack>()
        for (item in event.block.getDrops(event.player.inventory.itemInMainHand)) {
            val material = item.type
            val amount = professionLevels.entries
                .map { (profession, level) -> profession.getAmountFor(RPKCraftingAction.MINE, material, level) }
                .maxOrNull() ?: plugin.config.getDouble("default.mining.$material.amount", 1.0)
            val potentialQualities = professionLevels.entries
                    .mapNotNull { (profession, level) -> profession.getQualityFor(RPKCraftingAction.MINE, material, level) }
            val quality = potentialQualities.maxByOrNull(RPKItemQuality::durabilityModifier)
            if (quality != null) {
                item.addLore(quality.lore)
            }
            if (amount > 1) {
                item.amount = amount.roundToInt()
                itemsToDrop.add(item)
            } else if (amount < 1) {
                val random = Random.nextDouble()
                if (random <= amount) {
                    item.amount = 1
                    itemsToDrop.add(item)
                }
            } else {
                itemsToDrop.add(item)
            }
            professions.forEach { profession ->
                val receivedExperience = plugin.config.getInt("professions.${profession.name.value}.experience.items.mining.$material", 0) * item.amount
                if (receivedExperience > 0) {
                    professionService.getProfessionExperience(character, profession).thenAccept { characterProfessionExperience ->
                        professionService.setProfessionExperience(character, profession, characterProfessionExperience + receivedExperience).thenRunAsync {
                            val level = professionService.getProfessionLevel(character, profession).join()
                            val experience = professionService.getProfessionExperience(character, profession).join()
                            event.player.sendMessage(plugin.messages.mineExperience.withParameters(
                                profession = profession,
                                level = level,
                                receivedExperience = receivedExperience,
                                experience = experience - profession.getExperienceNeededForLevel(level),
                                nextLevelExperience = profession.getExperienceNeededForLevel(level + 1) - profession.getExperienceNeededForLevel(level),
                                totalExperience = experience,
                                totalNextLevelExperience = profession.getExperienceNeededForLevel(level + 1),
                                material = material
                            ))
                        }
                    }
                }
            }
        }
        event.isDropItems = false
        for (item in itemsToDrop) {
            event.block.world.dropItemNaturally(event.block.location, item)
        }
    }

}