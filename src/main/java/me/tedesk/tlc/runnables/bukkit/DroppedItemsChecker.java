package me.tedesk.tlc.runnables.bukkit;

import me.tedesk.tlc.TedeskLimpaChao;
import me.tedesk.tlc.api.ActionBarAPI;
import me.tedesk.tlc.api.BukkitAPI;
import me.tedesk.tlc.api.TitleAPI;
import me.tedesk.tlc.configs.Config;
import me.tedesk.tlc.configs.Messages;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class DroppedItemsChecker {

    public static String formatter(int time) {
        String message = null;

        if (time == 1) {
            message = time + Messages.TIME_SECONDS_SINGULAR;
        }
        if (time < 60 && time > 1 || time == 0) {
            message = time + Messages.TIME_SECONDS_PLURAL;
        }
        if (time >= 60) {
            message = "1" + Messages.TIME_MINUTES_SINGULAR;
        }
        if (time > 119) {
            message = (time/60) + Messages.TIME_MINUTES_PLURAL;
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
                        if (!Config.BLACKLISTED_WORLDS.contains(ps.getWorld().getName())) {
                            if (Config.TYPES_WARNING.contains("ACTIONBAR")) {
                                ActionBarAPI.sendActionBar(ps, ChatColor.translateAlternateColorCodes('&', Messages.AB_WARNING.replace("%tempo%", formatter(time))));
                            }
                            if (Config.TYPES_WARNING.contains("TITLE")) {
                                TitleAPI.sendTitle(ps, 1, 20, 1, ChatColor.translateAlternateColorCodes('&', Messages.TITLE_WARNING.replace("%tempo%", formatter(time))), ChatColor.translateAlternateColorCodes('&', Messages.SUBTITLE_WARNING.replace("%tempo%", formatter(time))));
                            }
                            if (Config.TYPES_WARNING.contains("CHAT")) {
                                ps.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.CHAT_WARNING.replace("%tempo%", formatter(time))));
                            }
                            BukkitAPI.sendSoundToPlayer(ps, Config.SOUND_WARNING, Config.SOUND_WARNING_VOLUME, Config.SOUND_WARNING_PITCH);
                        }
                    }
                }
                if (time < 6 && time > 1) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        if (!Config.BLACKLISTED_WORLDS.contains(ps.getWorld().getName())) {
                            if (Config.TYPES_COUNTDOWN.contains("ACTIONBAR")) {
                                ActionBarAPI.sendActionBar(ps, ChatColor.translateAlternateColorCodes('&', Messages.AB_COUNTDOWN.replace("%tempo%", formatter(time))));
                            }
                            if (Config.TYPES_COUNTDOWN.contains("TITLE")) {
                                TitleAPI.sendTitle(ps, 1, 20, 1, ChatColor.translateAlternateColorCodes('&', Messages.TITLE_COUNTDOWN.replace("%tempo%", formatter(time))), ChatColor.translateAlternateColorCodes('&', Messages.SUBTITLE_COUNTDOWN.replace("%tempo%", formatter(time))));
                            }
                            if (Config.TYPES_COUNTDOWN.contains("CHAT")) {
                                ps.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.CHAT_COUNTDOWN.replace("%tempo%", formatter(time))));
                            }
                            BukkitAPI.sendSoundToPlayer(ps, Config.SOUND_COUNTDOWN, Config.SOUND_COUNTDOWN_VOLUME, Config.SOUND_COUNTDOWN_PITCH);
                        }
                    }
                }
                if (time == 1) {
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        if (!Config.BLACKLISTED_WORLDS.contains(ps.getWorld().getName())) {
                            if (Config.TYPES_COUNTDOWN.contains("ACTIONBAR")) {
                                ActionBarAPI.sendActionBar(ps, ChatColor.translateAlternateColorCodes('&', Messages.AB_COUNTDOWN.replace("%tempo%", formatter(time))));
                            }
                            if (Config.TYPES_COUNTDOWN.contains("TITLE")) {
                                TitleAPI.sendTitle(ps, 1, 20, 1, ChatColor.translateAlternateColorCodes('&', Messages.TITLE_COUNTDOWN.replace("%tempo%", formatter(time))), ChatColor.translateAlternateColorCodes('&', Messages.SUBTITLE_COUNTDOWN.replace("%tempo%", formatter(time))));
                            }
                            if (Config.TYPES_COUNTDOWN.contains("CHAT")) {
                                ps.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.CHAT_COUNTDOWN.replace("%tempo%", formatter(time))));
                            }
                            BukkitAPI.sendSoundToPlayer(ps, Config.SOUND_COUNTDOWN, Config.SOUND_COUNTDOWN_VOLUME, Config.SOUND_COUNTDOWN_PITCH);
                        }
                    }
                }
                if (time <= 0) {
                    int total = 0;
                    for (World worlds : Bukkit.getWorlds()) {
                        if (!Config.BLACKLISTED_WORLDS.contains(worlds.getName())) {
                            for (Entity items : worlds.getEntities()) {
                                if (items instanceof Item) {
                                    items.remove();
                                    BukkitAPI.sendEffectOnEntity(items, Config.EFFECT_TYPE, Config.EFFECT_DATA);
                                    total++;
                                }
                            }
                        }
                    }
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        if (!Config.BLACKLISTED_WORLDS.contains(ps.getWorld().getName())) {
                            if (total == 1) {
                                if (Config.TYPES_CLEAR.contains("ACTIONBAR")) {
                                    ActionBarAPI.sendActionBar(ps, ChatColor.translateAlternateColorCodes('&', Messages.AB_CLEAR_SINGULAR.replace("%total%", String.valueOf(total))));
                                }
                                if (Config.TYPES_CLEAR.contains("TITLE")) {
                                    TitleAPI.sendTitle(ps, 1, 20, 1, ChatColor.translateAlternateColorCodes('&', Messages.TITLE_CLEAR_SINGULAR.replace("%total%", String.valueOf(total))), ChatColor.translateAlternateColorCodes('&', Messages.SUBTITLE_CLEAR_SINGULAR.replace("%total%", String.valueOf(total))));
                                }
                                if (Config.TYPES_CLEAR.contains("CHAT")) {
                                    ps.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.CHAT_CLEAR_SINGULAR.replace("%total%", String.valueOf(total))));
                                }
                            }
                            if (total == 0 | total > 1) {
                                if (Config.TYPES_CLEAR.contains("ACTIONBAR")) {
                                    ActionBarAPI.sendActionBar(ps, ChatColor.translateAlternateColorCodes('&', Messages.AB_CLEAR_PLURAL.replace("%total%", String.valueOf(total))));
                                }
                                if (Config.TYPES_CLEAR.contains("TITLE")) {
                                    TitleAPI.sendTitle(ps, 1, 20, 1, ChatColor.translateAlternateColorCodes('&', Messages.TITLE_CLEAR_PLURAL.replace("%total%", String.valueOf(total))), ChatColor.translateAlternateColorCodes('&', Messages.SUBTITLE_CLEAR_PLURAL.replace("%total%", String.valueOf(total))));
                                }
                                if (Config.TYPES_CLEAR.contains("CHAT")) {
                                    ps.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.CHAT_CLEAR_PLURAL.replace("%total%", String.valueOf(total))));
                                }
                            }
                            BukkitAPI.sendSoundToPlayer(ps, Config.SOUND_CLEAR, Config.SOUND_CLEAR_VOLUME, Config.SOUND_CLEAR_PITCH);
                        }
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
