package eXhaLe.Misc;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockRightClickEvent;
import org.bukkit.block.CreatureSpawner;

/**
* Misc block listener
* @author eXhaLe
*/
@SuppressWarnings("unused")
public class MiscBlockListener extends BlockListener {
	private final Misc plugin;

    public MiscBlockListener(final Misc plugin) {
        this.plugin = plugin;
    }
    
    public void onBlockRightClick(BlockRightClickEvent event)
    {
		Block block = event.getBlock();
		if (block.getType() == Material.BED_BLOCK)
		{
			   	event.getPlayer().setHealth(20);
				event.getPlayer().sendMessage("Health restored");
		}
    }
    
    public void getMobSpawner(int num)
    {
    	
    }

}