package me.tedesk.tlc.runnables;

import me.tedesk.tlc.runnables.bukkit.DroppedItemsChecker;

public class Runnables {

    public static void setup() {
        DroppedItemsChecker.start();
    }
}
