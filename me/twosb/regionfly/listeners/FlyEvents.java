package me.twosb.regionfly.listeners;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.mewin.WGRegionEvents.events.RegionLeaveEvent;
import com.sk89q.worldguard.bukkit.listener.RegionFlagsListener;

import me.twosb.regionfly.Utils;
import me.twosb.regionfly.commands.RegionFlyCommand;



public class FlyEvents implements Listener{

	@EventHandler
	public void onRegionEnter(RegionEnterEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("regionfly.fly") && RegionFlyCommand.regionList.contains(e.getRegion().getId())) {
			Utils.enableFlightMode(p);
		}
	}

	@EventHandler
	public void onRegionLeave(RegionLeaveEvent e){
		Player p = e.getPlayer();
		if( p.hasPermission("regionfly.fly") && RegionFlyCommand.regionList.contains(e.getRegion().getId())) {
			Utils.disableFlightMode(p);
		}
	}

}
