package me.twosb.regionfly.commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.twosb.regionfly.Main;
import me.twosb.regionfly.Utils;

public class RegionFlyCommand implements CommandExecutor 	{

	public static ArrayList<String> regionList = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				Utils.sendMessage(p, Main.instance.getConfig().getString("invalidUsage"));
			} else {
				if(p.hasPermission("regionfly.admin") || p.isOp()) {
					if(args[0].equalsIgnoreCase("add")) {
						if(args.length == 2) {
							Utils.sendMessage(p,addRegion(args[1]));
						}else {
							Utils.sendMessage(p, Main.instance.getConfig().getString("invalidUsage"));
						}
					}else if(args[0].equalsIgnoreCase("remove")){
						if(args.length == 2) {
							Utils.sendMessage(p,removeRegion(args[1]));
						}else {
							Utils.sendMessage(p, Main.instance.getConfig().getString("invalidUsage"));
						}
					}else if(args[0].equalsIgnoreCase("list")){
						Main.instance.reloadConfig();
						Utils.sendMessage(p, ChatColor.GRAY + regionList.toString());	
					}else if(args[0].equalsIgnoreCase("reload")){
						Main.instance.reloadConfig();
						Utils.sendMessage(p, Main.instance.getConfig().getString("reloadConfigMessage"));
					}else if(args[0].equalsIgnoreCase("help")){
						for(String messages : Main.instance.getConfig().getStringList("helpCommand")) {
							Utils.sendMessage(p, ChatColor.translateAlternateColorCodes('&', messages));
						}
					}else {
						Utils.sendMessage(p, Main.instance.getConfig().getString("invalidUsage"));
					}
				}else {
					Utils.sendMessage(p, Main.instance.getConfig().getString("noPermissionMesage"));
				}
			}
		}else {
			System.out.println("Only players may ue this command");
		}


		return true;
	}
	
	public static String addRegion(String r) {
		if(regionList.contains(r)) {
			return "&6" + r + "&e already exists.";
		}else {
			regionList.add(r);
			Main.instance.getConfig().set("regionList", regionList);
			Main.instance.saveConfig();
		    return Main.instance.getConfig().getString("regionAdded").replace("{REGION}", r);
		}
	}
	
	public static String removeRegion(String r) {
		if(!regionList.contains(r)) {
			return "&6" + r + "&e does not exist.";
		}else {
			regionList.remove(r);
			Main.instance.getConfig().set("regionList", regionList);
			Main.instance.saveConfig();
			return Main.instance.getConfig().getString("regionRemoved").replace("{REGION}", r);
		}
	}

	public static void loadList() {	
		for(String regions : Main.instance.getConfig().getStringList("regionList")) {
			regionList.add(regions);
		}
	
	}
	
}
