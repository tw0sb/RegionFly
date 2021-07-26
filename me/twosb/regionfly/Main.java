package me.twosb.regionfly;

import org.bukkit.plugin.java.JavaPlugin;

import me.twosb.regionfly.commands.RegionFlyCommand;
import me.twosb.regionfly.listeners.FlyEvents;

public class Main extends JavaPlugin{
	


	public static Main instance;
	
	
	 @Override
	    public void onEnable() {
		 saveDefaultConfig();
		 instance = this;
		 getServer().getPluginManager().registerEvents(new FlyEvents(), this);
		 getCommand("regionfly").setExecutor(new RegionFlyCommand());
		 RegionFlyCommand.loadList();
		 
	    }
	 

	    @Override
	    public void onDisable() {
	        
	    }
	
}
