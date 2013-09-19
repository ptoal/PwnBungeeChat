package com.pwn9.pwnbungeechat.cmd.commands;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.cmd.BaseCommand;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import net.md_5.bungee.api.CommandSender;

public class Delete extends BaseCommand {

	PwnBungeeChat plugin;

	public Delete(PwnBungeeChat plugin) {
		super("BCP Delete");
		this.plugin = plugin;
		setDescription("Delete a channel");
		setUsage("/bcp delete <channel>");
		setArgumentRange(1, 1);
		setPermission("bungeechat.delete");
		setIdentifiers(new String[] { "bcp delete" });
	}

	@Override
	public boolean execute(CommandSender sender, String identifier, String[] args) {
		if (plugin.getChannelManager().removeChannel(args[0])) {
			sender.sendMessage(FontFormat.translateString("&eThe channel has been deleted!"));
			return true;
		}
		sender.sendMessage(FontFormat.translateString("&4The channel does not exist!"));
		return false;
	}

}
