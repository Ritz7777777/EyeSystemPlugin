package com.youreyesystem;

import com.youreyesystem.listeners.*;
import com.youreyesystem.managers.AbilityManager;
import com.youreyesystem.managers.BalanceManager;
import com.youreyesystem.managers.EyeUI;
import org.bukkit.plugin.java.JavaPlugin;

public class EyeSystemPlugin extends JavaPlugin {
    
    private static EyeSystemPlugin instance;
    private AbilityManager abilityManager;
    private BalanceManager balanceManager;
    private EyeUI eyeUI;
    
    @Override
    public void onEnable() {
        instance = this;
        
        // Initialize managers
        this.abilityManager = new AbilityManager();
        this.balanceManager = new BalanceManager();
        this.eyeUI = new EyeUI();
        
        // Save default config
        saveDefaultConfig();
        
        // Register events
        registerEvents();
        
        getLogger().info("§aEyeSystemPlugin has been enabled!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("§cEyeSystemPlugin has been disabled!");
    }
    
    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
        getServer().getPluginManager().registerEvents(new AbilityUseListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }
    
    public static EyeSystemPlugin getInstance() {
        return instance;
    }
    
    public AbilityManager getAbilityManager() {
        return abilityManager;
    }
    
    public BalanceManager getBalanceManager() {
        return balanceManager;
    }
    
    public EyeUI getEyeUI() {
        return eyeUI;
    }
}
