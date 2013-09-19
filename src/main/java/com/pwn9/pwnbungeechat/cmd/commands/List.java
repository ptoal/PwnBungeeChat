package com.pwn9.pwnbungeechat.cmd.commands;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.cmd.BaseCommand;
import com.pwn9.pwnbungeechat.entities.Channel;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import net.md_5.bungee.api.CommandSender;

public class List extends BaseCommand {

	PwnBungeeChat plugin;

	public List(PwnBungeeChat plugin) {
		super("BCP List");
		this.plugin = plugin;
		setDescription("List all channels");
		setUsage("/bcp list");
		setArgumentRange(0, 0);
		setPermission("bungeechat.list");
		setIdentifiers(new String[] { "bcp list" });
	}

	@Override
	public boolean execute(CommandSender sender, String identifier, String[] args) {
		sender.sendMessage(FontFormat.translateString("&a-----------------------------------------------------\n" + "&eChannels"));

		for (Channel channel : plugin.getChannelManager().getChannels()) {
			if (!(channel.getMaxChatters() == -1)) {
				sender.sendMessage(FontFormat.translateString("&a" + channel.getName() + " &8-&7 " + channel.getChatters().size() + "&8/&7" + channel.getMaxChatters()));
			} else {
				sender.sendMessage(FontFormat.translateString("&a" + channel.getName() + " &8-&7 " + channel.getChatters().size() + "&8/&7" + Character.toString('\u221E')));
			}
		}

		sender.sendMessage(FontFormat.translateString("&a-----------------------------------------------------\n"));
		return true;
	}

}
