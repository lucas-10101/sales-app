package myprojects.salesapp.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myprojects.salesapp.data.AuditableEntity;

@Data
@Entity
@Table(name = "brands")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Brand extends AuditableEntity<Short> {

    private String name;
}
