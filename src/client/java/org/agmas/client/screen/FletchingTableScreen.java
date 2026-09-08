package org.agmas.client.screen;

import net.minecraft.client.Minecraft;
//? if >=26.1 {
/*import net.minecraft.client.gui.GuiGraphicsExtractor;
*///? } else {
import net.minecraft.client.gui.GuiGraphics;
//? }
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
//? if >= 1.21.6 {
import net.minecraft.client.renderer.RenderPipelines;
//? }
import net.minecraft.network.chat.Component;
//? if >=1.21.9 {
import net.minecraft.client.input.MouseButtonEvent;
//? }
//? if >=1.21.11 {
import net.minecraft.resources.Identifier;
//? } else {
/*import net.minecraft.resources.ResourceLocation;
*///? }
import net.minecraft.world.entity.player.Inventory;
import org.agmas.Tilted;
import org.agmas.attachments.BarrelAttachment;
import org.agmas.attachments.ScopeAttachment;
import org.agmas.client.mixin.GuiGraphicsMixin;
import org.agmas.screen.FletchingTableMenu;

import java.awt.*;
import java.util.List;

public class FletchingTableScreen extends AbstractContainerScreen<FletchingTableMenu> {

    //? if >=1.21.11 {
    private static final Identifier CONTAINER_TEXTURE =Tilted.of("textures/gui/container/fletching_table.png");
    private static final Identifier ATTACHMENT_SPRITE = Tilted.of("textures/gui/container/recipe.png");
    private static final Identifier ATTACHMENT_SPRITE_HIGHLIGHTED = Tilted.of("textures/gui/container/recipe_highlighted.png");
    private static final Identifier CONTAINER_TEXTURE_SELECTED = Tilted.of("textures/gui/container/recipe_selected.png");
    //? } else {
    /*private static final ResourceLocation CONTAINER_TEXTURE =Tilted.of("textures/gui/container/fletching_table.png");
    private static final ResourceLocation ATTACHMENT_SPRITE = Tilted.of("textures/gui/container/recipe.png");
    private static final ResourceLocation ATTACHMENT_SPRITE_HIGHLIGHTED = Tilted.of("textures/gui/container/recipe_highlighted.png");
    private static final ResourceLocation CONTAINER_TEXTURE_SELECTED = Tilted.of("textures/gui/container/recipe_selected.png");
    *///? }

    private static final int ATTACHMENT_LIST_START_X = 52;
    private static final int ATTACHMENT_LIST_ROW_Y = 15;
    private static final int ATTACHMENT_LIST_ROW_HEIGHT = 20;
    private static final int ATTACHMENT_WIDTH = 16;

