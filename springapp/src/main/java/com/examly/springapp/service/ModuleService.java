package com.examly.springapp.service;

import com.examly.springapp.model.Module;
import java.util.List;

public interface ModuleService {

    // Create a new module
    Module addModule(Module module);

    // Get all modules
    List<Module> getAllModules();

    // Get module by ID
    Module getModuleById(int id);

    // Update module details
    Module updateModule(int id, Module updatedModule);

    // Delete module by ID
    boolean deleteModule(int id);
}
