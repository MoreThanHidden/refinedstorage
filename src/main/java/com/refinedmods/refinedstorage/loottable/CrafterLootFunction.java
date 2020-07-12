package com.refinedmods.refinedstorage.loottable;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.refinedmods.refinedstorage.apiimpl.network.node.CrafterNetworkNode;
import com.refinedmods.refinedstorage.setup.CommonSetup;
import com.refinedmods.refinedstorage.tile.CrafterTile;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.tileentity.TileEntity;

public class CrafterLootFunction extends LootFunction {

    protected CrafterLootFunction(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ItemStack doApply(ItemStack stack, LootContext lootContext) {
        TileEntity tile = lootContext.get(LootParameters.BLOCK_ENTITY);

        CrafterNetworkNode removedNode = ((CrafterTile) tile).getRemovedNode();
        if (removedNode == null) {
            removedNode = ((CrafterTile) tile).getNode();
        }

        if (removedNode.getDisplayName() != null) {
            stack.setDisplayName(removedNode.getDisplayName());
        }

        return stack;
    }

    @Override
    public LootFunctionType func_230425_b_() {
        return CommonSetup.LOOTFUNCTION_CRAFTER;
    }

    public static class Serializer extends LootFunction.Serializer<CrafterLootFunction> {

        @Override
        public CrafterLootFunction deserialize(JsonObject object, JsonDeserializationContext deserializationContext, ILootCondition[] conditionsIn) {
            return new CrafterLootFunction(conditionsIn);
        }
    }

}
