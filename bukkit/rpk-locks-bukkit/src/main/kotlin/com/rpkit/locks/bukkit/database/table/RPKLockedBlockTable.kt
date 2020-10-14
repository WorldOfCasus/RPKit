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

package com.rpkit.locks.bukkit.database.table

import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.locks.bukkit.RPKLocksBukkit
import com.rpkit.locks.bukkit.database.jooq.Tables.RPKIT_LOCKED_BLOCK
import com.rpkit.locks.bukkit.lock.RPKLockedBlock
import org.bukkit.block.Block
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder


class RPKLockedBlockTable(private val database: Database, private val plugin: RPKLocksBukkit) : Table {

    private val cache = if (plugin.config.getBoolean("caching.rpkit_locked_block.block.enabled")) {
        database.cacheManager.createCache("rpk-locks-bukkit.rpkit_locked_block.block",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(String::class.javaObjectType, RPKLockedBlock::class.java,
                        ResourcePoolsBuilder.heap(plugin.config.getLong("caching.rpkit_locked_block.block.size"))))
    } else {
        null
    }

    fun insert(entity: RPKLockedBlock) {
        val block = entity.block
        database.create
                .insertInto(
                        RPKIT_LOCKED_BLOCK,
                        RPKIT_LOCKED_BLOCK.WORLD,
                        RPKIT_LOCKED_BLOCK.X,
                        RPKIT_LOCKED_BLOCK.Y,
                        RPKIT_LOCKED_BLOCK.Z
                )
                .values(
                        block.world.name,
                        block.x,
                        block.y,
                        block.z
                )
                .execute()
        cache?.put(block.toCacheKey(), entity)
    }

    operator fun get(block: Block): RPKLockedBlock? {
        if (cache?.containsKey(block.toCacheKey()) == true) {
            return cache[block.toCacheKey()]
        } else {
            database.create
                    .select(
                            RPKIT_LOCKED_BLOCK.WORLD,
                            RPKIT_LOCKED_BLOCK.X,
                            RPKIT_LOCKED_BLOCK.Y,
                            RPKIT_LOCKED_BLOCK.Z
                    )
                    .from(RPKIT_LOCKED_BLOCK)
                    .where(RPKIT_LOCKED_BLOCK.WORLD.eq(block.world.name))
                    .and(RPKIT_LOCKED_BLOCK.X.eq(block.x))
                    .and(RPKIT_LOCKED_BLOCK.Y.eq(block.y))
                    .and(RPKIT_LOCKED_BLOCK.Z.eq(block.z))
                    .fetchOne() ?: return null
            val lockedBlock = RPKLockedBlock(block)
            cache?.put(block.toCacheKey(), lockedBlock)
            return lockedBlock
        }
    }

    fun delete(entity: RPKLockedBlock) {
        val block = entity.block
        database.create
                .deleteFrom(RPKIT_LOCKED_BLOCK)
                .where(RPKIT_LOCKED_BLOCK.WORLD.eq(block.world.name))
                .and(RPKIT_LOCKED_BLOCK.X.eq(block.x))
                .and(RPKIT_LOCKED_BLOCK.Y.eq(block.y))
                .and(RPKIT_LOCKED_BLOCK.Z.eq(block.z))
                .execute()
        cache?.remove(block.toCacheKey())
    }

    private fun Block.toCacheKey() = "${world.name},$x,$y,$z"
}