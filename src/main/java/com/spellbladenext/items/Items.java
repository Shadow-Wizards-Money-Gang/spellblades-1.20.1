package com.spellbladenext.items;

import com.spellbladenext.Spellblades;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.weapon.Weapon;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.SpellSchools;

import java.util.ArrayList;
import java.util.Map;

public class Items {
    public static final ArrayList<Weapon.Entry> entries = new ArrayList<>();

    private static Weapon.Entry entry(String name, Weapon.CustomMaterial material, Item item, ItemConfig.Weapon defaults) {
        return entry(null, name, material, item, defaults);
    }

    private static Weapon.Entry entry(String requiredMod, String name, Weapon.CustomMaterial material, Item item, ItemConfig.Weapon defaults) {
        var entry = new Weapon.Entry(Spellblades.MOD_ID, name, material, item, defaults, null);
        if (entry.isRequiredModInstalled()) {
            entries.add(entry);
        }
        return entry;
    }

    private static final float bladeValue = 2F;
    private static final float claymoreDamage = 4F;

    private static Weapon.Entry blade(String name, Weapon.CustomMaterial material, float damage, SpellSchool school) {
        return blade(null, name, material, damage, school );
    }

    private static Weapon.Entry thespark(String name, Weapon.CustomMaterial material, float damage, SpellSchool school) {
        return thespark(null, name, material, damage, school );
    }

    private static Weapon.Entry thespark(String requiredMod, String name, Weapon.CustomMaterial material, float damage,SpellSchool school) {
        var settings = new Item.Settings();
        var item = new TheSpark(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, -3F));
    }
    private static Weapon.Entry blade(String requiredMod, String name, Weapon.CustomMaterial material, float damage, SpellSchool school) {
        var settings = new Item.Settings();
        var item = new Spellblade(material, settings.rarity(Rarity.UNCOMMON), 1, -2.4F, school);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, -2.4F));
    }

    public static final Weapon.Entry frost_blade = blade("frost_blade",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.PRISMARINE_SHARD)), 3F, SpellSchools.FROST)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FROST).id, bladeValue));
    public static final Weapon.Entry fire_blade = blade("fire_blade",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.BLAZE_ROD)), 3F,SpellSchools.FIRE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FIRE).id, bladeValue));
    public static final Weapon.Entry arcane_blade = blade("arcane_blade",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.AMETHYST_SHARD)), 3F,SpellSchools.ARCANE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.ARCANE).id, bladeValue));
    public static final Weapon.Entry glacial_gladius = blade("glacial_gladius",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.BLUE_ICE)), 5F,SpellSchools.FROST)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FROST).id, 3));
    public static final Weapon.Entry flaming_falchion = blade("flaming_falchion",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.BLAZE_ROD)), 5F,SpellSchools.FIRE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FIRE).id, 3));
    public static final Weapon.Entry crystal_cutlass = blade("crystal_cutlass",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.AMETHYST_BLOCK)), 5F,SpellSchools.ARCANE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.ARCANE).id, 3));

    private static Weapon.Entry claymore(String name, Weapon.CustomMaterial material, float damage, SpellSchool school) {
        return claymore(null, name, material, damage, school );
    }
    private static Weapon.Entry claymore(String requiredMod, String name, Weapon.CustomMaterial material, float damage,SpellSchool school) {
        var settings = new Item.Settings();
        var item = new Claymore(material, settings.rarity(Rarity.RARE),3,-3,  school);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, -3F));
    }
    public static final Weapon.Entry frost_claymore = claymore("frost_claymore",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.PRISMARINE_SHARD)), 6F,SpellSchools.FROST)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FROST).id, claymoreDamage));
    public static final Weapon.Entry fire_claymore = claymore("fire_claymore",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.BLAZE_ROD)), 6F,SpellSchools.FIRE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FIRE).id, claymoreDamage));
    public static final Weapon.Entry arcane_claymore = claymore("arcane_claymore",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.AMETHYST_SHARD)), 6F,SpellSchools.ARCANE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.ARCANE).id, claymoreDamage));
    private static Weapon.Entry orb(String name, Weapon.CustomMaterial material, float damage, SpellSchool school) {
        return orb(null, name, material, damage, school );
    }
    private static Weapon.Entry orb(String requiredMod, String name, Weapon.CustomMaterial material, float damage,SpellSchool school) {
        var settings = new Item.Settings();
        var item = new Orb(material, settings.rarity(Rarity.UNCOMMON), school);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, -3F));
    }
    public static final Weapon.Entry frost_orb = orb("frost_orb",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.PRISMARINE_CRYSTALS)), 1F,SpellSchools.FROST)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FROST.id), bladeValue))
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,0.25F));
    public static final Weapon.Entry fire_orb = orb("fire_orb",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.BLAZE_ROD)), 1F,SpellSchools.FIRE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.FIRE.id), bladeValue))
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,0.25F));

    public static final Weapon.Entry arcane_orb = orb("arcane_orb",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(net.minecraft.item.Items.AMETHYST_SHARD)), 1F,SpellSchools.ARCANE)
            .attribute(ItemConfig.Attribute.bonus((SpellSchools.ARCANE.id), bladeValue))
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,0.25F));

    public static void register(Map<String, ItemConfig.Weapon> configs) {
        Weapon.register(configs, entries, RegistryKey.of(Registries.ITEM_GROUP.getKey(),new Identifier(Spellblades.MOD_ID,"generic")));
    }
}

