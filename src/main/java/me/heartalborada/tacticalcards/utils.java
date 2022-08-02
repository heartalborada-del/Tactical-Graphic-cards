package me.heartalborada.tacticalcards;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.LinkedList;

import static me.heartalborada.tacticalcards.variable.*;

public class utils {
    public static ItemStack genCard(boolean isBreakBlock, String CardName) {
        ItemStack is = new ItemStack(Material.ARROW);
        LinkedList<String> list = new LinkedList<>();
        int explodeSize = gmap.get(CardName);
        ItemMeta im = is.getItemMeta();
        im.getPersistentDataContainer().set(weapon, PersistentDataType.INTEGER, 1);
        im.getPersistentDataContainer().set(explode, PersistentDataType.INTEGER, explodeSize);
        list.add(ChatColor.GOLD + CardName);
        list.add(ChatColor.DARK_PURPLE + "Explode power " + explodeSize);
        if (isBreakBlock) {
            im.getPersistentDataContainer().set(isBreak, PersistentDataType.INTEGER, 1);
        } else {
            im.getPersistentDataContainer().set(isBreak, PersistentDataType.INTEGER, 0);
            list.add(ChatColor.YELLOW + "不会破坏地形的版本!");
        }
        im.setLore(list);
        im.setCustomModelData(10);
        im.setDisplayName(ChatColor.DARK_RED + CardName);
        is.setItemMeta(im);
        return is;
    }

    public static ItemStack genShooter(String CardName) {
        ItemStack is = null;
        LinkedList<String> list = new LinkedList<>();
        int explodeSize = gmap.get(CardName);
        is = new ItemStack(Material.BOW);
        ItemMeta im = is.getItemMeta();
        im.getPersistentDataContainer().set(weapon, PersistentDataType.INTEGER, 1);
        im.getPersistentDataContainer().set(explode, PersistentDataType.INTEGER, explodeSize);
        list.add(ChatColor.GOLD + CardName + " 发射器");
        im.setLore(list);
        im.setCustomModelData(10);
        im.setDisplayName(ChatColor.RED + CardName + " 发射器");
        im.setUnbreakable(true);
        is.setItemMeta(im);
        return is;
    }

    public static void giveCard(Player p, String CardName) {
        if (gmap.get(CardName) != null) {
            p.getInventory().addItem(genCard(true, CardName));
            p.getInventory().addItem(genCard(false, CardName));
        }
    }
}
