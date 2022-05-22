package me.tedesk.tlc.api;

import me.tedesk.tlc.TedeskLimpaChao;
import me.tedesk.tlc.configs.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class BukkitAPI {

    public static void sendSoundToPlayer(Player p, String sound, float volume, float pitch) {
        try {
            p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
        } catch (Exception e) {
            TedeskLimpaChao.logger(ChatColor.translateAlternateColorCodes('&', Messages.SOUND_ERROR.replace("%som%", sound)));
        }
    }
    public static void sendEffectOnEntity(Entity entity, String effect, int data) {
        try {
            entity.getWorld().playEffect(entity.getLocation(), Effect.valueOf(effect), data);
        } catch (Exception ignored) {

        }
    }
}
