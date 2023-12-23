package myprojects.salesapp.data.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myprojects.salesapp.models.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Short> {

}
