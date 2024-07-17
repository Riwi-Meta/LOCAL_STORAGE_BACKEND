package com.riwi.localstorage.riwi_local_storage.util.enums;

public enum RoleType{
    USER("BASIC USER"),
    ADMIN("ADMINISTRATOR");
    
    private String description;
    
    RoleType(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
}