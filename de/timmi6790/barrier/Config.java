// 
// Decompiled by Procyon v0.5.36
// 

package de.timmi6790.barrier;

import lombok.Generated;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.common.config.Configuration;

public class Config
{
    private final Cache cache;
    private final Configuration configuration;
    private boolean visibleBarrierBlocks;
    
    public Config(final Cache cache, final Configuration configuration) {
        this.cache = cache;
        this.configuration = configuration;
        this.loadConfiguration();
    }
    
    public void loadConfiguration() {
        this.visibleBarrierBlocks = this.configuration.getBoolean("visibleBarrierBlocks", "general", false, "");
        this.cache.setVisibleBarrier(this.visibleBarrierBlocks);
        if (this.configuration.hasChanged()) {
            this.configuration.save();
        }
    }
    
    @SubscribeEvent
    public void onConfigurationChangeEvent(final ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase("BV")) {
            this.loadConfiguration();
        }
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
    public boolean isVisibleBarrierBlocks() {
        return this.visibleBarrierBlocks;
    }
    
    @Generated
    public Config setVisibleBarrierBlocks(final boolean visibleBarrierBlocks) {
        this.visibleBarrierBlocks = visibleBarrierBlocks;
        return this;
    }
    
    @Generated
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Config)) {
            return false;
        }
        final Config other = (Config)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$cache = this.getCache();
        final Object other$cache = other.getCache();
        Label_0065: {
            if (this$cache == null) {
                if (other$cache == null) {
                    break Label_0065;
                }
            }
            else if (this$cache.equals(other$cache)) {
                break Label_0065;
            }
            return false;
        }
        final Object this$configuration = this.getConfiguration();
        final Object other$configuration = other.getConfiguration();
        if (this$configuration == null) {
            if (other$configuration == null) {
                return this.isVisibleBarrierBlocks() == other.isVisibleBarrierBlocks();
            }
        }
        else if (this$configuration.equals(other$configuration)) {
            return this.isVisibleBarrierBlocks() == other.isVisibleBarrierBlocks();
        }
        return false;
    }
    
    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Config;
    }
    
    @Generated
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $cache = this.getCache();
        result = result * 59 + (($cache == null) ? 43 : $cache.hashCode());
        final Object $configuration = this.getConfiguration();
        result = result * 59 + (($configuration == null) ? 43 : $configuration.hashCode());
        result = result * 59 + (this.isVisibleBarrierBlocks() ? 79 : 97);
        return result;
    }
    
    @Generated
    @Override
    public String toString() {
        return "Config(cache=" + this.getCache() + ", configuration=" + this.getConfiguration() + ", visibleBarrierBlocks=" + this.isVisibleBarrierBlocks() + ")";
    }
}
