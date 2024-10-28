package com.spellbladenext.mixin;

import com.spellbladenext.Spellblades;
import com.spellbladenext.invasions.attackevent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.spell_engine.api.spell.ExternalSpellSchools;
import net.spell_engine.api.spell.Spell;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.internals.SpellRegistry;
import net.spell_engine.internals.casting.SpellCast;
import net.spell_power.api.SpellSchools;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SpellHelper.class)
public class SpellCastMixin {
   
    @Inject(at = @At("HEAD"), method = "performSpell", cancellable = true)
    private static void performSpellBlades(World world, PlayerEntity player, Identifier spellId, List<Entity> targets, SpellCast.Action action, float progress, CallbackInfo callbackInfo) {
        if (!player.isSpectator()) {
            Spell spell = SpellRegistry.getSpell(spellId);
            if (spell != null) {

                if (Spellblades.config.horde && spell.school != ExternalSpellSchools.PHYSICAL_RANGED && spell.school != ExternalSpellSchools.PHYSICAL_MELEE && spell.school != SpellSchools.HEALING) {
                    attackevent.horde(player,false);
                }
            }
        }
    }
}
