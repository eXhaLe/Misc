package eXhaLe.Misc;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerItemEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerListener;

/**
* Handle events for all Player related events
* @author eXhaLe
*/
@SuppressWarnings("unused")
public class MiscPlayerListener extends PlayerListener {
    private final Misc plugin;

    public MiscPlayerListener(Misc instance) {
        plugin = instance;
    }
    
    public boolean onPlayerCommand(Player player, String[] split)
    {
    	//String[] split = event.getMessage().split(" ");
    	//Player player = event.getPlayer();
    	// This is something we need to worry about, right?
    	if (split[0].equalsIgnoreCase("/rep") && split.length > 1)
    	{
    		// Help command
    		if (split[1].equalsIgnoreCase("help"))
    		{
    			player.sendMessage("§3-- rep Help --");

    		}

    		// List of portals
    		else if (split[1].equalsIgnoreCase("hand"))
    		{
    			player.getItemInHand().setDurability((short) 0);
    			player.sendMessage("In hand tool is repaired");
    		}
    		else if (split[1].equalsIgnoreCase("more"))
    		{
    			player.getItemInHand().setAmount(player.getItemInHand().getAmount() + 1);
    			player.sendMessage("Its Now + 1");
    		}
    		else if (split[1].equalsIgnoreCase("mob"))
    		{
    			
    			player.sendMessage("Mobspawner...");
    		}
    		else
    		{
    			player.sendMessage("§4Incorrect usage; try /rep help for help.");
    		}
    		return true;
    	}
    	return false;
    }
}