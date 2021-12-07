package ru.magmacube.clientmod

import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.MinecraftClient
import java.util.logging.LogManager
import java.util.logging.Logger

class MagmaMod : ClientModInitializer {
    private val synchronized = Any()
    private fun log(text: String) {
        synchronized(synchronized) {
            logger.fine(text)
        }
    }
    override fun onInitializeClient() {
        log("Fine, I initialized")
        log("Init!")
    }
    companion object {
        val logger: Logger = LogManager.getLogManager().getLogger("ru/magmacube/client")
        val minecraft = MinecraftClient.getInstance()
    }
}