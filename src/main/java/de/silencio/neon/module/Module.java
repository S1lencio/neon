package de.silencio.neon.module;

import net.minecraft.client.MinecraftClient;

public class Module {

    private String name;
    private String displayName;
    private String description;
    private Category category;
    private int key;
    private boolean enabled;
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public Module(String name, String description, Category category) {
        this.name = name;
        this.displayName = name;
        this.description = description;
        this.category = category;
    }

    public void toggle() {
        this.enabled = !this.enabled;

        if (enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void onTick() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() { return displayName; }

    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) onEnable();
        else onDisable();
    }

    public enum Category {
        COMBAT, MOVEMENT, RENDER, EXPLOIT, WORLD, LIVEOVERFLOW, OTHER
    }
}
