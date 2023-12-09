package myprojects.salesapp.models.user;

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
public class UserRole {

	@Id
	@Column(insertable = false, updatable = false)
	private Integer id;

	@ManyToOne(optional = false)
	private User user;

	private ApplicationRoles role;
}
