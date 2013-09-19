package com.pwn9.pwnbungeechat.cmd.commands;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.cmd.BaseCommand;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import net.md_5.bungee.api.CommandSender;

public class Create extends BaseCommand {

	PwnBungeeChat plugin;

	public Create(PwnBungeeChat plugin) {
		super("BCP Create");
		this.plugin = plugin;
		setDescription("Create a new channel");
		setUsage("/bcp create <channel>");
		setArgumentRange(1, 1);
		setPermission("bungeechat.create");
		setIdentifiers(new String[] { "bcp create" });
	}

	@Override
	public boolean execute(CommandSender sender, String identifier, String[] args) {
		if (plugin.getChannelManager().addChannel(args[0])) {
			sender.sendMessage(FontFormat.translateString("&eThe channel has been created!"));
			return true;
		}
		sender.sendMessage(FontFormat.translateString("&4The channel already exist!"));
		return false;
	}

}