    public FletchingTableScreen(FletchingTableMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    //? if >=26.1 {
    /*@Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
    *///? } else {
    @Override
    protected void renderBg(GuiGraphics graphics, float f, int i, int j) {
    //? }
        //? if >= 1.21.6 {
        graphics.blit(RenderPipelines.GUI_TEXTURED, CONTAINER_TEXTURE, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, BACKGROUND_TEXTURE_WIDTH, BACKGROUND_TEXTURE_HEIGHT);
        //? } else {
        /*graphics.blit(CONTAINER_TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        *///? }
    }


    //? if >=26.1 {
    /*@Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);
    *///? } else {

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float a) {
        super.render(graphics, mouseX, mouseY, a);
    //? }
        if (menu.crossbowInSlot) {
            int i = 0;
            Runnable renderTooltipLast = null;

            for (BarrelAttachment value : BarrelAttachment.values()) {
                int posY = topPos + ATTACHMENT_LIST_ROW_Y;
                int posX = leftPos + ATTACHMENT_LIST_START_X + i;
                selectionBackground(graphics,posX,posY,menu.selectedBarrel.get()==value.ordinal(),mouseX,mouseY);

                //? if >= 1.21.6 {
                graphics.blit(RenderPipelines.GUI_TEXTURED, Tilted.of("textures/gui/container/" + value.name().toLowerCase() + ".png"), posX,posY,0,0,16,16,16,16);
                //? } else {
                /*graphics.blit(Tilted.of("textures/gui/container/" + value.name().toLowerCase() + ".png"), posX, posY, 0, 0, 16, 16, 16, 16);
                *///? }

                if (isSelected(posX,posY,mouseX,mouseY)) {
                    renderTooltipLast = () -> {
                        AttachmentTooltipComponent attachmentTooltipComponent = new AttachmentTooltipComponent(List.of(
                                Component.translatable("tilted.barrels." + value.name().toLowerCase()),
                                Component.translatable("tilted.barrels." + value.name().toLowerCase() + ".desc"),
                                Component.literal(""),
                                Component.literal("Spread Multiplier: " + value.uncertaintyMultiplier + "x").withColor(Color.GRAY.getRGB()))
                        );

                        //? if <1.21.6 {
                        /*((GuiGraphicsMixin)graphics).tilted$renderTooltipInternal(Minecraft.getInstance().font, List.of(attachmentTooltipComponent), mouseX, mouseY, DefaultTooltipPositioner.INSTANCE);
                        *///? } else if <=1.21.11 {
                        graphics.renderTooltip(Minecraft.getInstance().font, List.of(attachmentTooltipComponent),mouseX,mouseY, DefaultTooltipPositioner.INSTANCE,null);
                        //? } else if <26.3 {
                        /*graphics.tooltip(Minecraft.getInstance().font, List.of(attachmentTooltipComponent),mouseX,mouseY, DefaultTooltipPositioner.INSTANCE,null);
                        *///? } else {
                        /*graphics.tooltip(Minecraft.getInstance().font, List.of(attachmentTooltipComponent),mouseX,mouseY, DefaultTooltipPositioner.INSTANCE,null,false);
                        *///? }
                    };
                }
                i += ATTACHMENT_WIDTH;
            }
            i = 0;

            for (ScopeAttachment value : ScopeAttachment.values()) {
                int posY = topPos + ATTACHMENT_LIST_ROW_Y + (ATTACHMENT_LIST_ROW_HEIGHT);
                int posX = leftPos + ATTACHMENT_LIST_START_X + i;
                selectionBackground(graphics,posX,posY,menu.selectedScope.get()==value.ordinal(),mouseX,mouseY);

                //? if >= 1.21.6 {
                graphics.blit(RenderPipelines.GUI_TEXTURED, Tilted.of("textures/gui/container/" + value.name().toLowerCase() + ".png"), posX,posY,0,0,16,16,16,16);
                //? } else {
                /*graphics.blit(Tilted.of("textures/gui/container/" + value.name().toLowerCase() + ".png"), posX, posY, 0, 0, 16, 16, 16, 16);
                *///? }

                if (isSelected(posX,posY,mouseX,mouseY)) {
                    renderTooltipLast = () -> {
                        float zoomRounded = (1/value.zoom);
                        zoomRounded = (float) (Math.floor(zoomRounded*10)/10);
                        AttachmentTooltipComponent attachmentTooltipComponent = new AttachmentTooltipComponent(List.of(
                                Component.translatable("tilted.scopes." + value.name().toLowerCase()),
                                Component.translatable("tilted.scopes." + value.name().toLowerCase() + ".desc"),
                                Component.literal(""),
                                Component.literal("Zoom: " + zoomRounded + "x").withColor(Color.GRAY.getRGB()),
                                Component.literal("Time to ADS: " + (value.ticksToADS/20f) + "s").withColor(Color.GRAY.getRGB())
                        ));
                        //? if <1.21.6 {
                        /*((GuiGraphicsMixin)graphics).tilted$renderTooltipInternal(Minecraft.getInstance().font, List.of(attachmentTooltipComponent), mouseX, mouseY, DefaultTooltipPositioner.INSTANCE);
                        *///? } else if <=1.21.11 {
                        graphics.renderTooltip(Minecraft.getInstance().font, List.of(attachmentTooltipComponent),mouseX,mouseY, DefaultTooltipPositioner.INSTANCE,null);
                        //? } else if <26.3 {
                        /*graphics.tooltip(Minecraft.getInstance().font, List.of(attachmentTooltipComponent),mouseX,mouseY, DefaultTooltipPositioner.INSTANCE,null);
                        *///? } else {
                        /*graphics.tooltip(Minecraft.getInstance().font, List.of(attachmentTooltipComponent),mouseX,mouseY, DefaultTooltipPositioner.INSTANCE,null,false);
                        *///? }
                    };
                }
                i += ATTACHMENT_WIDTH;
            }
            if (renderTooltipLast != null)
                renderTooltipLast.run();
        }
    }

    //? if <1.21.9 {
    /*@Override
    public boolean mouseClicked(double x, double y, int e) {
    *///? } else {
    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        double x = event.x();
        double y = event.y();
    //? }
        int i = 0;
        int networkID = 0;
        for (BarrelAttachment value : BarrelAttachment.values()) {
            int posY = topPos + ATTACHMENT_LIST_ROW_Y;
            int posX = leftPos + ATTACHMENT_LIST_START_X + i;
            if (isSelected(posX,posY, (int) x, (int) y)) {
                this.minecraft.gameMode.handleInventoryButtonClick(menu.containerId, networkID);
                return true;
            }
            networkID++;
            i += 16;
        }
        i = 0;
        for (ScopeAttachment value : ScopeAttachment.values()) {
            int posY = topPos + ATTACHMENT_LIST_ROW_Y + (ATTACHMENT_LIST_ROW_HEIGHT);
            int posX = leftPos + ATTACHMENT_LIST_START_X + i;
            if (isSelected(posX,posY, (int) x,(int) y)) {
                this.minecraft.gameMode.handleInventoryButtonClick(menu.containerId, networkID);
                return true;
            }
            networkID++;
            i += 16;
        }
        //? if <1.21.9 {
        /*return super.mouseClicked(x, y, e);
        *///? } else {
        return super.mouseClicked(event, doubleClick);
        //? }
    }

    //? if >=26.1 {
    /*public void selectionBackground(GuiGraphicsExtractor graphics, int x, int y, boolean selected, int mx, int my) {
    *///? } else {
    public void selectionBackground(GuiGraphics graphics, int x, int y, boolean selected, int mx, int my) {
    //? }
        //? if >=1.21.11 {
        Identifier sprite;
        //? } else {
        /*ResourceLocation sprite;
        *///? }
        if (selected) {
            sprite = CONTAINER_TEXTURE_SELECTED;
        } else if (isSelected(x,y,mx,my)) {
            sprite = ATTACHMENT_SPRITE_HIGHLIGHTED;
        } else {
            sprite = ATTACHMENT_SPRITE;
        }

        //? if >= 1.21.6 {
        graphics.blit(RenderPipelines.GUI_TEXTURED, sprite, x, y, 0, 0, 16, 16, 16, 16);
        //? } else {
        /*graphics.blit(sprite, x, y, 0, 0, 16, 16, 16, 16);
        *///? }
    }

    public boolean isSelected(int x, int y, int mx, int my) {
        return mx >= x && my >= y && mx < x + 16 && my < y + 16;
    }
}
