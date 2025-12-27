package com.examly.springapp.controller;

import com.examly.springapp.model.Module;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/modules")  // ✅ Added class-level RequestMapping
public class ModuleController {

    private List<Module> moduleList = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<String> createModule(@RequestBody(required = false) Module module) {
        if (module == null) {
            return new ResponseEntity<>("Request body is missing", HttpStatus.BAD_REQUEST);
        }
        moduleList.add(module);
        return new ResponseEntity<>("Module created", HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Module>> getAllModules() {
        if (moduleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moduleList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateModule(@PathVariable int id, @RequestBody Module updatedModule) {
        for (Module module : moduleList) {
            if (module.getId() == id) {
                module.setName(updatedModule.getName());
                module.setDescription(updatedModule.getDescription());
                module.setDuration(updatedModule.getDuration());
                return new ResponseEntity<>("Module updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Module not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable int id) {
        for (Module module : moduleList) {
            if (module.getId() == id) {
                moduleList.remove(module);
                return new ResponseEntity<>("Module deleted", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Module not found", HttpStatus.NOT_FOUND);
    }
}
