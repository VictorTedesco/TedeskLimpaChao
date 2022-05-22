package me.tedesk.runnables.bukkit;

import me.tedesk.TedeskLimpaChao;
import me.tedesk.api.ActionBarAPI;
import me.tedesk.api.TitleAPI;
import me.tedesk.configs.Config;
import me.tedesk.configs.Messages;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DroppedItemsChecker {

    public static String formatter(int time) {
        String message = null;
        if (time > 61) {
            message = (time/60) + Messages.TIME_MINUTES_PLURAL;
        }
        if (time == 60) {
            message = "1" + Messages.TIME_MINUTES_SINGULAR;
        }
        if (time < 60 && time > 1 || time == 0) {
            message = time + Messages.TIME_SECONDS_PLURAL;
        }
        if (time == 1) {
            message = time + Messages.TIME_SECONDS_SINGULAR;
        }
        return message;
    }
    public static void start() {
        new BukkitRunnable() {
            int time = Config.TIME;

            @Override
            public void run() {
                time--;
                if (Config.WARNING_DELAY.contains(time)) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        ActionBarAPI.sendActionBar(ps, ChatColor.translateAlternateColorCodes('&', Messages.AB_WARNING.replace("%tempo%", formatter(time))));
                        TitleAPI.sendTitle(ps, 1, 20, 1, Messages.TITLE_WARNING.replace("%tempo%", formatter(time)), Messages.SUBTITLE_WARNING.replace("%tempo%", formatter(time)));
                        ps.sendMessage(Messages.CHAT_WARNING.replace("%tempo%", formatter(time)));
                        ps.playSound(ps.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }
                }
                if (time < 6 && time > 1) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        ActionBarAPI.sendActionBar(ps, Messages.AB_COUNTDOWN.replace("%tempo%", time + Messages.PLURAL));
                        TitleAPI.sendTitle(ps, 1, 20, 1, Messages.TITLE_COUNTDOWN.replace("%tempo%", time + Messages.PLURAL), Messages.SUBTITLE_COUNTDOWN.replace("%tempo%", time + Messages.PLURAL));
                        ps.sendMessage(Messages.CHAT_COUNTDOWN.replace("%tempo%", time + Messages.PLURAL));
                        ps.playSound(ps.getLocation(), Sound.valueOf(Config.SOUND_COUNTDOWN), Config.SOUND_COUNTDOWN_VOLUME, Config.SOUND_COUNTDOWN_PITCH);
                    }
                }
                if (time == 1) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        ActionBarAPI.sendActionBar(ps, Messages.AB_COUNTDOWN.replace("%tempo%", time + Messages.SINGULAR));
                        TitleAPI.sendTitle(ps, 1, 20, 1, Messages.TITLE_COUNTDOWN.replace("%tempo%", time + Messages.SINGULAR), Messages.SUBTITLE_COUNTDOWN.replace("%tempo%", time + Messages.SINGULAR));
                        ps.sendMessage(Messages.CHAT_COUNTDOWN.replace("%tempo%", time + Messages.SINGULAR));
                        ps.playSound(ps.getLocation(), Sound.valueOf(Config.SOUND_COUNTDOWN), Config.SOUND_COUNTDOWN_VOLUME, Config.SOUND_COUNTDOWN_PITCH);
                    }
                }
                if (time <= 0) {
                    int total = 0;
                    for (World worlds : Bukkit.getWorlds()) {
                        for (Entity items : worlds.getEntities()) {
                            if (items instanceof Item) {
                                items.remove();
                                worlds.playEffect(items.getLocation(), Effect.valueOf(Config.EFFECT_TYPE), Config.EFFECT_DATA);
                                total++;
                            }
                        }
                    }
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        if (total == 1) {
                            ActionBarAPI.sendActionBar(ps, Messages.AB_CLEAR_SINGULAR.replace("%total%", String.valueOf(total)));
                            TitleAPI.sendTitle(ps, 1, 20,1, Messages.TITLE_CLEAR_SINGULAR.replace("%total%", String.valueOf(total)), Messages.SUBTITLE_CLEAR_SINGULAR.replace("%total%", String.valueOf(total)));
                            ps.sendMessage(Messages.CHAT_CLEAR_SINGULAR.replace("%total%", String.valueOf(total)));
                        }
                        if (total == 0 | total > 1) {
                            ActionBarAPI.sendActionBar(ps, Messages.AB_CLEAR_PLURAL.replace("%total%", String.valueOf(total)));
                            TitleAPI.sendTitle(ps, 1, 20,1, Messages.TITLE_CLEAR_PLURAL.replace("%total%", String.valueOf(total)), Messages.SUBTITLE_CLEAR_PLURAL.replace("%total%", String.valueOf(total)));
                            ps.sendMessage(Messages.CHAT_CLEAR_PLURAL.replace("%total%", String.valueOf(total)));
                        }
                        ps.playSound(ps.getLocation(), Sound.valueOf(Config.SOUND_CLEAR), Config.SOUND_CLEAR_VOLUME, Config.SOUND_CLEAR_PITCH);
                    }
                    // Antilag
                    if (Config.TIME <= 0) {
                        time = 60;
                    } else {
                        time = Config.TIME;
                    }
                }
            }
        }.runTaskTimer(TedeskLimpaChao.plugin, 20, 20);
    }
}
