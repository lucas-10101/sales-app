package myprojects.salesapp.models.user;

import org.springframework.data.jpa.domain.AbstractAuditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User model.
 */
@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends AbstractAuditable<User, Integer> {

	@Id
	@EqualsAndHashCode.Include
	@Column(insertable = false, updatable = false)
	private Integer id;

	@Column(updatable = false)
	private String username;

	@Column(updatable = false)
	private String password;

	private boolean active;
}
