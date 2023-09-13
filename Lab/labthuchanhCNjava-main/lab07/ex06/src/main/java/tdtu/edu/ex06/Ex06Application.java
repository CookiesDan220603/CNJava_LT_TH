package tdtu.edu.ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tdtu.edu.ex06.models.Student;
import tdtu.edu.ex06.services.StudentServiceImp;

@SpringBootApplication
public class Ex06Application implements CommandLineRunner {
	@Autowired
	private StudentServiceImp studentServiceImp;
	public static void main(String[] args) {
		SpringApplication.run(Ex06Application.class, args);
	}

	@Override
	public void run(String... args) {
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

		Student student4 = Student.builder()
				.name("tran van thao 123")
				.age(25)
				.email("tranvanthao@gmail.com")
				.ieltsScore(6.5)
				.build();
		studentServiceImp.save(student4);
		Student student5 = Student.builder()
				.name("tran van thao 123")
				.age(26)
				.email("tranvanthao@gmail.com")
				.ieltsScore(6.5)
				.build();
		studentServiceImp.save(student5);
		Student student6 = Student.builder()
				.name("tran van thao 123")
				.age(27)
				.email("tranvanthao@gmail.com")
				.ieltsScore(6.5)
				.build();
		studentServiceImp.save(student6);
		System.out.println("All students sorted desc by Ages");
		Iterable<Student> students = studentServiceImp.findAllDescByAge();
		students.forEach(System.out::println);
		System.out.println("All students456 sorted desc by Ages");
		Page<Student> page = studentServiceImp.findAll(PageRequest.of(1, 3));
		Iterable<Student> students456 = page.getContent();
		students456.forEach(System.out::println);
	}
}
