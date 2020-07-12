package com.refinedmods.refinedstorage.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.refinedmods.refinedstorage.RS;
import com.refinedmods.refinedstorage.container.WirelessTransmitterContainer;
import com.refinedmods.refinedstorage.screen.widget.sidebutton.RedstoneModeSideButton;
import com.refinedmods.refinedstorage.tile.WirelessTransmitterTile;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class WirelessTransmitterScreen extends BaseScreen<WirelessTransmitterContainer> {
    public WirelessTransmitterScreen(WirelessTransmitterContainer container, PlayerInventory inventory, ITextComponent title) {
        super(container, 211, 137, inventory, title);
    }

    @Override
    public void onPostInit(int x, int y) {
        addSideButton(new RedstoneModeSideButton(this, WirelessTransmitterTile.REDSTONE_MODE));
    }

    @Override
    public void tick(int x, int y) {
    }

    @Override
    public void renderBackground(MatrixStack matrixStack, int x, int y, int mouseX, int mouseY) {
        bindTexture(RS.ID, "gui/wireless_transmitter.png");

        blit(matrixStack, x, y, 0, 0, xSize, ySize);
    }

    @Override
    public void renderForeground(MatrixStack matrixStack, int mouseX, int mouseY) {
        renderString(matrixStack,7, 7, title.getString());
        renderString(matrixStack,28, 25, new TranslationTextComponent("gui.refinedstorage.wireless_transmitter.distance", WirelessTransmitterTile.RANGE.getValue()).getString());
        renderString(matrixStack,7, 43, new TranslationTextComponent("container.inventory").getString());
    }
}
