package com.youreyesystem.listeners;

import com.youreyesystem.EyeSystemPlugin;
import com.youreyesystem.data.EyeType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        if (!player.hasPlayedBefore()) {
            EyeType randomEye = EyeType.getRandomEye();
            EyeSystemPlugin.getInstance().getAbilityManager().setPlayerEye(player.getUniqueId(), randomEye);
            
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been blessed with the " + 
                randomEye.getDisplayName() + ChatColor.LIGHT_PURPLE + "!");
            player.sendMessage(ChatColor.GRAY + "Use " + ChatColor.YELLOW + "right-click with empty hand" + 
                ChatColor.GRAY + " to use your eye power!");
            player.sendMessage(ChatColor.GRAY + "Use " + ChatColor.YELLOW + "/eye" + 
                ChatColor.GRAY + " to manage your eyes!");
        }
    }
}
