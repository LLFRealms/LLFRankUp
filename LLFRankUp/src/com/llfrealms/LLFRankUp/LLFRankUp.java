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
        	if (!(sender instanceof Player)) 
        	{
    			sender.sendMessage("This command can only be run by a player.");
    		} 
        	else 
        	{
    			Player player = (Player) sender;
    			if(perms.has(player, "buy.recruit-s") || perms.has(player, "buy.corporal-s")) 
    			{
    				if(perms.has(player, "buy.brigadier-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-s");
    				}
    				else if(perms.has(player, "buy.colonel-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open colonel-s");
    				}
    				else if(perms.has(player, "buy.major-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open major-s");
    				}
    				else if(perms.has(player, "buy.lieutenant-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-s");
    				}
    				else if(perms.has(player, "buy.sergeant-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-s");
    				}
    				else if(perms.has(player, "buy.corporal-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open corporal-s");
    				}
    				else if(perms.has(player, "buy.recruit-s"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open recruit-s");
    				}
    				
    	        } 
    			else if(perms.has(player, "buy.recruit-a") || perms.has(player, "buy.corporal-a"))
    			{
    				if(perms.has(player, "buy.brigadier-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-a");
    				}
    				else if(perms.has(player, "buy.colonel-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open colonel-a");
    				}
    				else if(perms.has(player, "buy.major-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open major-a");
    				}
    				else if(perms.has(player, "buy.lieutenant-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-a");
    				}
    				else if(perms.has(player, "buy.sergeant-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-a");
    				}
    				else if(perms.has(player, "buy.corporal-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open corporal-a");
    				}
    				else if(perms.has(player, "buy.recruit-a"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open recruit-a");
    				}
    	        }
    			else if(perms.has(player, "buy.recruit-b") || perms.has(player, "buy.corporal-b"))
    			{
    				if(perms.has(player, "buy.brigadier-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-b");
    				}
    				else if(perms.has(player, "buy.colonel-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open colonel-b");
    				}
    				else if(perms.has(player, "buy.major-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open major-b");
    				}
    				else if(perms.has(player, "buy.lieutenant-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-b");
    				}
    				else if(perms.has(player, "buy.sergeant-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-b");
    				}
    				else if(perms.has(player, "buy.corporal-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open corporal-b");
    				}
    				else if(perms.has(player, "buy.recruit-b"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open recruit-b");
    				}
    	        }
    			else if(perms.has(player, "buy.recruit-c") || perms.has(player, "buy.corporal-c"))
    			{
    				if(perms.has(player, "buy.brigadier-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-c");
    				}
    				else if(perms.has(player, "buy.colonel-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open colonel-c");
    				}
    				else if(perms.has(player, "buy.major-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open major-c");
    				}
    				else if(perms.has(player, "buy.lieutenant-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-c");
    				}
    				else if(perms.has(player, "buy.sergeant-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-c");
    				}
    				else if(perms.has(player, "buy.corporal-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open corporal-c");
    				}
    				else if(perms.has(player, "buy.recruit-c"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open recruit-c");
    				}
    	        }
    			else if(perms.has(player, "buy.recruit-d") || perms.has(player, "buy.corporal-d"))
    			{
    				if(perms.has(player, "buy.brigadier-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-d");
    				}
    				else if(perms.has(player, "buy.colonel-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open colonel-d");
    				}
    				else if(perms.has(player, "buy.major-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open major-d");
    				}
    				else if(perms.has(player, "buy.lieutenant-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-d");
    				}
    				else if(perms.has(player, "buy.sergeant-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-d");
    				}
    				else if(perms.has(player, "buy.corporal-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open corporal-d");
    				}
    				else if(perms.has(player, "buy.recruit-d"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open recruit-d");
    				}
    	        }
    			else if(perms.has(player, "buy.corporal-e") || perms.has(player, "buy.corporal-e"))
    			{
    				if(perms.has(player, "buy.brigadier-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-e");
    				}
    				else if(perms.has(player, "buy.colonel-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open colonel-e");
    				}
    				else if(perms.has(player, "buy.major-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open major-e");
    				}
    				else if(perms.has(player, "buy.lieutenant-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-e");
    				}
    				else if(perms.has(player, "buy.sergeant-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-e");
    				}
    				else if(perms.has(player, "buy.corporal-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open corporal-e");
    				}
    				else if(perms.has(player, "buy.recruit-e"))
    				{
    					Bukkit.getServer().dispatchCommand(sender, "menu open recruit-e");
    				}
    	        }
    			else
    			{
    				Bukkit.getServer().dispatchCommand(sender, "menu open ranks");
    			}
    	        return true;
    		}
    		return true;
        }
            return false;
    }
}
