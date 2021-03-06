package com.pwn9.pwnbungeechat.config;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config;

import java.io.File;
import java.util.ArrayList;

public class ChatterStorage extends Config {

	private final PwnBungeeChat plugin;

	public ChatterStorage(PwnBungeeChat plugin, String name) {
		this.plugin = plugin;
		final String defChannel = plugin.getConfig().Settings_DefaultChannel;
		CONFIG_FILE = new File("plugins" + File.separator + plugin.getDescription().getName() + File.separator + "chatters" + File.separator + name.substring(0, 1).toLowerCase(), name + ".yml");
		this.Name = name;
		this.Verbose = plugin.getConfig().Settings_GlobalChatOnLogin;
		this.ActiveChannel = defChannel;
		this.Channels = new ArrayList<String>() {
			{
				add(defChannel);
			}
		};
	}

	public String Name;
	public boolean Verbose;
	public String ActiveChannel;
	public ArrayList<String> Channels;

	public PwnBungeeChat getPlugin() {
		return this.plugin;
	}

}
