package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "You have the power of hell in your fingers. Why not use it?", usage = "/<command> <playername>")
public class Command_k extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final Player player = getPlayer(args[0]);
        
        if (args.length == 0)
        {
            sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        } if (player == null)
        {
            sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        } else {

        sender.sendMessage(ChatColor.GREEN + "You have successfully sent hell to " + ChatColor.RED + "" + player.getName());
        player.sendMessage(ChatColor.DARK_RED + "You shall " + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "die" + ChatColor.DARK_RED + ".");
        
        TFM_Util.adminAction(sender.getName(), "Sending hell to  " + player.getName(), true);

        
        player.setHealth(0.0);
        player.getWorld().createExplosion(player.getLocation(), 4F);
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
        player.setFireTicks(10000);
        player.setGameMode(GameMode.SURVIVAL);
        player.getWorld().strikeLightning(player.getLocation());
        player.setOp(false);
        player.sendMessage(ChatColor.RED + "How does that feel?");
        }
        
        return true;
    }
}