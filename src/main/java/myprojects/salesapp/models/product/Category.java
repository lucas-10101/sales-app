package myprojects.salesapp.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myprojects.salesapp.data.AuditableEntity;
import myprojects.salesapp.models.user.User;

@Data
@Entity
@Table(name = "categories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Category extends AuditableEntity<User, Integer> {

    private String name;
}
