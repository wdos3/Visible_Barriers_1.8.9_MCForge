package de.timmi6790.barrier.command.commands;

import net.minecraft.client.Minecraft;
import de.timmi6790.barrier.MessageBuilder;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.command.ICommandSender;
import de.timmi6790.barrier.Cache;
import de.timmi6790.barrier.command.AbstractCommand;

public class BarrierCommand extends AbstractCommand
{
    private final Cache cache;
    
    public BarrierCommand(final Cache cache) {
        super("bar");
        this.setPrefix("Barriers");
        this.cache = cache;
    }
    
    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        this.cache.setVisibleBarrier(!this.cache.isVisibleBarrier());
        if (this.cache.isVisibleBarrier()) {
            this.tell(new MessageBuilder("Visible", EnumChatFormatting.GRAY));
        }
        else {
            this.tell(new MessageBuilder("Invisible", EnumChatFormatting.GRAY));
        }
        Minecraft.func_71410_x().field_71438_f.func_72712_a();
    }
}
