package me.tedesk.tlc.configs;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class Messages {
    public static List<String> INCOMPATIBLE;
    public static List<String> ENABLED;
    public static List<String> DISABLED;
    public static String SOUND_ERROR;
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
    public static List<String> HELP;
    public static String RELOAD;
    public static String NO_PERM;

    public static void loadMessages() {
        FileConfiguration messages = ConfigHandler.getConfig("messages");

        INCOMPATIBLE = messages.getStringList("plugin.incompativel");
        ENABLED = messages.getStringList("plugin.ativado");
        DISABLED = messages.getStringList("plugin.desativado");
        SOUND_ERROR = messages.getString("plugin.erro-som");

        TIME_MINUTES_SINGULAR = messages.getString("tempo.minutos.singular");
        TIME_MINUTES_PLURAL = messages.getString("tempo.minutos.plural");
        TIME_SECONDS_SINGULAR = messages.getString("tempo.segundos.singular");
        TIME_SECONDS_PLURAL = messages.getString("tempo.segundos.plural");

        AB_WARNING = messages.getString("texto.actionbar.aviso");
        AB_COUNTDOWN = messages.getString("texto.actionbar.contagem");
        AB_CLEAR_SINGULAR = messages.getString("texto.actionbar.limpo.singular");
        AB_CLEAR_PLURAL = messages.getString("texto.actionbar.limpo.plural");

        TITLE_WARNING = messages.getString("texto.titles.title.aviso");
        TITLE_COUNTDOWN = messages.getString("texto.titles.title.contagem");
        TITLE_CLEAR_SINGULAR = messages.getString("texto.titles.title.limpo.singular");
        TITLE_CLEAR_PLURAL = messages.getString("texto.titles.title.limpo.plural");

        SUBTITLE_WARNING = messages.getString("texto.titles.subtitle.aviso");
        SUBTITLE_COUNTDOWN = messages.getString("texto.titles.subtitle.contagem");
        SUBTITLE_CLEAR_SINGULAR = messages.getString("texto.titles.subtitle.limpo.singular");
        SUBTITLE_CLEAR_PLURAL = messages.getString("texto.titles.subtitle.limpo.plural");

        CHAT_WARNING = messages.getString("texto.chat.aviso");
        CHAT_COUNTDOWN = messages.getString("texto.chat.contagem");
        CHAT_CLEAR_SINGULAR = messages.getString("texto.chat.limpo.singular");
        CHAT_CLEAR_PLURAL = messages.getString("texto.chat.limpo.plural");

        HELP = messages.getStringList("comandos.ajuda");
        RELOAD = messages.getString("comandos.reload");
        NO_PERM = messages.getString("comandos.sem-perm");
    }
}
