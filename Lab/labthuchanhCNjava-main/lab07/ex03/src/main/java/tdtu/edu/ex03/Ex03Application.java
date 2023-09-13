package tdtu.edu.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tdtu.edu.ex03.services.StudentServiceImp;
import tdtu.edu.ex03.models.Student;

@SpringBootApplication
public class Ex03Application implements CommandLineRunner{
	@Autowired
	private StudentServiceImp studentServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(Ex03Application.class, args);
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

		// Read all students
		Iterable<Student> students = studentServiceImp.findAll();
		students.forEach(System.out::println);

		// update
		Student studentToUpdate = studentServiceImp.findById(student1.getId()).orElse(null);
		if (studentToUpdate != null) {
			studentToUpdate.setName("king of lord");
			studentServiceImp.update(studentToUpdate);
		}
		System.out.println("After update--------------------------------------------------------------------");
		students = studentServiceImp.findAll();
		students.forEach(System.out::println);

		// delete
		studentServiceImp.deleteById(student2.getId());
		System.out.println("After delete-------------------------------------------------------------------");
		students = studentServiceImp.findAll();
		students.forEach(System.out::println);
	}
}
