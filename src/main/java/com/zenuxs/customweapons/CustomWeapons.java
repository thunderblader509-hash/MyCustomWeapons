package com.zenuxs.customweapons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomWeapons extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("customweapons").setExecutor(this);
        
        // Emerald Hammer Recipe
        ItemStack emeraldHammer = new ItemStack(Material.MACE);
        ItemMeta meta = emeraldHammer.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Emerald Hammer");
        emeraldHammer.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "emerald_hammer");
        ShapedRecipe recipe = new ShapedRecipe(key, emeraldHammer);
        recipe.shape("EEE", " E ", " S ");
        recipe.setIngredient('E', Material.EMERALD_BLOCK);
        recipe.setIngredient('S', Material.MACE);
        Bukkit.addRecipe(recipe);

        getLogger().info("CustomWeapons Enabled Successfully!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("customweapons")) {
            ItemStack item = new ItemStack(Material.MACE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "Emerald Hammer");
            item.setItemMeta(meta);
            player.getInventory().addItem(item);
            player.sendMessage(ChatColor.GREEN + "Emerald Hammer mil gaya!");
            return true;
        }
        return false;
    }
}
