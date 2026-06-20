package org.agmas.item;

import net.minecraft.world.item.Item;
import org.agmas.attachments.SkinsComponent;

public class TiltedSmithingTemplateItem extends Item {
    public SkinsComponent skinEnum;
    public TiltedSmithingTemplateItem(Properties properties, SkinsComponent skinEnum) {
        super(properties);
        this.skinEnum = skinEnum;
    }
}
