package testing;

import com.pwn9.pwnbungeechat.PwnBungeeChat;
import com.pwn9.pwnbungeechat.ChannelManager;
import com.pwn9.pwnbungeechat.ChatterManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.PluginDescription;

import static org.mockito.Mockito.mock;

public abstract class BaseUnit {
	
	public PluginDescription pdf;
	public PwnBungeeChat plugin;
	public ChatterManager chatterManager;
    public ChannelManager channelManager;
	public ProxiedPlayer player;
	
	public BaseUnit() {
		pdf = mock(PluginDescription.class);
		plugin = mock(PwnBungeeChat.class);
		chatterManager = mock(ChatterManager.class);
        channelManager = mock(ChannelManager.class);
		player = mock(ProxiedPlayer.class);
	}

}
