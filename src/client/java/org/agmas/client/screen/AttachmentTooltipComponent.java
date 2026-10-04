package org.agmas.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
//? if >=26.1 {
import net.minecraft.client.gui.GuiGraphicsExtractor;
//? } else {
/*import net.minecraft.client.gui.GuiGraphics;
*///? }
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class AttachmentTooltipComponent implements ClientTooltipComponent {
    private final List<Component> component;

    public AttachmentTooltipComponent(List<Component> component) {
        this.component = component;
    }

    @Override
    public int getHeight(Font font) {
        return component.size()*12;
    }

    @Override
    public int getWidth(Font font) {
        int w =0;
        for (Component component1 : component) {
            int w1 = Minecraft.getInstance().font.width(component1.getString());
            if (w1 > w) w = w1;
        }
        return w;
    }


    //? if >=26.1 {
    
    @Override
    public void extractText(GuiGraphicsExtractor graphics, Font font, int x, int y) {
     
    //? } else {
    /*@Override
    public void renderText(GuiGraphics graphics, Font font, int x, int y) {
        ClientTooltipComponent.super.renderText(graphics, font, x, y);
    *///? }
        int i = 0;
        for (Component component1 : component) {
            //? if >=26.1 {
            graphics.text(font, component1, x, y+i, -1, true);
            //? } else if >=1.21.11 {
            /*graphics.textRenderer().accept(x, y+i, component1);
            *///? } else {
            /*graphics.drawString(font, component1, x, y+i, -1, true);
            *///? }
            i += 12;
        }
    }
}
