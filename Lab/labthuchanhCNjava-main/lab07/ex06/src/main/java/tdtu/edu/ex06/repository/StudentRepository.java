package tdtu.edu.ex06.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.ex06.models.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    default List<Student> findStudentsSortedByAgeAndIeltsScore() {
        Sort sort = Sort.by(Sort.Order.desc("age"), Sort.Order.asc("ieltsScore"));
        return findAll(sort);
    }
}


