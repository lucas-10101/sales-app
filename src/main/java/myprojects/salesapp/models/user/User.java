package myprojects.salesapp.models.user;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myprojects.salesapp.data.AuditableEntity;

/**
 * User model.
 */
@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends AuditableEntity<User, Integer> {

	@Column(updatable = false)
	private String username;

	@Column(updatable = false)
	private String password;

	private boolean active;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private final List<UserRole> roles = new LinkedList<>();
}
