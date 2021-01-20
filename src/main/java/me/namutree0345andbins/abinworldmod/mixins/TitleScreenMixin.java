package me.namutree0345andbins.abinworldmod.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.AbstractPressableButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "initWidgetsNormal", at = @At("TAIL"))
    private void initWidgetsNormal(int y, int spacingY, CallbackInfo ci) {
        for (AbstractButtonWidget w : this.buttons) {
            System.out.println(w.getMessage().getString());
        }
        System.out.println(this.buttons.size());
        buttons.remove(0);
        System.out.println(this.buttons.size());
        buttons.remove(0);
        buttons.remove(0);

        children.remove(0);
        children.remove(0);
        children.remove(0);

        this.addButton(new ButtonWidget(this.width / 2 - 100, (y + spacingY), 200, 20, new TranslatableText("서버 접속"), (btn) -> {
            ServerInfo info = new ServerInfo("CKD", "ckdg.kro.kr", false);
            info.setResourcePackState(ServerInfo.ResourcePackState.ENABLED);
            MinecraftClient.getInstance().openScreen(new ConnectScreen(this, MinecraftClient.getInstance(), info));
        }));

    }
}
