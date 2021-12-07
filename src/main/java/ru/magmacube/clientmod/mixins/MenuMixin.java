package ru.magmacube.clientmod.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.magmacube.clientmod.CustomMainMenu;
import ru.magmacube.clientmod.MagmaMod;

@Mixin(TitleScreen.class)
public abstract class MenuMixin extends Screen {
    @Shadow @Nullable private String splashText;
    MinecraftClient mc = MagmaMod.Companion.getMinecraft();
    protected MenuMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        mc.openScreen(new CustomMainMenu());
        splashText = "MagmaCube goes brrr";
    }
    @Inject(at = @At("TAIL"), cancellable = true, method = "render")
    public void onRender(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        textRenderer.drawWithShadow(matrices, "MagmaMod", width - 6 - 3, 3, 0xffffffff);
    }
}
