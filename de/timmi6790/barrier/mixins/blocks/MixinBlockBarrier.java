// 
// Decompiled by Procyon v0.5.36
// 

package de.timmi6790.barrier.mixins.blocks;

import lombok.Generated;
import de.timmi6790.barrier.McMod;
import de.timmi6790.barrier.Cache;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.block.BlockBarrier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ BlockBarrier.class })
public class MixinBlockBarrier
{
    private final AtomicReference<Object> cache;
    
    public MixinBlockBarrier() {
        this.cache = new AtomicReference<Object>();
    }
    
    @Inject(method = { "getRenderType" }, at = { @At("HEAD") }, cancellable = true)
    public void getRenderType(final CallbackInfoReturnable<Integer> cir) {
        if (this.getCache().isVisibleBarrier()) {
            cir.setReturnValue(3);
        }
    }
    
    @Generated
    public Cache getCache() {
        Object value = this.cache.get();
        if (value == null) {
            synchronized (this.cache) {
                value = this.cache.get();
                if (value == null) {
                    final Cache actualValue = McMod.getInstance().getCache();
                    value = ((actualValue == null) ? this.cache : actualValue);
                    this.cache.set(value);
                }
            }
        }
        return (Cache)((value == this.cache) ? null : value);
    }
}
