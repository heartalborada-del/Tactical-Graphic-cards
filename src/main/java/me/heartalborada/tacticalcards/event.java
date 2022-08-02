package me.heartalborada.tacticalcards;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static me.heartalborada.tacticalcards.variable.*;
import static me.heartalborada.tacticalcards.variable.isBreak;

public class event implements Listener {
    private Logger logger = JavaPlugin.getPlugin(tacticalcards.class).logger;

    @EventHandler
    public void onShootArrow(EntityShootBowEvent e) {
        PersistentDataContainer p = e.getBow().getItemMeta().getPersistentDataContainer();
        int a = p.get(weapon, PersistentDataType.INTEGER) != null ? p.get(weapon, PersistentDataType.INTEGER) : 0;
        if(a != 0) {
            Entity en = e.getProjectile();
            PersistentDataContainer p1 = e.getConsumable().getItemMeta().getPersistentDataContainer();
            int isBreakBlocks = p1.get(isBreak, PersistentDataType.INTEGER) != null ? p1.get(isBreak, PersistentDataType.INTEGER) : 1;
            if (p1.get(explode,PersistentDataType.INTEGER) != null && p1.get(explode,PersistentDataType.INTEGER) <= p.get(explode,PersistentDataType.INTEGER)) {
                PersistentDataContainer p2 = en.getPersistentDataContainer();
                p2.set(weapon, PersistentDataType.INTEGER, 1);
                p2.set(explode, PersistentDataType.INTEGER, p1.get(explode, PersistentDataType.INTEGER));
                p2.set(isBreak, PersistentDataType.INTEGER, isBreakBlocks);
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e) {
        Entity en = e.getEntity();
        if (en.getType() == EntityType.ARROW) {
            if (en.getPersistentDataContainer().get(weapon, PersistentDataType.INTEGER) != null && en.getPersistentDataContainer().get(weapon, PersistentDataType.INTEGER) == 1) {
                Location loc = en.getLocation();
                World w = en.getWorld();
                int ex = en.getPersistentDataContainer().get(explode, PersistentDataType.INTEGER);
                int isBreakBlocks = en.getPersistentDataContainer().get(isBreak, PersistentDataType.INTEGER);
                en.remove();
                w.createExplosion(loc,ex,true,isBreakBlocks == 1);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getInventory().getType() == InventoryType.ANVIL) {
            if(e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(weapon, PersistentDataType.INTEGER) != null) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage(ChatColor.DARK_RED + "You can't enchantment/rename this weapon");
            }
        }
        if (!e.getInventory().equals(inv)) return;
        e.setCancelled(true);
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir() || !e.getClickedInventory().equals(inv)) return;
        Player p = (Player) e.getWhoClicked();
        p.getInventory().addItem(clickedItem);
    }

    @EventHandler
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) e.setCancelled(true);
    }

    @EventHandler
    public void onEnchantment(EnchantItemEvent e) {
        if (e.getItem().getItemMeta().getPersistentDataContainer().get(weapon, PersistentDataType.INTEGER) != null) {
            e.setCancelled(true);
            e.getEnchanter().sendMessage(ChatColor.DARK_RED + "You can't enchantment/rename this weapon");
        }
    }

    @EventHandler
    public void onPickUpWeapon(EntityPickupItemEvent e) {
        ItemStack item = e.getItem().getItemStack();
        if(e.getEntity() instanceof Player) {
            if (item.getItemMeta().getPersistentDataContainer().get(weapon, PersistentDataType.INTEGER) != null) {
                for (Enchantment en : item.getEnchantments().keySet()) {
                    item.removeEnchantment(en);
                }
            }
        }
    }
}
