package tdtu.edu.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tdtu.edu.ex04.models.Student;
import tdtu.edu.ex04.services.StudentServiceImp;

@SpringBootApplication
public class Ex04Application implements CommandLineRunner {
	@Autowired
	StudentServiceImp studentServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(Ex04Application.class, args);
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
		studentServiceImp.findAllByAgeGreaterThanX(age).forEach(System.out::println);
		Double ieltsScore = 6.5;
		// Count the number of students whose ielts score is equal to x, where x is an input
		// parameter of the method.
		System.out.println("Count student by ielts score equal "+ieltsScore);
		System.out.println(studentServiceImp.countStudentByIeltsScoreEquals(ieltsScore));
		String xxx = "tran";
		System.out.println("Find all name containing '"+xxx+"'");
		studentServiceImp.findAllByNameContainingXXX(xxx).forEach(System.out::println);
	}
}
