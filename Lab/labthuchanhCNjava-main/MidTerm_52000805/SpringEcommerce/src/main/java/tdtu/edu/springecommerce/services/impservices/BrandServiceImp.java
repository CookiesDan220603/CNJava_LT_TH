package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.Brand;
import tdtu.edu.springecommerce.services.intservices.BrandService;

@Service
public class BrandServiceImp {
    @Autowired
    private BrandService brandService;
    public Iterable<Brand> findAll(){
        return brandService.findAll();
    }
}
