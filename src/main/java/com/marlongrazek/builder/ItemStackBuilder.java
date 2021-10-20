package com.marlongrazek.builder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemStackBuilder {

    private Integer amount;
    private HashMap<Enchantment, Integer> enchantments = new HashMap<>();
    private ArrayList<ItemFlag> itemFlags = new ArrayList<>();
    private ItemMeta itemMeta;
    private ArrayList<String> lore = new ArrayList<>();
    private Material material;
    private String name;

    public ItemStackBuilder() {
    }

    public ItemStackBuilder(Material material) {
        this.material = material;
    }

    public ItemStackBuilder(String name, Material material) {
        this.material = material;
        this.name = name;
    }

    public ItemStackBuilder(String name, Material material, ArrayList<String> lore, Integer amount, HashMap<Enchantment, Integer> enchantments, ArrayList<ItemFlag> itemFlags) {
        this.amount = amount;
        this.enchantments = enchantments;
        this.itemFlags = itemFlags;
        this.lore = lore;
        this.material = material;
        this.name = name;
    }

    public ItemStackBuilder(String name, Material material, ArrayList<String> lore, Integer amount, HashMap<Enchantment, Integer> enchantments, ItemFlag[] itemFlags) {
        this.amount = amount;
        this.enchantments = enchantments;
        this.itemFlags = new ArrayList<>(Arrays.asList(itemFlags));
        this.lore = lore;
        this.material = material;
        this.name = name;
    }

    public ItemStackBuilder(String name, Material material, Integer amount, HashMap<Enchantment, Integer> enchantments, ItemMeta itemMeta) {
        this.amount = amount;
        this.enchantments = enchantments;
        this.itemMeta = itemMeta;
        this.material = material;
        this.name = name;
    }


    public void addEnchantment(Enchantment enchantment, Integer level) {
        enchantments.put(enchantment, level);
    }

    public void addGlow() {
        addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        addItemFlag(ItemFlag.HIDE_ENCHANTS);
    }

    public void addItemFlag(ItemFlag itemFlag) {
        this.itemFlags.add(itemFlag);
    }

    public void addLoreLine(String line) {
        this.lore.add(line);
    }

    public Integer getAmount() {
        return amount;
    }

    public HashMap<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }

    public ArrayList<ItemFlag> getItemFlags() {
        return itemFlags;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    public ArrayList<String> getLore() {
        return lore;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setEnchantments(HashMap<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;
    }

    public void setItemFlags(ItemFlag[] itemFlags) {
        this.itemFlags = new ArrayList<>(Arrays.asList(itemFlags));
    }

    public void setItemFlags(ArrayList<ItemFlag> itemFlags) {
        this.itemFlags = itemFlags;
    }

    public void setItemMeta(ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
    }

    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }

    public void setLoreLine(String line, Integer index) {
        this.lore.set(index, line);
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStack toItemStack() {

        ItemFlag[] itemFlagArray = new ItemFlag[itemFlags.size()];
        itemFlagArray = itemFlags.toArray(itemFlagArray);

        ItemStack itemStack = new ItemStack(material);

        if (itemMeta != null) itemStack.setItemMeta(itemMeta);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.addItemFlags(itemFlagArray);
        itemStack.setItemMeta(itemMeta);
        itemStack.setAmount(amount);
        itemStack.addUnsafeEnchantments(enchantments);

        return itemStack;
    }
}
