package de.silencio.neon.ui;

import de.silencio.neon.module.Module;
import de.silencio.neon.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TextColor;
import net.minecraft.text.TextContent;
import net.minecraft.util.Formatting;

import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class Hud {

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(MatrixStack matrices, float tickDelta) {
        renderArrayList(matrices);
    }

    public static void renderArrayList(MatrixStack matrices) {
        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();
        List<Module> enabled = ModuleManager.INSTANCE.getEnabledModules();

        enabled.sort(Comparator.comparingInt(m -> mc.textRenderer.getWidth(((Module)m).getDescription())).reversed());

        for (Module module : enabled) {
            mc.textRenderer.drawWithShadow(matrices, module.getName(), (sWidth-4) - mc.textRenderer.getWidth(module.getName()), 10+(index*mc.textRenderer.fontHeight), -1);
            index++;
        }
    }
}
