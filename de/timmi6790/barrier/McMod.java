// 
// Decompiled by Procyon v0.5.36
// 

package de.timmi6790.barrier;

import org.apache.logging.log4j.LogManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.command.ICommand;
import de.timmi6790.barrier.command.commands.BarrierCommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import java.io.File;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import lombok.Generated;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "BV", name = "BarrierVisibility", version = "1.0.0", acceptedMinecraftVersions = "1.8.9", guiFactory = "de.timmi6790.barrier.gui.GuiFactory", clientSideOnly = true)
public class McMod
{
    @Generated
    private static final Logger log;
    @Mod.Instance("BV")
    private static McMod instance;
    private final Cache cache;
    private Configuration configuration;
    private String configDirectory;
    
    public McMod() {
        this.cache = new Cache();
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        this.configDirectory = event.getModConfigurationDirectory().toString();
        final File path = new File(this.configDirectory + File.separator + "BV" + ".cfg");
        this.configuration = new Configuration(path);
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.func_71560_a((ICommand)new BarrierCommand(this.cache));
        MinecraftForge.EVENT_BUS.register((Object)new Config(this.cache, this.configuration));
    }
    
    @Generated
    public Cache getCache() {
        return this.cache;
    }
    
    @Generated
    public Configuration getConfiguration() {
        return this.configuration;
    }
    
    @Generated
    public String getConfigDirectory() {
        return this.configDirectory;
    }
    
    @Generated
    public McMod setConfiguration(final Configuration configuration) {
        this.configuration = configuration;
        return this;
    }
    
    @Generated
    public McMod setConfigDirectory(final String configDirectory) {
        this.configDirectory = configDirectory;
        return this;
    }
    
    @Generated
    public static McMod getInstance() {
        return McMod.instance;
    }
    
    static {
        log = LogManager.getLogger((Class)McMod.class);
    }
}
