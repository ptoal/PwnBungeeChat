package com.pwn9.pwnbungeechat.config;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config;

import java.io.File;

public class ChannelStorage extends Config {

	private final PwnBungeeChat plugin;

	public ChannelStorage(PwnBungeeChat plugin, String name) {
		this.plugin = plugin;
		CONFIG_FILE = new File("plugins" + File.separator + plugin.getDescription().getName() + File.separator + "channels", name);
		this.Name = name.replace(".yml", "");
		this.Nick = name.substring(0, 1).toUpperCase();
		this.Format = "&8[&2%nick&8] %prefix&6%player&7%suffix: %message";
		this.Server = "";
		this.Password = "";
		this.MaxChatters = -1;
	}

	public String Name;
	public String Nick;
	public String Format;
	public String Server;
	public String Password;
	public int MaxChatters;

	public PwnBungeeChat getPlugin() {
		return this.plugin;
	}

}
