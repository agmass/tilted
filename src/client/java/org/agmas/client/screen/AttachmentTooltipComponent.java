package org.agmas.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
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

    @Override
    public void extractText(GuiGraphicsExtractor graphics, Font font, int x, int y) {
        int i = 0;
        for (Component component1 : component) {
            graphics.text(font, component1, x, y+i, -1, true);
            i += 12;
        }
    }
}
