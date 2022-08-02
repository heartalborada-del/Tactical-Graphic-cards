package me.heartalborada.tacticalcards;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import static me.heartalborada.tacticalcards.recipe.genRecipeBook;
import static me.heartalborada.tacticalcards.variable.inv;
import static me.heartalborada.tacticalcards.variable.keyList;

public final class tacticalcards extends JavaPlugin {
    public Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        variable.init();
        this.getServer().getPluginManager().registerEvents(new event(),this);
    }

    @Override
    public void onDisable() {
        logger.info("Thanks for your playing");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(command.getName().equals("getcard")) {
                Player p = (Player) sender;
                p.openInventory(inv);
                return true;
            }
        } else {
            sender.sendMessage("You must to do that as a player");
            return true;
        }
        return false;
    }
}
