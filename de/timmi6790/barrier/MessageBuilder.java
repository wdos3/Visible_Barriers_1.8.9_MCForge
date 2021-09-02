// 
// Decompiled by Procyon v0.5.36
// 

package de.timmi6790.barrier;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class MessageBuilder
{
    private final IChatComponent messageObject;
    
    public MessageBuilder(final String message) {
        this.messageObject = (IChatComponent)new ChatComponentText(message);
    }
    
    public MessageBuilder(final String message, final EnumChatFormatting colour) {
        this.messageObject = (IChatComponent)new ChatComponentText(message);
        this.messageObject.func_150256_b().func_150238_a(colour);
    }
    
    public MessageBuilder addMessage(final MessageBuilder messageBuilder) {
        this.messageObject.func_150257_a(messageBuilder.build());
        return this;
    }
    
    public MessageBuilder addMessage(final String message, final EnumChatFormatting colour) {
        final IChatComponent messageNew = (IChatComponent)new ChatComponentText(message);
        messageNew.func_150256_b().func_150238_a(colour);
        this.messageObject.func_150257_a(messageNew);
        return this;
    }
    
    public IChatComponent build() {
        return this.messageObject;
    }
    
    public void sendToPlayer() {
        final EntityPlayerSP player = Minecraft.func_71410_x().field_71439_g;
        if (player != null) {
            player.func_145747_a(this.messageObject);
        }
    }
}
