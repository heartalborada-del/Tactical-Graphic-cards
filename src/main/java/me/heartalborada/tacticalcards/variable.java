package me.heartalborada.tacticalcards;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import static me.heartalborada.tacticalcards.utils.genCard;
import static me.heartalborada.tacticalcards.utils.genShooter;

public class variable {
    public static NamespacedKey weapon = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "weapon");
    public static NamespacedKey explode = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "explode");
    public static NamespacedKey isBreak = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "isBreakBlocks");
    public static LinkedHashMap<String, Integer> gmap = new LinkedHashMap<>();

    public static LinkedList<NamespacedKey> keyList = new LinkedList<>();
    public static LinkedList<ItemStack> itemStacksGraphics = new LinkedList<>();
    public static LinkedList<ItemStack> itemStacksShoot = new LinkedList<>();

    public static Inventory inv;
    public static void init(){
        gmap.put("NVIDIA® GeForce® GT 610", 4);
        gmap.put("NVIDIA® GeForce® GTX 590", 6);
        gmap.put("NVIDIA® GeForce® GTX Titan Z", 8);
        gmap.put("AMD® Radeon™ R9 295X2", 5);
        gmap.put("ATI® Radeon™ HD3870X2", 9);
        gmap.put("NVIDIA® GeForce® RTX 3090", 10);
        gmap.put("NVIDIA® GeForce® RTX 4090", 12);
        gmap.put("NVIDIA® GeForce® RTX 4099", 16);
        gmap.put("NVIDIA® GeForce® GT 114514 疯牛病版", 18);
        inv = Bukkit.createInventory(null, 27, "Choose your Tactical Card");
        for(String s : gmap.keySet()) {
            ItemStack is = genShooter(s);
            inv.addItem(is);
            //itemStacksShoot.add(is);
        }
        for(String s : gmap.keySet()) {
            ItemStack is = genCard(true, s);
            inv.addItem(is);
            //itemStacksGraphics.add(is);
        }
        for(String s : gmap.keySet()) {
            ItemStack is = genCard(false, s);
            inv.addItem(is);
            //itemStacksGraphics.add(is);
        }
    }
}
