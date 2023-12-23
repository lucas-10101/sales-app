package myprojects.salesapp.data.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myprojects.salesapp.models.product.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Short> {

}
