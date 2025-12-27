package com.examly.springapp.service;

import com.examly.springapp.model.Module;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    private List<Module> moduleList = new ArrayList<>();

    @Override
    public Module addModule(Module module) {
        moduleList.add(module);
        return module;
    }

    @Override
    public List<Module> getAllModules() {
        return moduleList;
    }

    @Override
    public Module getModuleById(int id) {
        for (Module module : moduleList) {
            if (module.getId() == id) {
                return module;
            }
        }
        return null;
    }

    @Override
    public Module updateModule(int id, Module updatedModule) {
        for (Module module : moduleList) {
            if (module.getId() == id) {
                module.setName(updatedModule.getName());
                module.setDescription(updatedModule.getDescription());
                module.setDuration(updatedModule.getDuration());
                return module;
            }
        }
        return null;
    }

    @Override
    public boolean deleteModule(int id) {
        return moduleList.removeIf(module -> module.getId() == id);
    }
}
