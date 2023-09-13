package tdtu.edu.ex02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.ex02.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}


