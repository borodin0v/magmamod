package ru.magmacube.clientmod.mixins;

import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public abstract class MultiplayerMixin {
    @Shadow protected abstract void connect(ServerInfo entry);

    @Inject(at = @At("HEAD"), method = "init")
    public void init(CallbackInfo info) {
        this.connect(new ServerInfo("MagmaCube", "mc.magma-cube.ru", false));
    }
}
