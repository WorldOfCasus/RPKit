/*
 * Copyright 2020 Ren Binden
 *
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

package com.rpkit.players.bukkit.command.profile

import com.rpkit.core.command.RPKCommandExecutor
import com.rpkit.core.command.result.CommandFailure
import com.rpkit.core.command.result.CommandResult
import com.rpkit.core.command.result.CommandSuccess
import com.rpkit.core.command.result.IncorrectUsageFailure
import com.rpkit.core.command.result.MissingServiceFailure
import com.rpkit.core.command.sender.RPKCommandSender
import com.rpkit.core.service.Services
import com.rpkit.players.bukkit.RPKPlayersBukkit
import com.rpkit.players.bukkit.command.result.NotAPlayerFailure
import com.rpkit.players.bukkit.profile.RPKProfile
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfile
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfileService


class ProfileConfirmLinkCommand(private val plugin: RPKPlayersBukkit) : RPKCommandExecutor {

    class InvalidIdFailure : CommandFailure()
    class AlreadyLinkedFailure(val linkedProfile: RPKProfile) : CommandFailure()
    class InvalidRequestFailure : CommandFailure()
    class InvalidProfileTypeFailure : CommandFailure()

    override fun onCommand(sender: RPKCommandSender, args: Array<out String>): CommandResult {
        if (sender !is RPKMinecraftProfile) {
            sender.sendMessage(plugin.messages.notFromConsole)
            return NotAPlayerFailure()
        }
        if (args.size <= 1) {
            sender.sendMessage(plugin.messages.profileConfirmLinkUsage)
            return IncorrectUsageFailure()
        }
        val type = args[0]
        val id = args[1].toIntOrNull()
        when (type.toLowerCase()) {
            "minecraft" -> {
                if (id == null) {
                    sender.sendMessage(plugin.messages.profileConfirmLinkInvalidId)
                    return InvalidIdFailure()
                }
                val minecraftProfileService = Services[RPKMinecraftProfileService::class.java]
                if (minecraftProfileService == null) {
                    sender.sendMessage(plugin.messages.noMinecraftProfileService)
                    return MissingServiceFailure(RPKMinecraftProfileService::class.java)
                }
                val profile = sender.profile
                if (profile is RPKProfile) {
                    sender.sendMessage(plugin.messages.profileConfirmLinkInvalidAlreadyLinked)
                    return AlreadyLinkedFailure(profile)
                }
                val linkRequests = minecraftProfileService.getMinecraftProfileLinkRequests(sender)
                val linkRequest = linkRequests.firstOrNull { request -> request.profile.id == id }
                if (linkRequest == null) {
                    sender.sendMessage(plugin.messages.profileConfirmLinkInvalidRequest)
                    return InvalidRequestFailure()
                }
                sender.profile = linkRequest.profile
                minecraftProfileService.updateMinecraftProfile(sender)
                minecraftProfileService.removeMinecraftProfileLinkRequest(linkRequest)
                sender.sendMessage(plugin.messages.profileConfirmLinkValid)
                return CommandSuccess
            }
            else -> {
                sender.sendMessage(plugin.messages.profileConfirmLinkInvalidType)
                return InvalidProfileTypeFailure()
            }
        }
    }

}