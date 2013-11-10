package com.llfrealms.LLFRankUp;

//bukkit imports
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import net.milkbowl.vault.permission.Permission;

public final class LLFRankUp extends JavaPlugin
{
	public ConsoleCommandSender consoleMessage = Bukkit.getConsoleSender();
	public static Permission perms = null;
	
	@Override
    public void onEnable(){
		setupPermissions();
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    public static String colorChat(String msg) 
    {
            return msg.replace('&', (char) 167);
    }
    public static String getFinalArg(final String[] args, final int start)
    {
            final StringBuilder bldr = new StringBuilder();
            for (int i = start; i < args.length; i++)
            {
                    if (i != start)
                    {
                            bldr.append(" ");
                    }
                    bldr.append(args[i]);
            }
            return bldr.toString();
    }
    public static boolean sendMessage(CommandSender p, String message)
    {
        if (message ==null || message.isEmpty()) return true;
        if (message.contains("\n"))
                return sendMultilineMessage(p,message);
        if (p instanceof Player){
                if (((Player) p).isOnline())
                        p.sendMessage(colorChat(message));
        } else {
                p.sendMessage(colorChat(message));
        }
        return true;
    }
    public static boolean sendMultilineMessage(CommandSender p, String message)
    {
        if (message ==null || message.isEmpty()) return true;
        String[] msgs = message.split("\n");
        for (String msg: msgs){
                if (p instanceof Player){
                        if (((Player) p).isOnline())
                                p.sendMessage(colorChat(msg));
                } else {
                        p.sendMessage(colorChat(msg));
                }
        }
        return true;
    }  
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
        if(cmd.getName().equalsIgnoreCase("/rankup"))
        {
        	if (!(sender instanceof Player)) {
    			sender.sendMessage("This command can only be run by a player.");
    		} else {
    			Player player = (Player) sender;
    			if(perms.has(player, "buy.corporal-e")) {
    				Bukkit.getServer().dispatchCommand(sender, "menu open corporal-e");
    	        } else {
    	            sender.sendMessage("You suck!");
    	        }
    	        return true;
    		}
    		return true;
        }
            return false;
    }
}
