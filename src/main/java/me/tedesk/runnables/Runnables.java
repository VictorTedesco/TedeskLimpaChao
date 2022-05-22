package me.tedesk.runnables;

import me.tedesk.runnables.bukkit.DroppedItemsChecker;

public class Runnables {

    public static void setup() {
        DroppedItemsChecker.start();
    }
}
