package myprojects.salesapp.data.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myprojects.salesapp.models.product.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Short> {

}
