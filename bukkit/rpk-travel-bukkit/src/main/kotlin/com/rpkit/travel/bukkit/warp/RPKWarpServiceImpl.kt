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

package com.rpkit.travel.bukkit.warp

import com.rpkit.core.location.RPKLocation
import com.rpkit.travel.bukkit.RPKTravelBukkit
import com.rpkit.travel.bukkit.database.table.RPKWarpTable
import com.rpkit.warp.bukkit.event.warp.RPKBukkitWarpCreateEvent
import com.rpkit.warp.bukkit.event.warp.RPKBukkitWarpDeleteEvent
import com.rpkit.warp.bukkit.event.warp.RPKBukkitWarpUpdateEvent
import com.rpkit.warp.bukkit.warp.RPKWarp
import com.rpkit.warp.bukkit.warp.RPKWarpName
import com.rpkit.warp.bukkit.warp.RPKWarpService
import java.util.concurrent.CompletableFuture


class RPKWarpServiceImpl(override val plugin: RPKTravelBukkit) : RPKWarpService {
    override val warps: CompletableFuture<List<RPKWarp>>
        get() = plugin.database.getTable(RPKWarpTable::class.java).getAll()

    override fun getWarp(name: RPKWarpName): CompletableFuture<RPKWarp?> {
        return plugin.database.getTable(RPKWarpTable::class.java)[name.value]
    }

    override fun addWarp(warp: RPKWarp): CompletableFuture<Void> {
        return CompletableFuture.runAsync {
            val event = RPKBukkitWarpCreateEvent(warp, true)
            plugin.server.pluginManager.callEvent(event)
            if (event.isCancelled) return@runAsync
            plugin.database.getTable(RPKWarpTable::class.java).insert(event.warp).join()
        }
    }

    override fun createWarp(name: RPKWarpName, location: RPKLocation): CompletableFuture<RPKWarp> {
        val warp = RPKWarpImpl(name, location)
        return addWarp(warp).thenApply { warp }
    }

    override fun updateWarp(warp: RPKWarp): CompletableFuture<Void> {
        return CompletableFuture.runAsync {
            val event = RPKBukkitWarpUpdateEvent(warp, true)
            plugin.server.pluginManager.callEvent(event)
            if (event.isCancelled) return@runAsync
            plugin.database.getTable(RPKWarpTable::class.java).update(event.warp).join()
        }
    }

    override fun removeWarp(warp: RPKWarp): CompletableFuture<Void> {
        return CompletableFuture.runAsync {
            val event = RPKBukkitWarpDeleteEvent(warp, true)
            plugin.server.pluginManager.callEvent(event)
            if (event.isCancelled) return@runAsync
            plugin.database.getTable(RPKWarpTable::class.java).delete(event.warp).join()
        }
    }
}