package me.levitate.levitation.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.levitate.levitation.Levitation;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player plr = (Player) sender;

            if (Levitation.getLevitationManager().isLevitating.containsKey(plr)) {
                Levitation.getLevitationManager().setLevitating(plr, !Levitation.getLevitationManager().isLevitating.get(plr));
            }
            else {
                Levitation.getLevitationManager().isLevitating.put(plr, true);
                Levitation.getLevitationManager().setLevitating(plr, true);
            }

            return true;
        }
        else {
            sender.sendMessage("You must be a player to execute this command.");

            return true;
        }
    }

}
