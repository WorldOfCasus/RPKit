package com.rpkit.essentials.bukkit.warp

import com.rpkit.essentials.bukkit.RPKEssentialsBukkit
import com.rpkit.essentials.bukkit.database.table.RPKWarpTable
import com.rpkit.warp.bukkit.warp.RPKWarp
import com.rpkit.warp.bukkit.warp.RPKWarpProvider


class RPKWarpProviderImpl(private val plugin: RPKEssentialsBukkit): RPKWarpProvider {
    override val warps: List<RPKWarp>
        get() = plugin.core.database.getTable(RPKWarpTable::class).getAll()

    override fun getWarp(id: Int): RPKWarp? {
        return plugin.core.database.getTable(RPKWarpTable::class).get(id)
    }

    override fun getWarp(name: String): RPKWarp? {
        return plugin.core.database.getTable(RPKWarpTable::class).get(name)
    }

    override fun addWarp(warp: RPKWarp) {
        plugin.core.database.getTable(RPKWarpTable::class).insert(warp)
    }

    override fun updateWarp(warp: RPKWarp) {
        plugin.core.database.getTable(RPKWarpTable::class).update(warp)
    }

    override fun removeWarp(warp: RPKWarp) {
        plugin.core.database.getTable(RPKWarpTable::class).delete(warp)
    }
}