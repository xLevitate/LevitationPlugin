package me.levitate.levitation.managers;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class LevitationManager {

    // HashMap that stores the levitation status of each player
    public final HashMap<Player, Boolean> isLevitating = new HashMap<>();

    /**
     * Sets the levitation status of a player.
     * @param plr The player to set the levitation status of.
     * @param levitating The levitation status to set.
     */
    public void setLevitating(Player plr, Boolean levitating) {
        isLevitating.put(plr, levitating);

        if (isLevitating.get(plr)) {
            // Adds the Levitation effect
            plr.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 999999, 1));
        }
        else {
            // Removes the Levitation effect
            plr.removePotionEffect(PotionEffectType.LEVITATION);
        }
    }

    /**
     * Spawns the particles around every player that is levitating.
     */
    public void spawnParticles() {
        for (Map.Entry<Player, Boolean> entry : isLevitating.entrySet()) {
            if (entry.getValue()) {
                entry.getKey().spawnParticle(Particle.CLOUD, entry.getKey().getLocation(), 5);
            }
        }
    }

}
