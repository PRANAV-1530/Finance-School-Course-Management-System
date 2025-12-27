package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    private String moduleName;
    private String moduleDescription;
    private Integer duration;

    // Default constructor
    public Module() {
    }

    // Parameterized constructor (optional)
    public Module(Long moduleId, String moduleName, String moduleDescription, Integer duration) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
        this.duration = duration;
    }

    // Getters and Setters
    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public int getId() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public Object getName() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public void setName(Object name) {
         
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public Object getDescription() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    public void setDescription(Object description) {
         
        throw new UnsupportedOperationException("Unimplemented method 'setDescription'");
    }
}
