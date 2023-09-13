package tdtu.edu.ex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tdtu.edu.ex05.models.Student;
import tdtu.edu.ex05.services.StudentServiceImp;

@SpringBootApplication
public class Ex05Application implements CommandLineRunner {
	@Autowired
	private StudentServiceImp studentServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(Ex05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = Student.builder()
				.name("van thao")
				.age(20)
				.email("vanthao@gmail.com")
				.ieltsScore(7.5)
				.build();
		studentServiceImp.save(student1);

		Student student2 = Student.builder()
				.name("thao tran")
				.age(22)
				.email("thaotran@gmail.com")
				.ieltsScore(8.0)
				.build();
		studentServiceImp.save(student2);

		Student student3 = Student.builder()
				.name("tran van thao")
				.age(21)
				.email("tranvanthao@gmail.com")
				.ieltsScore(6.5)
				.build();
		studentServiceImp.save(student3);

		// Read a list of students whose age is greater than or equal to x, where x is the input
		//parameter of the method.
		int age = 21;
		System.out.println("Find all by age greater than "+age);
		studentServiceImp.cau5a(age).forEach(System.out::println);
		Double ieltsScore = 6.5;
		// Count the number of students whose ielts score is equal to x, where x is an input
		// parameter of the method.
		System.out.println("Find all by ielts score equal "+ieltsScore);
		System.out.println(studentServiceImp.cau5b(ieltsScore));
		String xxx = "tran";
		System.out.println("Find all name containing '"+xxx+"'");
		studentServiceImp.cau5c(xxx).forEach(System.out::println);
	}
}
