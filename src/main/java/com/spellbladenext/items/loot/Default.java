package com.spellbladenext.items.loot;

import com.spellbladenext.items.Items;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.loot.LootConfigV2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Default {
    public final static ItemConfig itemConfig;
    public final static LootConfigV2 lootConfig;
    static {
        itemConfig = new ItemConfig();
        for (var weapon : Items.entries) {
            itemConfig.weapons.put(weapon.name(), weapon.defaults());
        }


        lootConfig = new LootConfigV2();
    }

    @SafeVarargs
    private static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
