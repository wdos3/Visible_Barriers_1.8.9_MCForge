// 
// Decompiled by Procyon v0.5.36
// 

package de.timmi6790.barrier.gui;

import net.minecraftforge.common.config.ConfigElement;
import de.timmi6790.barrier.McMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(final GuiScreen guiScreen) {
        super(guiScreen, new ConfigElement(McMod.getInstance().getConfiguration().getCategory("general")).getChildElements(), "BV", false, true, GuiConfig.getAbridgedConfigPath(McMod.getInstance().getConfiguration().toString()));
    }
}
