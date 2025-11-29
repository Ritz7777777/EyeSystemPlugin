package com.youreyesystem.managers;

import com.youreyesystem.data.EyeType;
import com.youreyesystem.data.PlayerData;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbilityManager {
    
    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();
    
    public void activateAbility(Player player, EyeType eye) {
        PlayerData data = getPlayerData(player.getUniqueId());
        
        if (data.isOnCooldown()) {
            long remaining = data.getRemainingCooldown() / 1000;
            player.sendMessage(ChatColor.RED + "Ability on cooldown! " + remaining + "s remaining");
            return;
        }
        
        switch (eye) {
            case INFERNO_EYE:
                fireBeamAbility(player);
                break;
            case TIDAL_EYE:
                tsunamiAbility(player);
                break;
            case STORM_EYE:
                lightningAOEAbility(player);
                break;
            case NATURE_EYE:
                vineTimeStopAbility(player);
                break;
            case TERRA_EYE:
                earthSpikeAbility(player);
                break;
            case CRYSTAL_EYE:
                iceShardAbility(player);
                break;
            case VOID_EYE:
                teleportAbility(player);
                break;
            case FORCE_EYE:
                directionalPushAbility(player);
                break;
            case SONIC_EYE:
                sonicBlastAbility(player);
                break;
            case WITHER_EYE:
                witherSkullAbility(player);
                break;
        }
        
        data.setLastAbilityUse(System.currentTimeMillis());
        player.getWorld().playSound(player.getLocation(), eye.getSound(), 1.0f, 1.0f);
    }
    
    private void fireBeamAbility(Player player) {
        Location start = player.getEyeLocation();
        Vector direction = start.getDirection();
        
        for (int i = 0; i < 20; i++) {
            Location point = start.clone().add(direction.clone().multiply(i));
            
            player.getWorld().spawnParticle(Particle.FLAME, point, 3, 0.1, 0.1, 0.1, 0.02);
            player.getWorld().spawnParticle(Particle.LAVA, point, 1);
            
            point.getNearbyEntities(1, 1, 1).forEach(entity -> {
                if (entity instanceof LivingEntity living && !entity.equals(player)) {
                    living.damage(8, player);
                    living.setFireTicks(100);
                }
            });
        }
        player.sendMessage(ChatColor.RED + "Fire Beam activated!");
    }
    
    private void tsunamiAbility(Player player) {
        Location center = player.getLocation();
        
        for (int radius = 3; radius <= 8; radius++) {
            for (int degree = 0; degree < 360; degree += 10) {
                double rad = Math.toRadians(degree);
                Location particleLoc = center.clone().add(
                    Math.cos(rad) * radius,
                    0,
                    Math.sin(rad) * radius
                );
                player.getWorld().spawnParticle(Particle.WATER_SPLASH, particleLoc, 5, 0.5, 0, 0.5, 0.1);
            }
        }
        
        center.getNearbyEntities(8, 4, 8).forEach(entity -> {
            if (entity instanceof LivingEntity && !entity.equals(player)) {
                Vector push = entity.getLocation().toVector()
                    .subtract(center.toVector()).normalize().multiply(3);
                entity.setVelocity(push);
            }
        });
        player.sendMessage(ChatColor.BLUE + "Tsunami activated!");
    }
    
    private void lightningAOEAbility(Player player) {
        Location center = player.getLocation();
        
        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI * i / 5;
            Location strikeLoc = center.clone().add(
                Math.cos(angle) * 4,
                0,
                Math.sin(angle) * 4
            );
            
            player.getWorld().strikeLightningEffect(strikeLoc);
            
            strikeLoc.getNearbyEntities(3, 3, 3).forEach(entity -> {
                if (entity instanceof LivingEntity living && !entity.equals(player)) {
                    living.damage(6, player);
                }
            });
        }
        player.sendMessage(ChatColor.YELLOW + "Lightning AOE activated!");
    }
    
    private void vineTimeStopAbility(Player player) {
        Location center = player.getLocation();
        
        for (int degree = 0; degree < 360; degree += 15) {
            double rad = Math.toRadians(degree);
            Location vineLoc = center.clone().add(
                Math.cos(rad) * 5,
                0,
                Math.sin(rad) * 5
            );
            player.getWorld().spawnParticle(Particle.SPORE_BLOSSOM_AIR, vineLoc, 10);
        }
        
        center.getNearbyEntities(5, 3, 5).forEach(entity -> {
            if (entity instanceof LivingEntity living && !entity.equals(player)) {
                if (!(living instanceof Player)) {
                    living.setAI(false);
                    Bukkit.getScheduler().runTaskLater(com.youreyesystem.EyeSystemPlugin.getInstance(), 
                        () -> living.setAI(true), 60L);
                }
            }
        });
        player.sendMessage(ChatColor.GREEN + "Vine Time Stop activated!");
    }
    
    private void earthSpikeAbility(Player player) {
        Location center = player.getLocation();
        for (int i = 0; i < 8; i++) {
            double angle = 2 * Math.PI * i / 8;
            Location spikeLoc = center.clone().add(Math.cos(angle) * 3, 0, Math.sin(angle) * 3);
            player.getWorld().spawnParticle(Particle.BLOCK_CRACK, spikeLoc, 20, 0.5, 1, 0.5, 0.1, Material.DIRT.createBlockData());
            spikeLoc.getNearbyEntities(2, 2, 2).forEach(entity -> {
                if (entity instanceof LivingEntity living && !entity.equals(player)) {
                    living.damage(5, player);
                }
            });
        }
        player.sendMessage(ChatColor.DARK_GREEN + "Earth Spike activated!");
    }
    
    private void iceShardAbility(Player player) {
        Location start = player.getEyeLocation();
        Vector direction = start.getDirection();
        for (int i = 0; i < 15; i++) {
            Location point = start.clone().add(direction.clone().multiply(i));
            player.getWorld().spawnParticle(Particle.SNOWBALL, point, 2);
            point.getNearbyEntities(1, 1, 1).forEach(entity -> {
                if (entity instanceof LivingEntity living && !entity.equals(player)) {
                    living.damage(4, player);
                }
            });
        }
        player.sendMessage(ChatColor.AQUA + "Ice Shard activated!");
    }
    
    private void teleportAbility(Player player) {
        Location target = player.getTargetBlock(null, 30).getLocation().add(0, 1, 0);
        player.teleport(target);
        player.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.INVISIBILITY, 100, 1));
        player.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.JUMP_BOOST, 100, 2));
        player.sendMessage(ChatColor.DARK_PURPLE + "Void Teleport activated!");
    }
    
    private void directionalPushAbility(Player player) {
        player.getNearbyEntities(5, 3, 5).forEach(entity -> {
            Vector direction = entity.getLocation().toVector().subtract(player.getLocation().toVector()).normalize();
            entity.setVelocity(direction.multiply(2));
        });
        player.sendMessage(ChatColor.WHITE + "Force Push activated!");
    }
    
    private void sonicBlastAbility(Player player) {
        Location center = player.getLocation();
        center.getNearbyEntities(6, 3, 6).forEach(entity -> {
            if (entity instanceof Player targetPlayer && !targetPlayer.equals(player)) {
                targetPlayer.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.NAUSEA, 100, 1));
                targetPlayer.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.BLINDNESS, 60, 1));
            }
        });
        player.getWorld().spawnParticle(Particle.SONIC_BOOM, center, 10, 3, 2, 3);
        player.sendMessage(ChatColor.DARK_GRAY + "Sonic Blast activated!");
    }
    
    private void witherSkullAbility(Player player) {
        Location start = player.getEyeLocation();
        Vector direction = start.getDirection();
        for (int i = 0; i < 3; i++) {
            Location skullLoc = start.clone().add(direction.clone().multiply(i * 2));
            player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, skullLoc, 5);
            skullLoc.getNearbyEntities(2, 2, 2).forEach(entity -> {
                if (entity instanceof LivingEntity living && !entity.equals(player)) {
                    living.damage(7, player);
                    living.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.WITHER, 100, 1));
                }
            });
        }
        player.sendMessage(ChatColor.BLACK + "Wither Skull activated!");
    }
    
    public PlayerData getPlayerData(UUID playerId) {
        return playerDataMap.computeIfAbsent(playerId, id -> new PlayerData(id, EyeType.INFERNO_EYE));
    }
    
    public void setPlayerEye(UUID playerId, EyeType eye) {
        PlayerData data = getPlayerData(playerId);
        data.setCurrentEye(eye);
    }
}
