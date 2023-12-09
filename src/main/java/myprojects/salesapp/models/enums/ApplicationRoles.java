package myprojects.salesapp.models.enums;

import lombok.Getter;

@Getter
public enum ApplicationRoles {

	LOGIN(1);

	private final int applicationRoleId;

	private ApplicationRoles(int applicationRoleId) {
		this.applicationRoleId = applicationRoleId;
	}
}
