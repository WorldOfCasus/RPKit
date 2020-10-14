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

package com.rpkit.players.bukkit.profile

import com.rpkit.core.service.Service
import org.bukkit.OfflinePlayer


interface RPKMinecraftProfileService : Service {

    fun getMinecraftProfile(id: Int): RPKMinecraftProfile?
    fun getMinecraftProfile(player: OfflinePlayer): RPKMinecraftProfile?
    fun getMinecraftProfiles(profile: RPKProfile): List<RPKMinecraftProfile>
    fun addMinecraftProfile(profile: RPKMinecraftProfile)
    fun updateMinecraftProfile(profile: RPKMinecraftProfile)
    fun removeMinecraftProfile(profile: RPKMinecraftProfile)
    fun getMinecraftProfileLinkRequests(minecraftProfile: RPKMinecraftProfile): List<RPKMinecraftProfileLinkRequest>
    fun addMinecraftProfileLinkRequest(minecraftProfileLinkRequest: RPKMinecraftProfileLinkRequest)
    fun removeMinecraftProfileLinkRequest(minecraftProfileLinkRequest: RPKMinecraftProfileLinkRequest)

}