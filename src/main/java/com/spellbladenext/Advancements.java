package com.spellbladenext;

import com.spellbladenext.items.Items;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.PlayerHurtEntityCriterion;
import net.minecraft.advancement.criterion.PlayerInteractedWithEntityCriterion;
import net.minecraft.item.Item;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class Advancements implements Consumer<Consumer<Advancement>> {
    public Item[] spellblades = new Item[]{Items.fire_blade.item(),Items.arcane_blade.item(),Items.frost_blade.item()};
    public Item[] orbs = new Item[]{Items.fire_orb.item(),Items.arcane_orb.item(),Items.frost_orb.item()};
    public Item[] claymores = new Item[]{Items.frost_claymore.item(),Items.arcane_claymore.item(),Items.fire_claymore.item()};

    @Override
    public void accept(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        Items.arcane_blade.item(), // The display icon
                        Text.translatable("Fine, B-L-A-D-E"), // The title
                        Text.translatable("Obtain a Spellblade"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_spellblades", InventoryChangedCriterion.Conditions.items(spellblades))
                .build(consumer, "spellbladenext" + "/root");
        Advancement orbAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.arcane_claymore.item(), // The display icon
                        Text.translatable("Orbiting my Pond"), // The title
                        Text.translatable("Obtain an Orb"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_orbs", InventoryChangedCriterion.Conditions.items(orbs))
                .build(consumer, "spellbladenext" + "/orb");
        Advancement claymore = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.arcane_orb.item(), // The display icon
                        Text.translatable("Orbiting my Pond"), // The title
                        Text.translatable("Obtain an Orb"), // The description
                        null,
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_claymores", InventoryChangedCriterion.Conditions.items(claymores))
                .build(consumer, "spellbladenext" + "/claymore");

    }

}