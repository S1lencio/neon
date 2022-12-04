package de.silencio.neon.module;

import com.mojang.datafixers.FunctionType;
import net.minecraft.client.MinecraftClient;

public class Module {

    private String name;
    private String nameKey;
    private String displayName;
    private String description;
    private Category category;
    private Type type;
    private int key;
    private boolean enabled;
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public Module(String name, String nameKey, String description, Category category, Type type, boolean defaultState) {
        this.name = name;
        this.nameKey = nameKey;
        if (type == Type.TOGGLE) {
            if (defaultState) this.displayName = name + " is enabled";
            else this.displayName = name + " is disabled";
        } else {
            this.displayName = name;
        }
        this.description = description;
        this.category = category;
        this.type = type;
        this.enabled = defaultState;
    }

    public void toggle() {
        this.enabled = !this.enabled;

        if (enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {
        if (this.type == Type.TOGGLE) this.displayName = this.name + " is enabled";
    }

    public void onDisable() {
        if (this.type == Type.TOGGLE) this.displayName = this.name + " is disabled";
    }

    public void onTick() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
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

    public enum Category { COMBAT, MOVEMENT, RENDER, EXPLOIT, WORLD, LIVEOVERFLOW, OTHER }
    public enum Type { TOGGLE, SWITCH, BUTTON }
}
