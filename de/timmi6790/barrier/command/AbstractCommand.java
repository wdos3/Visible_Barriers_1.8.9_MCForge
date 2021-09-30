package de.timmi6790.barrier.command;

import net.minecraft.util.EnumChatFormatting;
import de.timmi6790.barrier.MessageBuilder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.ICommandSender;
import com.google.common.base.Preconditions;
import lombok.NonNull;
import net.minecraft.command.CommandBase;

public abstract class AbstractCommand extends CommandBase
{
    private final String name;
    private String prefix;
    
    public AbstractCommand(final String name) {
        this(name, null);
    }
    
    public AbstractCommand(@NonNull final String name, final String prefix) {
        Preconditions.checkNotNull((Object)name, (Object)"name is marked non-null but is null");
        this.name = name;
        this.prefix = prefix;
    }
    
    public int func_82362_a() {
        return 0;
    }
    
    public String func_71517_b() {
        return this.name;
    }
    
    public String func_71518_a(final ICommandSender sender) {
        return "/" + this.name;
    }
    
    public List<String> func_71514_a() {
        return new ArrayList<String>();
    }
    
    public void func_71515_b(final ICommandSender sender, final String[] args) {
        this.onCommand(sender, args);
    }
    
    public abstract void onCommand(final ICommandSender p0, final String[] p1);
    
    protected void tell(final MessageBuilder message) {
        new MessageBuilder("").addMessage((this.prefix != null) ? (this.prefix + "> ") : "", EnumChatFormatting.BLUE).addMessage(message).sendToPlayer();
    }
    
    protected void setPrefix(final String prefix) {
        this.prefix = prefix;
    }
}
