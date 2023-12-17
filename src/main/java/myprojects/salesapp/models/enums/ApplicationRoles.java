package myprojects.salesapp.models.enums;

import lombok.Getter;

@Getter
public enum ApplicationRoles {

    LOGIN(1);

    private final int applicationRoleId;

    private ApplicationRoles(int applicationRoleId) {
        this.applicationRoleId = applicationRoleId;
    }

    public static ApplicationRoles getByRoleId(int roleId) {
        for (var role : ApplicationRoles.values()) {
            if (role.getApplicationRoleId() == roleId)
                return role;
        }
        throw new RuntimeException("Application role with id " + roleId + " not found!");
    }
}
