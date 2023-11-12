package store.springcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
//@EnableJpaRepositories("store.springcommerce.repository")
@EntityScan("store.springcommerce.model")
public class SpringCommerceApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SpringCommerceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringCommerceApplication.class);
	}
}
