package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "doge cmd", usage = "/<command>")
public class Command_doge extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        
        playerMsg("                     ,", TFM_Util.randomChatColor());
        playerMsg("                ,.  | \\ ", TFM_Util.randomChatColor());
        playerMsg("               |: \\ ; :\\ ", TFM_Util.randomChatColor());
        playerMsg("               :' ;\\| ::\\", TFM_Util.randomChatColor());
        playerMsg("                \\ : | `::\\ ", TFM_Util.randomChatColor());
        playerMsg("                _)  |   `:`. ", TFM_Util.randomChatColor());
        playerMsg("              ,' , `.    ;: ; ", TFM_Util.randomChatColor());
        playerMsg("            ,' ;:  ;\"'  ,:: |", TFM_Util.randomChatColor());
        playerMsg("           /,   ` .    ;::: |:`-.__ ", TFM_Util.randomChatColor());
        playerMsg("        _,' _o\\  ,::.`:' ;  ;   . ' ", TFM_Util.randomChatColor());
        playerMsg("    _,-'           `:.          ;\"\"", TFM_Util.randomChatColor());
        playerMsg(" ,-'                     ,:         `-;, ", TFM_Util.randomChatColor());
        playerMsg(" \\,                       ;:           ;--._ ", TFM_Util.randomChatColor());
        playerMsg("  `.______,-,----._     ,' ;:        ,/ ,  ,` ", TFM_Util.randomChatColor());
        playerMsg("         / /,-';'  \\     ; `:      ,'/,::.::: ", TFM_Util.randomChatColor());
        playerMsg("       ,',;-'-'_,--;    ;   :.   ,',',;:::::: ", TFM_Util.randomChatColor());
        playerMsg("      ( /___,-'     `.     ;::,,'o/  ,::::::: ", TFM_Util.randomChatColor());
        playerMsg("       `'             )    ;:,'o /  ;\"-   -:: ", TFM_Util.randomChatColor());
        playerMsg("                      \\__ _,'o ,'         ,:: ", TFM_Util.randomChatColor());
        playerMsg("                         ) `--'       ,..:::: ", TFM_Util.randomChatColor());
        playerMsg("                         ; `.        ,::::::: ", TFM_Util.randomChatColor());
        playerMsg("                          ;  ``::.    ::::::: ", TFM_Util.randomChatColor());
        playerMsg(ChatColor.DARK_RED + "#dogeftw");
        
        return true;
    }
}