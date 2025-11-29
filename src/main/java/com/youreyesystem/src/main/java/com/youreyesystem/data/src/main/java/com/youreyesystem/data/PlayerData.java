package com.youreyesystem.data;

import java.util.UUID;

public class PlayerData {
    private final UUID playerId;
    private EyeType currentEye;
    private long lastAbilityUse;
    
    public PlayerData(UUID playerId, EyeType eye) {
        this.playerId = playerId;
        this.currentEye = eye;
        this.lastAbilityUse = 0;
    }
    
    public UUID getPlayerId() {
        return playerId;
    }
    
    public EyeType getCurrentEye() {
        return currentEye;
    }
    
    public void setCurrentEye(EyeType eye) {
        this.currentEye = eye;
    }
    
    public long getLastAbilityUse() {
        return lastAbilityUse;
    }
    
    public void setLastAbilityUse(long time) {
        this.lastAbilityUse = time;
    }
    
    public boolean isOnCooldown() {
        return System.currentTimeMillis() - lastAbilityUse < getCooldownDuration();
    }
    
    public long getRemainingCooldown() {
        long elapsed = System.currentTimeMillis() - lastAbilityUse;
        long cooldown = getCooldownDuration();
        return Math.max(0, cooldown - elapsed);
    }
    
    private long getCooldownDuration() {
        return 15000L; // 15 seconds
    }
}
