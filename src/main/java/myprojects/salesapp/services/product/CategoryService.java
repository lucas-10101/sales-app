package myprojects.salesapp.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import myprojects.salesapp.data.product.CategoryRepository;
import myprojects.salesapp.models.product.Category;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Category save(Category category) {

        category = categoryRepository.save(category);

        return category;
    }
}
