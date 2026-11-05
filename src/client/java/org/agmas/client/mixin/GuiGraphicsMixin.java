package org.agmas.client.mixin;

//? if < 1.21.6 {

/*import java.util.List;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GuiGraphics.class)
public interface GuiGraphicsMixin {
    @Invoker("renderTooltipInternal")
    void tilted$renderTooltipInternal(Font font, List<ClientTooltipComponent> components, int x, int y, ClientTooltipPositioner positioner);
}

*///? } else {

import org.spongepowered.asm.mixin.Mixin;
import org.agmas.client.dummy.DM_GuiGraphics;

@Mixin(DM_GuiGraphics.class)
public interface GuiGraphicsMixin {}

//? }
