package com.youreyesystem.listeners;

import com.youreyesystem.EyeSystemPlugin;
import com.youreyesystem.data.EyeType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(ChatColor.DARK_PURPLE + "Eye Selection")) {
            event.setCancelled(true);
            
            if (event.getCurrentItem() != null && event.getWhoClicked() instanceof Player player) {
                ItemStack item = event.getCurrentItem();
                
                for (EyeType eye : EyeType.values()) {
                    if (item.getType() == eye.getMaterial()) {
                        EyeSystemPlugin.getInstance().getAbilityManager().setPlayerEye(player.getUniqueId(), eye);
                        player.sendMessage(ChatColor.GREEN + "You have selected the " + 
                            eye.getDisplayName() + ChatColor.GREEN + "!");
                        player.closeInventory();
                        break;
                    }
                }
            }
        }
    }
}
