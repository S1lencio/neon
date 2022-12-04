package de.silencio.neon.module.world;

import de.silencio.neon.module.Module;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.lwjgl.glfw.GLFW;

import java.util.HashSet;

public class XRay extends Module {

    MinecraftClient client = MinecraftClient.getInstance();
    double defaultGamma;

    public XRay() {
        super("XRay", "xray", "Only draw wanted blocks", Category.RENDER, Type.TOGGLE, false);
        setKey(GLFW.GLFW_KEY_X);
    }

    public static boolean showBlock(BlockState state) {
        HashSet<String> xrayBlocks = new HashSet<>();

        xrayBlocks.add("Block{minecraft:coal_ore}");
        xrayBlocks.add("Block{minecraft:iron_ore}");
        xrayBlocks.add("Block{minecraft:gold_ore}");
        xrayBlocks.add("Block{minecraft:diamond_ore}");
        xrayBlocks.add("Block{minecraft:emerald_ore}");
        xrayBlocks.add("Block{minecraft:lapis_ore}");
        xrayBlocks.add("Block{minecraft:redstone_ore}");
        xrayBlocks.add("Block{minecraft:copper_ore");
        xrayBlocks.add("Block{minecraft:deepslate_coal_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_iron_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_gold_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_diamond_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_emerald_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_lapis_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_redstone_ore}");
        xrayBlocks.add("Block{minecraft:deepslate_copper_ore}");
        xrayBlocks.add("Block{minecraft:coal_block}");
        xrayBlocks.add("Block{minecraft:iron_block}");
        xrayBlocks.add("Block{minecraft:gold_block}");
        xrayBlocks.add("Block{minecraft:diamond_block}");
        xrayBlocks.add("Block{minecraft:emerald_block}");
        xrayBlocks.add("Block{minecraft:lapis_block}");
        xrayBlocks.add("Block{minecraft:redstone_block}");

        xrayBlocks.add("Block{minecraft:chest}");
        xrayBlocks.add("Block{minecraft:trapped_chest}");
        xrayBlocks.add("Block{minecraft:mob_spawner}");
        xrayBlocks.add("Block{minecraft:spawner}");
        xrayBlocks.add("Block{minecraft:bookshelf}");
        xrayBlocks.add("Block{minecraft:ancient_debris}");
        xrayBlocks.add("Block{minecraft:nether_gold_ore}");
        xrayBlocks.add("Block{minecraft:nether_quartz_ore}");
        xrayBlocks.add("Block{minecraft:glowstone}");
        xrayBlocks.add("Block{minecraft:bone_block}");
        xrayBlocks.add("Block{minecraft:obsidian}");
        xrayBlocks.add("Block{minecraft:netherite_block}");
        xrayBlocks.add("Block{minecraft:magma_block}");
        xrayBlocks.add("Block{minecraft:lava}");
        xrayBlocks.add("Block{minecraft:water}");

        return xrayBlocks.contains(state.getBlock().toString());
    }

    //public void addXrayBlock(String block) {
    //    this.xrayBlocks.add(block);
    //}

    //public void removeXrayBlock(String block) {
    //    this.xrayBlocks.remove(block);
    //}

    //public HashSet<String> getXrayBlocks() {
    //    return xrayBlocks;
    //}


    @Override
    public void onEnable() {
        defaultGamma = client.options.getGamma().getValue();
        client.options.getGamma().setValue(1000D);
        if (client.player != null) {
            client.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, Integer.MAX_VALUE));
        }
        mc.worldRenderer.reload();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        client.options.getGamma().setValue(defaultGamma);
        if (client.player != null) {
            client.player.removeStatusEffectInternal(StatusEffects.NIGHT_VISION);
        }
        mc.worldRenderer.reload();
        super.onDisable();
    }
}
