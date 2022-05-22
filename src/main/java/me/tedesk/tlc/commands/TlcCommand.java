package me.tedesk.tlc.commands;

import me.tedesk.tlc.TedeskLimpaChao;
import me.tedesk.tlc.api.ActionBarAPI;
import me.tedesk.tlc.api.BukkitAPI;
import me.tedesk.tlc.api.TitleAPI;
import me.tedesk.tlc.configs.Config;
import me.tedesk.tlc.configs.Messages;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class TlcCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cnd, String lbl, String[] args) {
        if (!(s instanceof Player)) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (s.hasPermission(Config.ADMIN)) {
                    try {
                        TedeskLimpaChao.createAndLoadConfigs();
                        s.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.RELOAD));
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("limpar")) {
                    if (s.hasPermission(Config.ADMIN)) {
                        int total = 0;
                        for (World worlds : Bukkit.getWorlds()) {
                            for (Entity items : worlds.getEntities()) {
                                if (items instanceof Item) {
                                    items.remove();
                                    BukkitAPI.sendEffectOnEntity(items, Config.EFFECT_TYPE, Config.EFFECT_DATA);
                                    total++;
                                }
                            }
                        }
                        for (Player ps : Bukkit.getOnlinePlayers()) {
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
                        return true;
                    }
                } else {
                    for (String help : Messages.HELP) {
                        s.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
                    }
                }
            }
        }
        if (s instanceof Player) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (s.hasPermission(Config.ADMIN)) {
                    try {
                        TedeskLimpaChao.createAndLoadConfigs();
                        s.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.RELOAD));
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
                if (!s.hasPermission(Config.ADMIN)) {
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.NO_PERM));
                }
                return true;
            }
            if (args[0].equalsIgnoreCase("limpar")) {
                if (s.hasPermission(Config.ADMIN)) {
                    int total = 0;
                    for (World worlds : Bukkit.getWorlds()) {
                        for (Entity items : worlds.getEntities()) {
                            if (items instanceof Item) {
                                items.remove();
                                BukkitAPI.sendEffectOnEntity(items, Config.EFFECT_TYPE, Config.EFFECT_DATA);
                                total++;
                            }
                        }
                    }
                    for (Player ps : Bukkit.getOnlinePlayers()) {
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
                    return true;
                }
                if (!s.hasPermission(Config.ADMIN)) {
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.NO_PERM));
                    return true;
                }
            } else {
                for (String help : Messages.HELP) {
                    s.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
                }
            }
        }
        return true;
    }
}
