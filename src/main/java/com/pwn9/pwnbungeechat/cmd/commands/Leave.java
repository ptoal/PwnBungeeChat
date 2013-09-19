package com.pwn9.pwnbungeechat.cmd.commands;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.cmd.BaseCommand;
import com.pwn9.pwnbungeechat.entities.Channel;
import com.pwn9.pwnbungeechat.entities.Chatter;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Leave extends BaseCommand {

	PwnBungeeChat plugin;

	public Leave(PwnBungeeChat plugin) {
		super("BCP Leave");
		this.plugin = plugin;
		setDescription("Leave a channel");
		setUsage("/bcp leave <channel>");
		setArgumentRange(1, 1);
		setPermission("bungeechat.leave");
		setIdentifiers(new String[] { "bcp leave" });
	}

	@Override
	public boolean execute(CommandSender sender, String identifier, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return false;
		}
		Chatter chatter = plugin.getChatterManager().getChatter(sender.getName());
		if (chatter == null) {
			return false;
		}
		Channel channel = plugin.getChannelManager().getChannel(args[0]);
		if (channel == null) {
			sender.sendMessage(FontFormat.translateString("&eThe channel &2" + args[0] + "&e does not exist"));
			return false;
		}
		if (chatter.removeChannel(channel)) {
			channel.getChatters().remove(chatter);
			sender.sendMessage(FontFormat.translateString("&eYou are no longer in channel &2" + channel.getName()));
			return true;
		}
		sender.sendMessage(FontFormat.translateString("&2You are not in channel &2" + channel.getName()));
		return false;
	}

}
