package com.pwn9.pwnbungeechat.utils;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.entities.Channel;
import com.pwn9.pwnbungeechat.entities.Chatter;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ChatFormat {

	public static String formatMessage(String message, PwnBungeeChat plugin, ProxiedPlayer sender, Chatter chatter, Channel channel) {
		String outputMessage = channel.getFormat();
		outputMessage = outputMessage.replace("%nick", channel.getNick());
		outputMessage = outputMessage.replace("%server", sender.getServer().getInfo().getName());
		if (chatter.getPrefix() != null) {
			outputMessage = outputMessage.replace("%prefix", chatter.getPrefix());
		} else {
			outputMessage = outputMessage.replace("%prefix", "");
		}
		outputMessage = outputMessage.replace("%player", chatter.getName());
		if (chatter.getSuffix() != null) {
			outputMessage = outputMessage.replace("%suffix", chatter.getSuffix());
		} else {
			outputMessage = outputMessage.replace("%suffix", "");
		}
		outputMessage = outputMessage.replace("%message", message);

		return outputMessage;
	}

}
