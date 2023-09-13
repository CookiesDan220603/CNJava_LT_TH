package tdtu.edu.springecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tdtu.edu.springecommerce.models.Product;
import tdtu.edu.springecommerce.services.impservices.*;

@SpringBootTest
class SpringEcommerceApplicationTests {
	@Autowired
	private BrandServiceImp brandServiceImp;

	@Autowired
	private CategoryServiceImp categoryServiceImp;

	@Autowired
	private ProductServiceImp productServiceImp;
	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private CustomerServiceImp customerServiceImp;
	@Autowired
	private CartServiceImp cartServiceImp;
	@Test
	void contextLoads() {
		System.out.println("Find all brand:");
		brandServiceImp.findAll().forEach(System.out::println);
		System.out.println("Find all category:");
		categoryServiceImp.findAll().forEach(System.out::println);
		System.out.println("Find all product:");
		productServiceImp.findAll().forEach(System.out::println);

		Product product;
		product = productServiceImp.findByID(1L);
		System.out.println("Find product by id: 1");
		System.out.println(product);
		System.out.println("Find all product have price less: 20");
		productServiceImp.findAllByLessPrice(20.0).forEach(System.out::println);
		System.out.println("Search product contain: Sne");
		productServiceImp.searchAdvance("Sne").forEach(System.out::println);

		System.out.println("Check username admin: "+userServiceImp.checkUserExist("admin"));
		System.out.println("Check username abc: "+userServiceImp.checkUserExist("abc"));
		System.out.println("User login is valid:");
		System.out.println("Login with username = admin and password = 123456:");
		System.out.println(userServiceImp.userLoginValid("admin","123456"));
		System.out.println("Login with username = admin and password = 1234:");
		System.out.println(userServiceImp.userLoginValid("admin","1234"));
		System.out.println("Find user by id: 3");
		System.out.println(userServiceImp.findById(3L));
		System.out.println("Find customer by id: 3");
		System.out.println(customerServiceImp.findById(3L));

		System.out.println("Check in cart of user has id is 3 have contain product has id is 3");
		System.out.println(cartServiceImp.checkProductExist(3L,3L));
		System.out.println("Find in cart of user has id is 3 have contain product has id is 2");
		System.out.println(cartServiceImp.findByUserIdAndProdId(3L,2L));
		System.out.println("Find all in cart of user has id is 3");
		cartServiceImp.findAllByUserID(3L).forEach(System.out::println);
		System.out.println("Check cart has id 16 is exist");
		System.out.println(cartServiceImp.checkByID(16L));
	}
}
