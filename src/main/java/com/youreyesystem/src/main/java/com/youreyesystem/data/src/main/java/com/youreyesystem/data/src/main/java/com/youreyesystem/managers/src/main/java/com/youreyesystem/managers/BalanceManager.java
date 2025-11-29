package com.youreyesystem.managers;

import com.youreyesystem.data.EyeType;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class BalanceManager {
    
    private final Map<EntityType, Double> dropRates = new HashMap<>();
    private final Map<EyeType, AbilityStats> abilityStats = new HashMap<>();
    
    public BalanceManager() {
        initializeDropRates();
        initializeAbilityStats();
    }
    
    private void initializeDropRates() {
        dropRates.put(EntityType.ZOMBIE, 0.15);
        dropRates.put(EntityType.SKELETON, 0.12);
        dropRates.put(EntityType.CREEPER, 0.20);
        dropRates.put(EntityType.ENDERMAN, 0.25);
        dropRates.put(EntityType.WITHER_SKELETON, 0.30);
        dropRates.put(EntityType.BLAZE, 0.18);
        dropRates.put(EntityType.WARDEN, 0.50);
    }
    
    private void initializeAbilityStats() {
        abilityStats.put(EyeType.INFERNO_EYE, new AbilityStats(8, 15, 20));
        abilityStats.put(EyeType.TIDAL_EYE, new AbilityStats(0, 12, 15));
        abilityStats.put(EyeType.STORM_EYE, new AbilityStats(6, 18, 25));
        abilityStats.put(EyeType.NATURE_EYE, new AbilityStats(0, 25, 30));
        abilityStats.put(EyeType.TERRA_EYE, new AbilityStats(7, 16, 22));
        abilityStats.put(EyeType.CRYSTAL_EYE, new AbilityStats(5, 10, 18));
        abilityStats.put(EyeType.VOID_EYE, new AbilityStats(0, 30, 15));
        abilityStats.put(EyeType.FORCE_EYE, new AbilityStats(3, 8, 12));
        abilityStats.put(EyeType.SONIC_EYE, new AbilityStats(4, 20, 28));
        abilityStats.put(EyeType.WITHER_EYE, new AbilityStats(9, 22, 35));
    }
    
    public Double getDropRate(EntityType entityType) {
        return dropRates.get(entityType);
    }
    
    public AbilityStats getAbilityStats(EyeType eyeType) {
        return abilityStats.get(eyeType);
    }
    
    public static class AbilityStats {
        private final double damage;
        private final int cooldown;
        private final int manaCost;
        
        public AbilityStats(double damage, int cooldown, int manaCost) {
            this.damage = damage;
            this.cooldown = cooldown;
            this.manaCost = manaCost;
        }
        
        public double getDamage() { return damage; }
        public int getCooldown() { return cooldown; }
        public int getManaCost() { return manaCost; }
    }
}
