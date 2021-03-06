package eXhaLe.Misc;

import java.io.File;
import java.util.HashMap;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
* Misc for Bukkit
*
* @author eXhaLe
*/
@SuppressWarnings("unused")
public class Misc extends JavaPlugin {
    private final MiscPlayerListener playerListener = new MiscPlayerListener(this);
    private final MiscBlockListener blockListener = new MiscBlockListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

    // NOTE: There should be no need to define a constructor any more for more info on moving from
    // the old constructor see:
    // http://forums.bukkit.org/threads/too-long-constructor.5032/

    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        System.out.println("Unloaded Misc plugin");
    }

    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_RIGHTCLICKED, blockListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_PLACED, blockListener, Priority.Normal, this);

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
	    if ( cmd.getName().compareToIgnoreCase("rep") == 0 )
	    {
		    if(sender instanceof Player)
		    {
		    	Player player = (Player) sender;

		    	if (args.length > 0)
		    	{
		    		// Display help
		    		if (args[0].equalsIgnoreCase("help"))
		    		{
		    			player.sendMessage("�3-- rep Help --");
		    			player.sendMessage("�5Usage: /rep <command>");
		    			player.sendMessage("�2Available commands are: �1hand, all and more");
		    		}
		    		// Repair tool in hand
		    		else if (args[0].equalsIgnoreCase("hand"))
		    		{
		    			// Add a check, is there an item in hand?
		    			player.getItemInHand().setDurability((short) 0);
		    			player.sendMessage("Tool repaired");
		    		}
		    		// Repair hole inventory if possible?
		    		else if (args[0].equalsIgnoreCase("all"))
		    		{
		    			// add code to repair all tools in inventory
		    		}
		    		// Give 1 extra of the item in hand
		    		else if (args[0].equalsIgnoreCase("more"))
		    		{
		    			// Add a check, is there an item in hand?
		    			player.getItemInHand().setAmount(player.getItemInHand().getAmount() + 1);
		    			player.sendMessage("Item in hand + 1");
		    		}
		    		// if none of the above match return usage information
		    		else
		    		{
		    			player.sendMessage("�4Incorrect usage; try /rep help for help.");
		    		}
		    	}
		
		    }
		    else
		    {
		    	System.out.println("Cannot use this command from the console.");
		    }
		    return true;
	    }

	    return false;

    }

    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}