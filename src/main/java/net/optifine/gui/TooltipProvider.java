package net.optifine.gui;

import java.awt.Rectangle;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.Screen;

public interface TooltipProvider
{
    Rectangle getTooltipBounds(Screen var1, int var2, int var3);

    String[] getTooltipLines(GuiButton var1, int var2);

    boolean isRenderBorder();
}
