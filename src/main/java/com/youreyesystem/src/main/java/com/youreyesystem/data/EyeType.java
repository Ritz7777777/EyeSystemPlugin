package com.youreyesystem.data;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public enum EyeType {
    INFERNO_EYE("Inferno Eye", ChatColor.RED, "Fire Beam", Material.RED_DYE, Particle.FLAME, Sound.ITEM_FIRECHARGE_USE),
    TIDAL_EYE("Tidal Eye", ChatColor.BLUE, "Mini Tsunami", Material.BLUE_DYE, Particle.WATER_SPLASH, Sound.BLOCK_WATER_AMBIENT),
    STORM_EYE("Storm Eye", ChatColor.YELLOW, "Lightning AOE", Material.YELLOW_DYE, Particle.ELECTRIC_SPARK, Sound.ENTITY_LIGHTNING_BOLT_THUNDER),
    NATURE_EYE("Nature Eye", ChatColor.GREEN, "Vine Time Stop", Material.GREEN_DYE, Particle.SPORE_BLOSSOM_AIR, Sound.BLOCK_GROWING_PLANT_CROP),
    TERRA_EYE("Terra Eye", ChatColor.DARK_GREEN, "Earth Spike", Material.BROWN_DYE, Particle.BLOCK_CRACK, Sound.BLOCK_GRAVEL_BREAK),
    CRYSTAL_EYE("Crystal Eye", ChatColor.AQUA, "Ice Shard", Material.LIGHT_BLUE_DYE, Particle.SNOWBALL, Sound.BLOCK_GLASS_BREAK),
    VOID_EYE("Void Eye", ChatColor.DARK_PURPLE, "Teleportation", Material.PURPLE_DYE, Particle.PORTAL, Sound.ENTITY_ENDERMAN_TELEPORT),
    FORCE_EYE("Force Eye", ChatColor.WHITE, "Directional Push", Material.WHITE_DYE, Particle.CLOUD, Sound.ENTITY_BREEZE_WIND_CHARGE),
    SONIC_EYE("Sonic Eye", ChatColor.DARK_GRAY, "Sonic Blast", Material.GRAY_DYE, Particle.SONIC_BOOM, Sound.ENTITY_WARDEN_SONIC_BOOM),
    WITHER_EYE("Wither Eye", ChatColor.BLACK, "Wither Skull", Material.BLACK_DYE, Particle.SOUL_FIRE_FLAME, Sound.ENTITY_WITHER_SHOOT);
    
    private final String displayName;
    private final ChatColor color;
    private final String abilityName;
    private final Material material;
    private final Particle particle;
    private final Sound sound;
    
    EyeType(String displayName, ChatColor color, String abilityName, Material material, Particle particle, Sound sound) {
        this.displayName = displayName;
        this.color = color;
        this.abilityName = abilityName;
        this.material = material;
        this.particle = particle;
        this.sound = sound;
    }
    
    public String getDisplayName() {
        return color + displayName;
    }
    
    public ChatColor getColor() {
        return color;
    }
    
    public String getAbilityName() {
        return abilityName;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public Particle getParticle() {
        return particle;
    }
    
    public Sound getSound() {
        return sound;
    }
    
    public static EyeType getRandomEye() {
        return values()[(int) (Math.random() * values().length)];
    }
}
