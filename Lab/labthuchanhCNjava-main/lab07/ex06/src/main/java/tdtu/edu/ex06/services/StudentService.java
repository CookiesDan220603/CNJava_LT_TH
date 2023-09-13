package tdtu.edu.ex06.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tdtu.edu.ex06.models.Student;

public interface StudentService{
    Student save(Student student);
    Iterable<Student> findAllDescByAge();

    Page<Student> findAll(PageRequest of);
}
