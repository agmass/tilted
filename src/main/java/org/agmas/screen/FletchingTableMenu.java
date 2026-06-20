package org.agmas.screen;

import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.agmas.ModComponents;
import org.agmas.ModMenuTypes;
import org.agmas.attachments.BarrelAttachment;
import org.agmas.attachments.ScopeAttachment;
import org.jspecify.annotations.NonNull;

import java.util.Objects;

public class FletchingTableMenu extends AbstractContainerMenu {
    public final Container container;
    public final Slot inputSlot;
    public boolean crossbowInSlot = false;
    public final ContainerLevelAccess access;
    public DataSlot selectedBarrel = DataSlot.standalone();
    public DataSlot selectedScope = DataSlot.standalone();

    public FletchingTableMenu(final int containerId, final Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public FletchingTableMenu(final int containerId, final Inventory inventory, final ContainerLevelAccess access) {
        super(ModMenuTypes.FLETCHING_TABLE, containerId);
        this.container = new SimpleContainer(1) {
            public void setChanged() {
                super.setChanged();
                slotsChanged(this);
            }
        };
        inputSlot = addSlot(new Slot(container,0,20, 33));

        this.access = access;
        selectedScope.set(0);
        selectedBarrel.set(0);
        this.addStandardInventorySlots(inventory, 8, 84);
        this.addDataSlot(selectedBarrel);
        this.addDataSlot(selectedScope);

    }

    @Override
    public boolean clickMenuButton(Player player, int buttonId) {
        int i = 0;
        for (BarrelAttachment value : BarrelAttachment.values()) {
            if (i == buttonId) {
                selectedBarrel.set(value.ordinal());
                inputSlot.getItem().set(ModComponents.BARREL_COMPONENT, value.ordinal());
                broadcastChanges();
                return true;
            }
            i++;
        }
        for (ScopeAttachment value : ScopeAttachment.values()) {
            if (i == buttonId) {
                selectedScope.set(value.ordinal());
                inputSlot.getItem().set(ModComponents.SCOPE_COMPONENT, value.ordinal());
                broadcastChanges();
                return true;
            }
            i++;
        }
        return super.clickMenuButton(player, buttonId);
    }

    @Override
    public void slotsChanged(Container container) {
        ItemStack input = this.inputSlot.getItem();
        crossbowInSlot = input.is(Items.CROSSBOW);
        super.slotsChanged(container);
    }


    @Override
    public @NonNull ItemStack quickMoveStack(@NonNull Player player, int slotIndex) {ItemStack clicked = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(slotIndex);
        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            Item item = stack.getItem();
            clicked = stack.copy();
            if (slotIndex == 1) {
                item.onCraftedBy(stack, player);
                if (!this.moveItemStackTo(stack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(stack, clicked);
            } else if (slotIndex == 0) {
                if (!this.moveItemStackTo(stack, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (stack.is(Items.CROSSBOW)) {
                if (!this.moveItemStackTo(stack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex >= 2 && slotIndex < 29) {
                if (!this.moveItemStackTo(stack, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slotIndex >= 29 && slotIndex < 38 && !this.moveItemStackTo(stack, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (stack.getCount() == clicked.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
            if (slotIndex == 1) {
                player.drop(stack, false);
            }

            this.broadcastChanges();
        }

        return clicked;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.access.execute((level, pos) -> this.clearContainer(player, this.container));
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return true;
    }
}
