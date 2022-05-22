package me.tedesk.configs;

import me.tedesk.TedeskLimpaChao;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigHandler {

    public static void createConfig(String file) {
        if (!new File(TedeskLimpaChao.plugin.getDataFolder(), file + ".yml").exists()) {
            TedeskLimpaChao.plugin.saveResource(file + ".yml", false);
        }
    }

    public static FileConfiguration getConfig(String file) {
        File new_file = new File(TedeskLimpaChao.plugin.getDataFolder() + File.separator + file + ".yml");
        return YamlConfiguration.loadConfiguration(new_file);
    }
}

