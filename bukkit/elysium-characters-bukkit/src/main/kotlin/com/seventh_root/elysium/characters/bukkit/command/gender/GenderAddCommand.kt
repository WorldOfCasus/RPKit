package com.seventh_root.elysium.characters.bukkit.command.gender

import com.seventh_root.elysium.characters.bukkit.ElysiumCharactersBukkit
import com.seventh_root.elysium.characters.bukkit.gender.BukkitGender
import com.seventh_root.elysium.characters.bukkit.gender.BukkitGenderProvider
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.conversations.*
import org.bukkit.entity.Player

class GenderAddCommand(private val plugin: ElysiumCharactersBukkit) : CommandExecutor {
    private val conversationFactory: ConversationFactory

    init {
        conversationFactory = ConversationFactory(plugin).withModality(true).withFirstPrompt(GenderPrompt()).withEscapeSequence("cancel").addConversationAbandonedListener { event ->
            if (!event.gracefulExit()) {
                val conversable = event.context.forWhom
                if (conversable is Player) {
                    conversable.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.operation-cancelled")))
                }
            }
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Conversable) {
            if (sender.hasPermission("elysium.characters.command.gender.add")) {
                if (args.size > 0) {
                    val genderProvider = plugin.core.serviceManager.getServiceProvider(BukkitGenderProvider::class.java)
                    val genderBuilder = StringBuilder()
                    for (i in 0..args.size - 1 - 1) {
                        genderBuilder.append(args[i]).append(' ')
                    }
                    genderBuilder.append(args[args.size - 1])
                    if (genderProvider.getGender(genderBuilder.toString()) == null) {
                        genderProvider.addGender(BukkitGender(genderBuilder.toString()))
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.gender-add-valid")))
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.gender-add-invalid-gender")))
                    }
                } else {
                    conversationFactory.buildConversation(sender).begin()
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.no-permission-gender-add")))
            }
        }
        return true
    }

    private inner class GenderPrompt : ValidatingPrompt() {

        override fun getPromptText(context: ConversationContext): String {
            return ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.gender-add-prompt"))
        }

        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val genderProvider = plugin.core.serviceManager.getServiceProvider(BukkitGenderProvider::class.java)
            return genderProvider.getGender(input) == null
        }

        override fun getFailedValidationText(context: ConversationContext?, invalidInput: String?): String {
            return ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.gender-add-invalid-gender"))
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val genderProvider = plugin.core.serviceManager.getServiceProvider(BukkitGenderProvider::class.java)
            genderProvider.addGender(BukkitGender(input))
            return GenderAddedPrompt()
        }

    }

    private inner class GenderAddedPrompt : MessagePrompt() {

        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return Prompt.END_OF_CONVERSATION
        }

        override fun getPromptText(context: ConversationContext): String {
            return ChatColor.translateAlternateColorCodes('&', plugin.config.getString("messages.gender-add-valid"))
        }

    }

}
