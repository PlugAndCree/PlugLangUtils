package it.plugandcree.langutils.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.spigot.libraries.commands.Command;

public class MainCommand extends Command {

	public MainCommand() {
		super("langutils");
	}

	@Override
	public boolean execute(CommandSender sender, org.bukkit.command.Command cmd, List<String> args) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lLANGUTILS &7plugin made by &aPlug_And_Cree"));
		return true;
	}

}
