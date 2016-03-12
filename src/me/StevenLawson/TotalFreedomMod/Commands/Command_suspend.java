package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Admins need to go? Suspend them!", usage = "/<command> <player>")
public class Command_suspend extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final Player player = getPlayer(args[0]);
        
        if (args.length == 0) {
            playerMsg(TFM_Command.PLAYER_NOT_FOUND);
        } else {
            if (!(TFM_AdminList.isSuperAdmin(player))) {
                playerMsg("Error: That player is not on the superadmin list.", ChatColor.RED);
        } else {
        TFM_Util.adminAction(sender.getName(), "Suspending " + player.getName(), true);
        final String ip = player.getAddress().getAddress().getHostAddress().trim();
        TFM_AdminList.removeSuperadmin(player);
        player.setWhitelisted(false);
        player.setOp(false);
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }
        TFM_BanManager.addUuidBan(player);
        player.setGameMode(GameMode.SURVIVAL);
        player.closeInventory();
        player.getInventory().clear();
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.getWorld().strikeLightning(player.getLocation());

                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.kickPlayer(ChatColor.RED + "You have been suspended by " + sender.getName() + ". Please appeal at " + ChatColor.DARK_RED + "http://rainbowfreedom.boards.net/");
            }
        }.runTaskLater(plugin, 3L * 20L);
            }        
        }
        return true;
    }
}
