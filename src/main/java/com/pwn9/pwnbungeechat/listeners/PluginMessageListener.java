package com.pwn9.pwnbungeechat.listeners;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.entities.Channel;
import com.pwn9.pwnbungeechat.entities.Chatter;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class PluginMessageListener implements Listener {

	PwnBungeeChat plugin;

	public PluginMessageListener(PwnBungeeChat plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void receivePluginMessage(PluginMessageEvent event) throws IOException {
		if (!event.getTag().equalsIgnoreCase("PwnBungeeChat")) {
			return;
		}
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(event.getData()));
		String channel = in.readUTF();

		if (channel.equalsIgnoreCase("VaultAffix")) {
			ProxiedPlayer player = plugin.getProxyServer().getPlayer(in.readUTF());

			if (player == null) {
				return;
			}

			if (plugin.getChatterManager().getChatter(player.getName()) == null) {
				if (plugin.getProxyServer().getPlayers().contains(player)) {
					plugin.getChatterManager().loadChatter(player.getName());
				} else {
					return;
				}
			}

			Chatter chatter = plugin.getChatterManager().getChatter(player.getName());

			if (chatter == null) {
				return;
			}

			chatter.setPrefix(in.readUTF());
			chatter.setSuffix(in.readUTF());
		}

		if (channel.equalsIgnoreCase("FactionChat")) {
			String name = in.readUTF();
			String message = in.readUTF();
			ProxiedPlayer player = null;

			for (ProxiedPlayer players : plugin.getPlayers()) {
				if (name.equalsIgnoreCase(players.getName())) {
					player = players;
				}
			}

			if (player == null) {
				return;
			}

			if (plugin.getChatterManager().getChatter(player.getName()) == null) {
				if (plugin.getProxyServer().getPlayers().contains(player)) {
					plugin.getChatterManager().loadChatter(player.getName());
				} else {
					return;
				}
			}

			Chatter chatter = plugin.getChatterManager().getChatter(name);

			ChatEvent chatevent = new ChatEvent(player, event.getReceiver(), message);

			if (plugin.getConfig().Settings_EnableRegex) {
				plugin.getRegexManager().filterChat(chatevent);
			}

			Channel chatChannel = chatter.getActiveChannel();

			chatChannel.sendMessage(player, message);
		}

		if (channel.equalsIgnoreCase("Broadcast")) {
			String message = in.readUTF();

			ProxyServer.getInstance().broadcast(FontFormat.PURPLE + "[Alert] " + message);
		}
	}

}
