package me.tedesk;

import me.tedesk.configs.Config;
import me.tedesk.configs.ConfigHandler;
import me.tedesk.configs.Messages;
import me.tedesk.runnables.Runnables;
import me.tedesk.utils.Version;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TedeskLimpaChao extends JavaPlugin {

    public static TedeskLimpaChao plugin;
    public static Version version;
    PluginDescriptionFile pdf = this.getDescription();

    public static void logger(String text) {
        Bukkit.getConsoleSender().sendMessage("[TedeskLimpaChao] " + text);
    }

    public static void createAndLoadConfigs() {
        ConfigHandler.createConfig("config");
        Config.loadConfigs();
        ConfigHandler.createConfig("messages");
        Messages.loadMessages();
    }

    public static boolean veryNewVersion() {
        if (version == Version.v1_19)
            return true;
        if (version == Version.v1_18)
            return true;
        if (version == Version.v1_17)
            return true;
        return false;
    }

    public static boolean newVersion() {
        if (version == Version.v1_16)
            return true;
        if (version == Version.v1_15)
            return true;
        if (version == Version.v1_14)
            return true;
        if (version == Version.v1_13)
            return true;
        if (version == Version.v1_12)
            return true;
        return false;
    }

    public static boolean oldVersion() {
        if (version == Version.v1_11)
            return true;
        if (version == Version.v1_10)
            return true;
        if (version == Version.v1_9)
            return true;
        if (version == Version.v1_8)
            return true;
        return false;
    }

    @Override
    public void onEnable() {
        plugin = this;
        version = Version.getServerVersion();

        if (version == Version.UNKNOWN) {
            for (String incompatible : Messages.INCOMPATIBLE) {
                logger(ChatColor.translateAlternateColorCodes('&', incompatible).replace("%server_version%", "(" + Version.getServerVersion() + ")"));
            }
        }
        createAndLoadConfigs();
        Runnables.setup();
        for (String enabled : Messages.ENABLED) {
            logger(ChatColor.translateAlternateColorCodes('&', enabled).replace("&", "§").replace("%plugin_version%", "(v" + pdf.getVersion() + ")"));
        }
        if (veryNewVersion() || newVersion() || oldVersion()) {
            logger("§fMinecraft " + version.toString().replace("_", ".").replace("v", ""));
        }
    }

    @Override
    public void onDisable() {
        for (String disabled : Messages.DISABLED) {
            logger(ChatColor.translateAlternateColorCodes('&', disabled).replace("%plugin_version%", "(v" + pdf.getVersion() + ")"));
        }
    }
}
