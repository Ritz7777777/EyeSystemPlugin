package com.youreyesystem.listeners;

import com.youreyesystem.EyeSystemPlugin;
import com.youreyesystem.data.EyeType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathListener implements Listener {
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() instanceof Player player) {
            Double dropRate = EyeSystemPlugin.getInstance().getBalanceManager().getDropRate(event.getEntityType());
            
            if (dropRate != null && Math.random() < dropRate) {
                EyeType randomEye = EyeType.getRandomEye();
                EyeSystemPlugin.getInstance().getAbilityManager().setPlayerEye(player.getUniqueId(), randomEye);
                
                player.sendMessage(ChatColor.GOLD + "You obtained the " + 
                    randomEye.getDisplayName() + ChatColor.GOLD + " eye!");
            }
        }
    }
}
