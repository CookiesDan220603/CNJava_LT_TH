package tdtu.edu.lab09_10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tdtu.edu.lab09_10.model.Product;
import tdtu.edu.lab09_10.service.ProductServiceImp;

@SpringBootApplication
public class Lab0910Application {
	@Autowired
	private ProductServiceImp productServiceImp;
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			productServiceImp.save(new Product(1L,"Iphone 14",88.0,"product1.png","Em dep lam"));
			productServiceImp.save(new Product(2L,"Iphone 13",88.0,"product1.png","Em dep qua"));
			productServiceImp.save(new Product(3L,"Iphone 12",88.0,"product1.png","Em dep ok"));
			productServiceImp.save(new Product(4L,"Iphone 11",88.0,"product1.png","Em dep nice"));
			productServiceImp.save(new Product(5L,"Iphone 10",88.0,"product1.png","Em dep yet"));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Lab0910Application.class, args);
	}

}
