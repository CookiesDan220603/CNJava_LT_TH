package tdtu.edu.ex03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.ex03.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}


