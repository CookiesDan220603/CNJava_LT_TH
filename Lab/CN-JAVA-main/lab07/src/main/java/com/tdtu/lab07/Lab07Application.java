package com.tdtu.lab07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.tdtu.lab07.entities.Student;
import com.tdtu.lab07.repositories.IStudentRepository;
import com.tdtu.lab07.repositories.IStudentRepositoryPagination;


@SpringBootApplication
public class Lab07Application {

private static Logger LOG = LoggerFactory.getLogger(Lab07Application.class);
	
	@Autowired
	private IStudentRepository iStudentRepository;
	@Autowired
    private IStudentRepositoryPagination iStudentRepositoryPagination;
	
	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(Lab07Application.class, args);
		print();
        LOG.info("APPLICATION FINISHED");
	}
	
	@Bean
	public static void print() {
        System.out.println("Java Technology Demo Lab07");
    }
	
	@Component
	@Order(value = 1)
	class CreateStudent implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			iStudentRepository.save(Student.builder().name("NPDKhang").age(22).email(
					"NPDKhang@gmail.com").ieltsScore(7.0).build());
			iStudentRepository.save(Student.builder().name("NPDuy").age(21).email(
					"NPDuy@gmail.com").ieltsScore(6.5).build());
			iStudentRepository.save(Student.builder().name("NPhuc").age(23).email(
					"NPhuc@gmail.com").ieltsScore(8.0).build());
			LOG.info("After create students");
			
		}
	}
	
	@Component
	@Order(value = 2)
	class ReadStudent implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception{
			for(Student student : iStudentRepository.findAll()) {
				LOG.info(student.toString());
			}
		}
	}
	
	@Component
	@Order(value = 3)
	class UpdateStudent implements CommandLineRunner {
		@Autowired
		private ReadStudent readStudent;
		
		@Override
		public void run(String... args) throws Exception{
			Student student = iStudentRepository.findById(Long.parseLong("1")).get();
			if(student != null) {
				student.setName("NPDuyKhang");
				iStudentRepository.save(student);
				LOG.info("After update student");
				readStudent.run(args);
			}
		}
	}
	
	@Component
	@Order(value = 4)
	class DeleteStudent implements CommandLineRunner {
		@Autowired
		private ReadStudent readStudent;
		
		@Override
		public void run(String... args) throws Exception{
			Student student = iStudentRepository.findById(Long.parseLong("1")).get();
			if(student != null) {
				iStudentRepository.delete(student);
				LOG.info("After delete student");
				readStudent.run(args);
			}
		}
	}
	
	@Component
    @Order(value = 5)
    class ReadStudentAge implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            Pageable pageable = PageRequest.of(2, 3);
            for (Student student :
                    iStudentRepositoryPagination.findAllByOrderByAgeDescIeltsScoreAsc()) {
                LOG.info(student.toString());
            }
        }
    }

}
