package com.refinedmods.refinedstorage.apiimpl.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.refinedmods.refinedstorage.api.render.IElementDrawer;
import com.refinedmods.refinedstorage.screen.grid.CraftingPreviewScreen;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;

public class CraftingPreviewElementDrawers extends ElementDrawers {
    private final IElementDrawer<Integer> overlayDrawer = (matrixStack, x, y, colour) -> {
        RenderSystem.color4f(1, 1, 1, 1);
        RenderSystem.disableLighting();

        AbstractGui.fill(matrixStack, x, y, x + 73, y + 29, colour);
    };

    public CraftingPreviewElementDrawers(CraftingPreviewScreen screen, FontRenderer fontRenderer) {
        super(screen, fontRenderer);
    }

    @Override
    public IElementDrawer<Integer> getOverlayDrawer() {
        return overlayDrawer;
    }
}
