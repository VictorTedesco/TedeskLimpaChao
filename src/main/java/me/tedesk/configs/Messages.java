package me.tedesk.configs;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Messages {
    public static List<String> INCOMPATIBLE;
    public static List<String> ENABLED;
    public static List<String> DISABLED;
    public static String TIME_MINUTES_SINGULAR;
    public static String TIME_MINUTES_PLURAL;
    public static String TIME_SECONDS_SINGULAR;
    public static String TIME_SECONDS_PLURAL;
    public static String AB_WARNING;
    public static String AB_COUNTDOWN;
    public static String AB_CLEAR_SINGULAR;
    public static String AB_CLEAR_PLURAL;
    public static String TITLE_WARNING;
    public static String TITLE_COUNTDOWN;
    public static String TITLE_CLEAR_SINGULAR;
    public static String TITLE_CLEAR_PLURAL;
    public static String SUBTITLE_WARNING;
    public static String SUBTITLE_COUNTDOWN;
    public static String SUBTITLE_CLEAR_SINGULAR;
    public static String SUBTITLE_CLEAR_PLURAL;
    public static String CHAT_WARNING;
    public static String CHAT_COUNTDOWN;
    public static String CHAT_CLEAR_SINGULAR;
    public static String CHAT_CLEAR_PLURAL;
    public static String SINGULAR;
    public static String PLURAL;
    public static List<String> HELP;
    public static String RELOAD;
    public static String NO_PERM;

    public static void loadMessages() {
        FileConfiguration messages = ConfigHandler.getConfig("messages");

        INCOMPATIBLE = messages.getStringList("plugin.incompatible");
        ENABLED = messages.getStringList("plugin.enabled");
        DISABLED = messages.getStringList("plugin.disabled");


        SINGULAR = messages.getString("time.singular");
        PLURAL = messages.getString("time.plural");

        HELP = messages.getStringList("commands.help");
        RELOAD = messages.getString("commands.reload");
        NO_PERM = messages.getString("commands.no-perm");
    }
}
