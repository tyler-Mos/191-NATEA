package com.example.natea.nateawebappproject.security;

public enum ApplicationUserPermission {
    //MEMBER_PROFILE_WRITE("member:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
