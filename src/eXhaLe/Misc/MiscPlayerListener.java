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
    
}