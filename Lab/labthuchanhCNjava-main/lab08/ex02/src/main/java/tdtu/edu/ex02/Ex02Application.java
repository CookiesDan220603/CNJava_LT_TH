package tdtu.edu.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tdtu.edu.ex02.services.EmployeeServiceImp;

@SpringBootApplication
public class Ex02Application implements CommandLineRunner {
@Autowired
private EmployeeServiceImp employeeServiceImp;
	public static void main(String[] args)  {
		SpringApplication.run(Ex02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeServiceImp.init();
	}
}
