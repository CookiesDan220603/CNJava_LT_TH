package lab06_ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.tdtu.lab06_ex02.Product;

@Configuration
public class appConfig {
	@Bean
	@Scope("prototype")
	public Product firstProduct() {
		Product product = new Product();
		product.setId("P01");
		product.setName("Iphone 14");
		product.setDescription("Same as iphone 13");
		
		return product;
	}
	
	@Bean
	@Scope("prototype")
	public Product secondProduct() {
		return new Product("P02", "Iphone 14 Plus", "Best battery usage");
	}
	
	@Bean
	public Product thirdProduct() {
		return new Product("P03", "Iphone 14 Pro Max", "Dynamic Island");
	}
}
