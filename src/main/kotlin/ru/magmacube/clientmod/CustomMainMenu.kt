package ru.magmacube.clientmod

import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen
import net.minecraft.client.gui.screen.option.OptionsScreen
import net.minecraft.client.gui.screen.world.SelectWorldScreen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.client.realms.gui.screen.RealmsMainScreen
import net.minecraft.text.Text

class CustomMainMenu : Screen(Text.of("MagmaMod custom menu")) {
    private val mc: MinecraftClient = MagmaMod.minecraft
    override fun init() {
        addButton(ButtonWidget(
            width - 125, height - 125, 120, 20, Text.of("Одиночная игра")
        ) {
            mc.openScreen(
                SelectWorldScreen(this)
            )
        })
        addButton(ButtonWidget(
            width - 125, height - 100, 120, 20, Text.of("Зайти на сервер")
        ) {
            mc.openScreen(MultiplayerScreen(this))
        })
        addButton(ButtonWidget(
            width - 125, height - 75, 120, 20, Text.of("Настройки")
        ) {
            mc.openScreen(
                OptionsScreen(this, mc.options)
            )
        })
        addButton(ButtonWidget(
            width - 125, height - 50, 120, 20, Text.of("Realms")
        ) {
            mc.openScreen(
                RealmsMainScreen(this)
            )
        })
        addButton(ButtonWidget(
            width - 125, height - 25, 120, 20, Text.of("Выйти")
        ) {
            assert(client != null)
            client!!.scheduleStop()
        })
        super.init()
    }
}