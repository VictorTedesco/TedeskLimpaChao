package me.tedesk.tlc.configs;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Config {
    public static List<String> BLACKLISTED_WORLDS;
    public static int TIME;
    public static List<Integer> WARNING_DELAY;
    public static String ADMIN;
    public static List<String> TYPES_WARNING;
    public static List<String> TYPES_COUNTDOWN;
    public static List<String> TYPES_CLEAR;
    public static String SOUND_WARNING;
    public static String SOUND_COUNTDOWN;
    public static String SOUND_CLEAR;
    public static float SOUND_WARNING_VOLUME;
    public static float SOUND_COUNTDOWN_VOLUME;
    public static float SOUND_CLEAR_VOLUME;
    public static float SOUND_WARNING_PITCH;
    public static float SOUND_COUNTDOWN_PITCH;
    public static float SOUND_CLEAR_PITCH;
    public static String EFFECT_TYPE;
    public static int EFFECT_DATA;

    public static void loadConfigs() {
        FileConfiguration config = ConfigHandler.getConfig("config");

        BLACKLISTED_WORLDS = config.getStringList("mundos-imunes");
        TIME = config.getInt("tempo.total");
        WARNING_DELAY = config.getIntegerList("tempo.avisos");

        ADMIN = config.getString("perms.admin");

        TYPES_WARNING = config.getStringList("tipo.aviso");
        TYPES_COUNTDOWN = config.getStringList("tipo.contagem");
        TYPES_CLEAR = config.getStringList("tipo.limpo");

        SOUND_WARNING = config.getString("sons.tipo.aviso");
        SOUND_COUNTDOWN = config.getString("sons.tipo.contagem");
        SOUND_CLEAR = config.getString("sons.tipo.limpo");

        SOUND_WARNING_VOLUME = (float) config.getDouble("sons.volume.aviso");
        SOUND_COUNTDOWN_VOLUME = (float) config.getDouble("sons.volume.contagem");
        SOUND_CLEAR_VOLUME = (float) config.getDouble("sons.volume.limpo");

        SOUND_WARNING_PITCH = (float) config.getDouble("sons.pitch.aviso");
        SOUND_COUNTDOWN_PITCH = (float) config.getDouble("sons.pitch.contagem");
        SOUND_CLEAR_PITCH = (float) config.getDouble("sons.pitch.limpo");

        EFFECT_TYPE = config.getString("efeitos.tipo");
        EFFECT_DATA = config.getInt("efeitos.data");
    }
}
