package ru.magmacube.clientmod.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.magmacube.clientmod.MagmaMod;

@Mixin(MinecraftClient.class)
public class ClientMixin {
    @Inject(at = @At("TAIL"), method = "<init>")
    public void init(CallbackInfo info) {
        MagmaMod.Companion.getLogger().fine("Mixin injected!");
    }
}
