package me.tedesk.configs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Config {

    public static int TIME;
    public static List<Integer> WARNING_DELAY;
    public static String EFFECT_TYPE;
    public static int EFFECT_DATA;

    public static String SOUND_WARNING;
    public static String SOUND_COUNTDOWN;
    public static String SOUND_CLEAR;
    public static float SOUND_WARNING_VOLUME;
    public static float SOUND_COUNTDOWN_VOLUME;
    public static float SOUND_CLEAR_VOLUME;
    public static float SOUND_WARNING_PITCH;
    public static float SOUND_COUNTDOWN_PITCH;
    public static float SOUND_CLEAR_PITCH;

    public static void loadConfigs() {
        FileConfiguration config = ConfigHandler.getConfig("config");

        TIME = config.getInt("time.duration");
    }
}
