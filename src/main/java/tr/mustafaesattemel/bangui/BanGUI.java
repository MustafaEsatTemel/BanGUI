package tr.mustafaesattemel.bangui;

import org.bukkit.plugin.java.JavaPlugin;
import tr.mustafaesattemel.bangui.commands.BanGUICommand;
import tr.mustafaesattemel.bangui.listeners.BanInventoryListener;

public final class BanGUI extends JavaPlugin {

    @Override
    public void onEnable() {
       getCommand("bangui").setExecutor(new BanGUICommand());
       getServer().getPluginManager().registerEvents(new BanInventoryListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
