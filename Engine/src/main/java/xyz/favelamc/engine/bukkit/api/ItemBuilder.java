package xyz.favelamc.engine.bukkit.api;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

    public ItemStack newItem(Material material, String name, String[] description, int quantity, byte bt) {
        ItemStack itemStack = new ItemStack(material, quantity, (byte) bt);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(description));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack newHeadSkull(String name, String nickname, String[] description) {
        ItemStack itemStack = new ItemStack(Material.getMaterial(397));
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();

        itemStack.setDurability((short) 3);

        skullMeta.hasOwner();
        skullMeta.setOwner(nickname);
        skullMeta.setDisplayName(name);
        skullMeta.setLore(Arrays.asList(description));

        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }
}