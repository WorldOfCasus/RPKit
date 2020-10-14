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

package com.rpkit.core.bukkit.message

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.message.Messages
import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException
import java.util.logging.Level.SEVERE


class BukkitMessages(private val plugin: RPKBukkitPlugin) : Messages {

    private val messagesConfigFile = File(plugin.dataFolder, "messages.yml")
    val messagesConfig: FileConfiguration

    init {
        val finalMessagesConfig = YamlConfiguration.loadConfiguration(messagesConfigFile)
        messagesConfig = finalMessagesConfig
        saveDefaultMessagesConfig()
    }

    fun saveMessagesConfig() {
        try {
            messagesConfig.save(messagesConfigFile)
        } catch (exception: IOException) {
            plugin.logger.log(SEVERE, "Could not save messages config to $messagesConfigFile", exception)
        }
    }

    fun saveDefaultMessagesConfig() {
        if (!messagesConfigFile.exists()) {
            if (!plugin.dataFolder.exists()) {
                plugin.dataFolder.mkdirs()
            }
            messagesConfigFile.createNewFile()
        }
    }

    override fun get(key: String, vars: Map<String, String>): String {
        var message = messagesConfig.getString(key) ?: return key
        message = ChatColor.translateAlternateColorCodes('&', message)
        vars.forEach { pair ->
            message = message.replace("\$${pair.key}", pair.value)
        }
        return message
    }

    override fun get(key: String): String {
        val message = messagesConfig.getString(key) ?: return key
        return ChatColor.translateAlternateColorCodes('&', message)
    }

    override fun getList(key: String, vars: Map<String, String>): List<String> {
        return messagesConfig.getStringList(key).map { message ->
            var updatedMessage = message
            vars.forEach { pair ->
                updatedMessage = updatedMessage.replace("\$${pair.key}", pair.value)
            }
            ChatColor.translateAlternateColorCodes('&', updatedMessage)
        }
    }

    override fun getList(key: String): List<String> {
        return messagesConfig.getStringList(key).map { ChatColor.translateAlternateColorCodes('&', it) }
    }

    override fun set(key: String, value: String) {
        messagesConfig.set(key, value)
        saveMessagesConfig()
    }

    override fun setDefault(key: String, value: String) {
        if (!messagesConfig.contains(key, true)) {
            messagesConfig.set(key, value)
            saveMessagesConfig()
        }
    }

    override fun setDefault(key: String, value: List<String>) {
        if (!messagesConfig.contains(key, true)) {
            messagesConfig.set(key, value)
            saveMessagesConfig()
        }
    }

}