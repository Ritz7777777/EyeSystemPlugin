package com.youreyesystem.listeners;

import com.youreyesystem.EyeSystemPlugin;
import com.youreyesystem.data.EyeType;
import com.youreyesystem.data.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class AbilityUseListener implements Listener {
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        
        // Activate ability on right click with empty hand
        if ((action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) && 
            player.getInventory().getItemInMainHand().getType().isAir()) {
            
            PlayerData data = EyeSystemPlugin.getInstance().getAbilityManager().getPlayerData(player.getUniqueId());
            EyeType eye = data.getCurrentEye();
            
            EyeSystemPlugin.getInstance().getAbilityManager().activateAbility(player, eye);
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage().toLowerCase();
        Player player = event.getPlayer();
        
        if (message.equals("/ability") || message.equals("/eye")) {
            event.setCancelled(true);
            PlayerData data = EyeSystemPlugin.getInstance().getAbilityManager().getPlayerData(player.getUniqueId());
            EyeType eye = data.getCurrentEye();
            
            player.sendMessage(ChatColor.GOLD + "=== Your Eye Information ===");
            player.sendMessage(ChatColor.YELLOW + "Current Eye: " + eye.getDisplayName());
            player.sendMessage(ChatColor.YELLOW + "Ability: " + ChatColor.WHITE + eye.getAbilityName());
            player.sendMessage(ChatColor.GRAY + "Right-click with empty hand to activate ability");
            player.sendMessage(ChatColor.GRAY + "Use " + ChatColor.YELLOW + "/eye select" + 
                ChatColor.GRAY + " to change your eye");
        } else if (message.equals("/eye select")) {
            event.setCancelled(true);
            EyeSystemPlugin.getInstance().getEyeUI().showEyeSelectionMenu(player);
        }
    }
}
