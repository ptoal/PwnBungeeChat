package com.pwn9.pwnbungeechat.cmd.commands;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.cmd.BaseCommand;
import com.pwn9.pwnbungeechat.entities.Chatter;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Verbose extends BaseCommand {

	PwnBungeeChat plugin;

	public Verbose(PwnBungeeChat plugin) {
		super("BCP Verbose");
		this.plugin = plugin;
		setDescription("Turn global chat on/off");
		setUsage("/bcp verbose");
		setArgumentRange(0, 0);
		setPermission("bungeechat.verbose");
		setIdentifiers(new String[] { "bcp verbose" });
	}

	@Override
	public boolean execute(CommandSender sender, String identifier, String[] args) {
		if (!(sender instanceof ProxiedPlayer)) {
			return false;
		}
		Chatter chatter = plugin.getChatterManager().getChatter(sender.getName());
		chatter.setVerbose();
		if (chatter.getVerbose() == true) {
			sender.sendMessage(FontFormat.translateString("&7You are now talking in &2Global Chat"));
			return true;
		} else {
			sender.sendMessage(FontFormat.translateString("&7You are no longer talking in &2Global Chat"));
			return true;
		}
	}

}
