package de.silencio.neon.module;

import de.silencio.neon.module.liveoverflow.AntiHumanBypass;
import de.silencio.neon.module.liveoverflow.WorldBorder;
import de.silencio.neon.module.movement.*;
import de.silencio.neon.module.other.ClientGameMode;
import de.silencio.neon.module.world.XRay;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Module> modules = new ArrayList<>();
    public ModuleManager() {
        addModules();
    }
    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getEnabledModules() {
        List<Module> enabled = new ArrayList<>();
        for (Module module : modules) { if (module.isEnabled()) enabled.add(module); }
        return enabled;
    }

    public Module getModule(String moduleKey) {
        for (Module moduleList : modules) {
            if (moduleList.getNameKey().equals(moduleKey))
                return moduleList;
        }
        return null;
    }

    public List<Module> getModulesInCategory(Module.Category category) {
        List<Module> modules = new ArrayList<>();

        for (Module module : ModuleManager.INSTANCE.getModules()) {
            if (module.getCategory() == category) modules.add(module);
        }

        return modules;
    }

    private void addModules() {
        modules.add(new Flight());
        modules.add(new Sprint());
        modules.add(new ClientGameMode());
        modules.add(new AntiHumanBypass());
        modules.add(new VClip());
        modules.add(new WorldBorder());
        modules.add(new XRay());
        modules.add(new NoFall());
    }

}
