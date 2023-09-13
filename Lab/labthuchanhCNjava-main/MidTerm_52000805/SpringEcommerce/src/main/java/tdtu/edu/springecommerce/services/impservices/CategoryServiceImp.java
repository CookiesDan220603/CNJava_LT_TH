package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.Category;
import tdtu.edu.springecommerce.services.intservices.CategoryService;

@Service
public class CategoryServiceImp {
    @Autowired
    private CategoryService categoryService;

    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }
}
