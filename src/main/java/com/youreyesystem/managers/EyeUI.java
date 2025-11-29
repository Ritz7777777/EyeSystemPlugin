package com.youreyesystem.managers;

import com.youreyesystem.data.EyeType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EyeUI {
    
    public void showEyeSelectionMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "Eye Selection");
        
        for (EyeType eye : EyeType.values()) {
            ItemStack eyeItem = new ItemStack(eye.getMaterial());
            ItemMeta meta = eyeItem.getItemMeta();
            meta.setDisplayName(eye.getDisplayName());
            
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Ability: " + ChatColor.WHITE + eye.getAbilityName());
            lore.add(ChatColor.GRAY + "Right-click with empty hand to activate");
            lore.add("");
            lore.add(ChatColor.YELLOW + "Click to select this eye");
            meta.setLore(lore);
            
            eyeItem.setItemMeta(meta);
            gui.addItem(eyeItem);
        }
        
        player.openInventory(gui);
    }
}
