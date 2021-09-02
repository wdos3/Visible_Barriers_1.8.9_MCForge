// 
// Decompiled by Procyon v0.5.36
// 

package de.timmi6790.barrier;

import lombok.Generated;

public class Cache
{
    private boolean visibleBarrier;
    
    @Generated
    public Cache() {
        this.visibleBarrier = false;
    }
    
    @Generated
    public boolean isVisibleBarrier() {
        return this.visibleBarrier;
    }
    
    @Generated
    public Cache setVisibleBarrier(final boolean visibleBarrier) {
        this.visibleBarrier = visibleBarrier;
        return this;
    }
    
    @Generated
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cache)) {
            return false;
        }
        final Cache other = (Cache)o;
        return other.canEqual(this) && this.isVisibleBarrier() == other.isVisibleBarrier();
    }
    
    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Cache;
    }
    
    @Generated
    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isVisibleBarrier() ? 79 : 97);
        return result;
    }
    
    @Generated
    @Override
    public String toString() {
        return "Cache(visibleBarrier=" + this.isVisibleBarrier() + ")";
    }
}
