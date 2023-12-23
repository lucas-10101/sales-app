package myprojects.salesapp.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import myprojects.salesapp.data.AuditableEntity;

@Data
@Entity
@Table(name = "subcategories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class SubCategory extends AuditableEntity<Short> {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
}
