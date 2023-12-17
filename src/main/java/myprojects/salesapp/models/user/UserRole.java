package myprojects.salesapp.models.user;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import myprojects.salesapp.models.enums.ApplicationRoles;

/**
 * UserRole model.
 */
@Data
@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable = false, updatable = false)
	private Integer id;

	@ManyToOne(optional = false)
	private User user;

	private ApplicationRoles role;

	@Override
	public String getAuthority() {
		return role.name();
	}
}
