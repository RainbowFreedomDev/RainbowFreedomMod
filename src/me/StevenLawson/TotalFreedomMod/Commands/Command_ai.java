package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Intrested in becomming an admin? Apply here!", usage = "/<command>")
public class Command_ai extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        
        if (sender.getName().equals("FoxIshDaBest")) {
        playerMsg("So, I see you are intrested in becoming an admin, eh?", ChatColor.AQUA);
        playerMsg("Just follow these quick steps!", ChatColor.AQUA);
        playerMsg("Fist, go to ", ChatColor.RED);
        } else {
            playerMsg("This command is currently in development.", ChatColor.RED);
        }
        
        return true;
    }

    

}
