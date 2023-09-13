package tdtu.edu.springecommerce.repostiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.springecommerce.models.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Long> {
}
