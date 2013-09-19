package testing.commands;

import com.pwn9.pwnbungeechat.cmd.commands.Verbose;
import com.pwn9.pwnbungeechat.config.PwnBungeeChatConfig;
import com.pwn9.pwnbungeechat.config.ChannelStorage;
import com.pwn9.pwnbungeechat.config.ChatterStorage;
import com.pwn9.pwnbungeechat.entities.Channel;
import com.pwn9.pwnbungeechat.entities.Chatter;
import com.pwn9.pwnbungeechat.utils.FontFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import testing.BaseUnit;

// Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class VerboseTest extends BaseUnit {
	
	@Test
	public void execute() {
		// When pdf.getName() is called return "PwnBungeeChat"
		when(pdf.getName()).thenReturn("PwnBungeeChat");
	    // When plugin.getDescription() is called return pdf
	    when(plugin.getDescription()).thenReturn(pdf);
	    // Let's initialize our config
	    PwnBungeeChatConfig config = new PwnBungeeChatConfig(plugin);
	    // When plugin.getConfig() return config
	    when(plugin.getConfig()).thenReturn(config);
	    // When player.getName() return "Favorlock"
	    when(player.getName()).thenReturn("Favorlock");
	    // Lets create our chatter config
	    ChatterStorage storage = new ChatterStorage(plugin, player.getName());
        // Lets create our channel config
        ChannelStorage channelStorage = new ChannelStorage(plugin, "Global");
        // Lets create our channel
        Channel channel = new Channel(channelStorage);
        // When plugin.getChannelManager()
        when(plugin.getChannelManager()).thenReturn(channelManager);
        // When channelManager.getChannel("Global");
        when(channelManager.getChannel("Global")).thenReturn(channel);
        // Let's create our test chatter
	    Chatter chatter = new Chatter("Favorlock", storage);
	    // When plugin.getChatterManager
	    when(plugin.getChatterManager()).thenReturn(chatterManager);
	    // When plugin.getChatter("Favorlock") return chatter
	    when(plugin.getChatterManager().getChatter("Favorlock")).thenReturn(chatter);
	    // Initialize our command
	    Verbose command = new Verbose(plugin);
        // Set chatter.Verbose;
        chatter.setVerbose(true);
        // Execute the command
	    command.execute(player, "bcp verbose", new String[0]);
	    // Verify the string
	    verify(player).sendMessage(FontFormat.translateString("&7You are no longer talking in &2Global Chat"));
        // Set chatter.Verbose;
        chatter.setVerbose(false);
	    // Execute the command once more
	    command.execute(player, "bcp verbose", new String[0]);
        // Verify the string
	    verify(player).sendMessage(FontFormat.translateString("&7You are now talking in &2Global Chat"));
	}

}
