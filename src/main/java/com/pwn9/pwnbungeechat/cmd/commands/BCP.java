package com.pwn9.pwnbungeechat.cmd.commands;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.cmd.ICommand;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class BCP extends Command {

	PwnBungeeChat plugin;

	public BCP(PwnBungeeChat plugin) {
		super("bcp");
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            for (ICommand command : plugin.getCommandHandler().getCommands()) {
                sender.sendMessage(command.getName() + " - " + command.getDescription());
            }
        } else {
		    plugin.getCommandHandler().dispatch(sender, this.getName(), args);
        }
	}

}
