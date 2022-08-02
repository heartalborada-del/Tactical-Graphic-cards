package me.heartalborada.tacticalcards;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.KnowledgeBookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import static me.heartalborada.tacticalcards.variable.*;
import static org.bukkit.Bukkit.getServer;

public class recipe {
    public static void init() {
        NamespacedKey key = null;
        {
            ItemStack GT610 = itemStacksGraphics.get(0).clone();
            ItemStack GTX590 = itemStacksGraphics.get(1).clone();
            ItemStack GTXTitanZ = itemStacksShoot.get(2).clone();
            ItemStack R9295X2 = itemStacksShoot.get(3).clone();
            ItemStack HD380X2 = itemStacksShoot.get(4).clone();
            ItemStack RTX3090 = itemStacksShoot.get(5).clone();

            GT610.setAmount(4);
            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "graphics-GT610");
            keyList.add(key);
            ShapedRecipe GT610R = new ShapedRecipe(key, GT610);
            GT610R.shape("*%*", "%B%", "*%*");
            GT610R.setIngredient('*', Material.IRON_INGOT)
                    .setIngredient('B', Material.SCULK)
                    .setIngredient('%', Material.GOLD_BLOCK);
            getServer().addRecipe(GT610R);

            GTX590.setAmount(4);
            GT610.setAmount(2);
            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "graphics-gtx590");
            keyList.add(key);
            ShapedRecipe GTX590R = new ShapedRecipe(key, GTX590);
            RecipeChoice r = new RecipeChoice.ExactChoice(GT610);
            GTX590R.shape("*%*", "%B%", "*%*");
            GTX590R.setIngredient('*', r)
                    .setIngredient('B', Material.SCULK)
                    .setIngredient('%', Material.DIAMOND);
            getServer().addRecipe(GTX590R);

            GTXTitanZ.setAmount(4);
            GTX590.setAmount(2);
            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "graphics-gtxTitanZ");
            keyList.add(key);
            ShapedRecipe GTXTitanZR = new ShapedRecipe(key, GTXTitanZ);
            r = new RecipeChoice.ExactChoice(GTX590);
            RecipeChoice r_star = new RecipeChoice.ExactChoice(new ItemStack(Material.NETHER_STAR, 2));
            GTXTitanZR.shape("*%*", "%B%", "*%*");
            GTXTitanZR.setIngredient('*', r)
                    .setIngredient('B', Material.NETHERITE_INGOT)
                    .setIngredient('%', r_star);
            getServer().addRecipe(GTXTitanZR);

            RTX3090.setAmount(4);
            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "graphics-rtx3090");
            keyList.add(key);
            ShapedRecipe RTX3090R = new ShapedRecipe(key, RTX3090);
            r = new RecipeChoice.ExactChoice(GTXTitanZ);
            RTX3090R.shape("*%*", "%B%", "*%*");
            RTX3090R.setIngredient('*', r)
                    .setIngredient('B', Material.NETHERITE_BLOCK)
                    .setIngredient('%', r_star);
            getServer().addRecipe(RTX3090R);

            R9295X2.setAmount(4);
            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "graphics-r9295x2");
            keyList.add(key);
            ShapedRecipe R9295X2R = new ShapedRecipe(key, R9295X2);
            R9295X2R.shape("*%*", "%B%", "*%*");
            R9295X2R.setIngredient('*', Material.GOLDEN_AXE)
                    .setIngredient('B', Material.SCULK)
                    .setIngredient('%', Material.GOLD_BLOCK);
            getServer().addRecipe(R9295X2R);

            HD380X2.setAmount(4);
            R9295X2.setAmount(2);
            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "graphics-hd280x2");
            keyList.add(key);
            ShapedRecipe HD380X2R = new ShapedRecipe(key, HD380X2);
            r = new RecipeChoice.ExactChoice(R9295X2);
            HD380X2R.shape("*%*", "%B%", "*%*");
            HD380X2R.setIngredient('*', Material.GOLDEN_AXE)
                    .setIngredient('B', r)
                    .setIngredient('%', Material.GOLD_BLOCK);
            getServer().addRecipe(HD380X2R);
        }
        {
            ItemStack GT610 = itemStacksGraphics.get(0).clone();
            ItemStack GTX590 = itemStacksGraphics.get(1).clone();
            ItemStack GTXTitanZ = itemStacksShoot.get(2).clone();
            ItemStack R9295X2 = itemStacksShoot.get(3).clone();
            ItemStack HD380X2 = itemStacksShoot.get(4).clone();
            ItemStack RTX3090 = itemStacksShoot.get(5).clone();

            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "shooter-GT610");
            keyList.add(key);
            ShapedRecipe GT610R = new ShapedRecipe(key, GT610);
            GT610R.shape("***", "*B*", "***");
            GT610R.setIngredient('*', Material.GOLD_BLOCK)
                    .setIngredient('B', Material.BOW);
            getServer().addRecipe(GT610R);

            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "shooter-gtx590");
            keyList.add(key);
            ShapedRecipe GTX590R = new ShapedRecipe(key, GTX590);
            RecipeChoice r = new RecipeChoice.ExactChoice(GT610);
            GTX590R.shape("***", "*B*", "***");
            GTX590R.setIngredient('*', Material.DIAMOND_HOE)
                    .setIngredient('B', r);
            getServer().addRecipe(GTX590R);

            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "shooter-gtxTitanZ");
            keyList.add(key);
            ShapedRecipe GTXTitanZR = new ShapedRecipe(key, GTXTitanZ);
            r = new RecipeChoice.ExactChoice(GTX590);
            GTXTitanZR.shape("*%*", "*B*", "*%*");
            GTXTitanZR.setIngredient('*', Material.DIAMOND_HOE)
                    .setIngredient('B', r)
                    .setIngredient('%', Material.NETHER_STAR);
            getServer().addRecipe(GTXTitanZR);

            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "shooter-rtx3090");
            keyList.add(key);
            ShapedRecipe RTX3090R = new ShapedRecipe(key, RTX3090);
            r = new RecipeChoice.ExactChoice(GTXTitanZ);
            RTX3090R.shape("*%*", "*B*", "*%*");
            RTX3090R.setIngredient('*', Material.NETHER_STAR)
                    .setIngredient('B', r);
            getServer().addRecipe(RTX3090R);

            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "shooter-r9295x2");
            keyList.add(key);
            ShapedRecipe R9295X2R = new ShapedRecipe(key, R9295X2);
            R9295X2R.shape("*%*", "*B*", "*%*");
            R9295X2R.setIngredient('*', Material.DIAMOND_HOE)
                    .setIngredient('B', r);
            getServer().addRecipe(R9295X2R);

            key = new NamespacedKey(JavaPlugin.getPlugin(tacticalcards.class), "shooter-hd380x2");
            keyList.add(key);
            ShapedRecipe HD380X2R = new ShapedRecipe(key, HD380X2);
            r = new RecipeChoice.ExactChoice(R9295X2);
            HD380X2R.shape("*%*", "*B*", "*%*");
            HD380X2R.setIngredient('*', Material.DIAMOND_PICKAXE)
                    .setIngredient('B', r);
            getServer().addRecipe(HD380X2R);
        }
    }

    public static ItemStack genRecipeBook(NamespacedKey key) {
        ItemStack is = new ItemStack(Material.KNOWLEDGE_BOOK, 1);
        KnowledgeBookMeta bm = (KnowledgeBookMeta) is.getItemMeta();
        bm.addRecipe(key);
        is.setItemMeta(bm);
        return is;
    }
}
