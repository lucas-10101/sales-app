package myprojects.salesapp.models.user;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "role_id")
    private ApplicationRoles role;

    @Override
    public String getAuthority() {
        return role.name();
    }

    @Override
    public String toString() {
        return "UserRole [id=" + id + ", role=" + role + "]";
    }

}
