package me.twosb.regionfly;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Utils {

	public static ArrayList<String> flyingPlayers = new ArrayList<String>();
	
	public static void sendMessage(Player p, String s) {
		p.sendMessage(getMessage(s));
	}
	
	public static String getMessage(String s) {
		return ChatColor.translateAlternateColorCodes('&' , Main.instance.getConfig().getString("prefix") + s);
	}
	
	
	public static void enableFlightMode(Player p) {
		p.setAllowFlight(true);
		p.setFlying(true);
		sendMessage(p, Main.instance.getConfig().getString("flyActivated"));
	}

	public static void disableFlightMode(Player p) {
		p.setAllowFlight(false);
		p.setFlying(false);
		sendMessage(p, Main.instance.getConfig().getString("flyDeactivated"));
	}
	
}
