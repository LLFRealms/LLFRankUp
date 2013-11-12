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
	public String pluginName = "LLFRankUp";
	public ConsoleCommandSender consoleMessage = Bukkit.getConsoleSender();
	public static Permission perms = null;
	
	@Override
    public void onEnable(){
		setupPermissions();
		sendMessage(consoleMessage, "[" + pluginName + "] &aLLFRankUp is active!");
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
    			if(!player.isOp())
    			{
    				noOP(player);
    			}
    			else if(player.isOp())
    			{
    				yesOP(player);
    			}
    	        return true;
    		}
    		return true;
        }
            return false;
    }
    public void yesOP(Player player)
    {
    	sendMessage(player, "&d[&2LLFRankUp&d] &4This plugin currently does not support OP players. Sorry for the inconvience.");
    }
    public void noOP(Player player)
    {
    	CommandSender sender = player;
    	if(perms.has(player, "rank.s6")) 
		{
			sendMessage(sender, "&9You're already Brigadier-S WHAT MORE DO YOU WANT?!?");
		}
		else if(perms.has(player, "rank.s5"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-s");
		}
		else if(perms.has(player, "rank.s4"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open colonel-s");
		}
		else if(perms.has(player, "rank.s3"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open major-s");
		}
		else if(perms.has(player, "rank.s2"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-s");
		}
		else if(perms.has(player, "rank.s1"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-s");
		}
		else if(perms.has(player, "rank.s0"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open corporal-s");
		}
		else if(perms.has(player, "rank.a6"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open recruit-s");
		}
		else if(perms.has(player, "rank.a5"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-a");
		}
		else if(perms.has(player, "rank.a4"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open colonel-a");
		}
		else if(perms.has(player, "rank.a3"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open major-a");
		}
		else if(perms.has(player, "rank.a2"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-a");
		}
		else if(perms.has(player, "rank.a1"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-a");
		}
		else if(perms.has(player, "rank.a0"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open corporal-a");
		}
		else if(perms.has(player, "rank.b6"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open recruit-a");
		}
		else if(perms.has(player, "rank.b5"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-b");
		}
		else if(perms.has(player, "rank.b4"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open colonel-b");
		}
		else if(perms.has(player, "rank.b3"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open major-b");
		}
		else if(perms.has(player, "rank.b2"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-b");
		}
		else if(perms.has(player, "rank.b1"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-b");
		}
		else if(perms.has(player, "rank.b0"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open corporal-b");
		}
		else if(perms.has(player, "rank.c6"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open recruit-b");
		}
		else if(perms.has(player, "rank.c5"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-c");
		}
		else if(perms.has(player, "rank.c4"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open colonel-c");
		}
		else if(perms.has(player, "rank.c3"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open major-c");
		}
		else if(perms.has(player, "rank.c2"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-c");
		}
		else if(perms.has(player, "rank.c1"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-c");
		}
		else if(perms.has(player, "rank.c0"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open corporal-c");
		}
		else if(perms.has(player, "rank.d6"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open recruit-c");
		}
		else if(perms.has(player, "rank.d5"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-d");
		}
		else if(perms.has(player, "rank.d4"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open colonel-d");
		}
		else if(perms.has(player, "rank.d3"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open major-d");
		}
		else if(perms.has(player, "rank.d2"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-d");
		}
		else if(perms.has(player, "rank.d1"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-d");
		}
		else if(perms.has(player, "rank.d0"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open corporal-d");
		}
		else if(perms.has(player, "rank.e6"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open recruit-d");
		}
		else if(perms.has(player, "rank.e5"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open brigadier-e");
		}
		else if(perms.has(player, "rank.e4"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open colonel-e");
		}
		else if(perms.has(player, "rank.e3"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open major-e");
		}
		else if(perms.has(player, "rank.e2"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open lieutenant-e");
		}
		else if(perms.has(player, "rank.e1"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open sergeant-e");
		}
		else if(perms.has(player, "rank.e0"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open corporal-e");
		}
		else if(perms.has(player, "moderator.s"))
		{
			sendMessage(sender, "&9You're already S LEVEL WHAT MORE DO YOU WANT?!?");
		}
		else if(perms.has(player, "moderator.a"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open moderator-s");
		}
		else if(perms.has(player, "moderator.b"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open moderator-a");
		}
		else if(perms.has(player, "moderator.c"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open moderator-b");
		}
		else if(perms.has(player, "moderator.d"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open moderator-c");
		}
		else if(perms.has(player, "moderator.e"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open moderator-d");
		}
		else if(perms.has(player, "admin.s"))
		{
			sendMessage(sender, "&9You're already S LEVEL WHAT MORE DO YOU WANT?!?");
		}
		else if(perms.has(player, "admin.a"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open admin-s");
		}
		else if(perms.has(player, "admin.b"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open admin-a");
		}
		else if(perms.has(player, "admin.c"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open admin-b");
		}
		else if(perms.has(player, "admin.d"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open admin-c");
		}
		else if(perms.has(player, "admin.e"))
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open admin-d");
		}
		else
		{
			Bukkit.getServer().dispatchCommand(sender, "menu open ranks");
		}
    }
}
