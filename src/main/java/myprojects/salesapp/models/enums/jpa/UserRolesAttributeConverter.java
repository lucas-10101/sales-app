package myprojects.salesapp.models.enums.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import myprojects.salesapp.models.enums.ApplicationRoles;

/**
 * JPA AttributeConverter for ApplicationRoles
 */
@Converter(autoApply = true)
public class UserRolesAttributeConverter implements AttributeConverter<ApplicationRoles, Integer> {

	@Override
	public Integer convertToDatabaseColumn(ApplicationRoles attribute) {
		return attribute != null ? attribute.getApplicationRoleId() : null;
	}

	@Override
	public ApplicationRoles convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
			return null;

		for (var role : ApplicationRoles.values()) {
			if (role.getApplicationRoleId() == dbData)
				return role;
		}
		throw new RuntimeException("Application role with id " + dbData + " not found!");
	}

}
