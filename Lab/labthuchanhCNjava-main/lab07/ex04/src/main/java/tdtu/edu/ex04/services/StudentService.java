package tdtu.edu.ex04.services;

import org.springframework.stereotype.Service;
import tdtu.edu.ex04.models.Student;
import tdtu.edu.ex04.repository.StudentRepository;

@Service
public interface StudentService extends StudentRepository {
    public Iterable<Student> findAllByAgeGreaterThan(Integer x);
    public Iterable<Student> countStudentByIeltsScoreEquals(Double x);
    public Iterable<Student> findAllByNameContaining(String xxx);
}
