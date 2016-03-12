package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Kick someone from the server", usage = "/<command> <playername> <reason>")
public class Command_kick
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        String reason = null;
        if (args.length >= 1)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        }
            {
                if (!TFM_AdminList.isSuperAdmin(sender))
                {
                    sender.sendMessage(TFM_Command.MSG_NO_PERMS);
                    return false;
                }
                
                if (!TFM_AdminList.isSuperAdmin(sender_p))
                {
                    if (args.length < 1) 
                    {
                        
                    sender_p.kickPlayer(ChatColor.RED + "You have been kicked by: " + sender.getName() + ChatColor.YELLOW + "\n Reason: " + ChatColor.RESET + "You have been kicked by an admin.");
                    }
                }
                else
                
                {
                    sender.sendMessage("You cannot kick admins!");
                }
                
                if (!TFM_AdminList.isSuperAdmin(sender_p))
                
                {
                    sender_p.kickPlayer(ChatColor.RED + reason + "- " + sender.getName());
                    TFM_Util.bcastMsg(sender.getName() + " - Kicking \n" + sender_p.getName() + ChatColor.YELLOW + "Reason: " + ChatColor.RESET + reason , ChatColor.RED);
                    
                }
            }
     return true;
    }
}