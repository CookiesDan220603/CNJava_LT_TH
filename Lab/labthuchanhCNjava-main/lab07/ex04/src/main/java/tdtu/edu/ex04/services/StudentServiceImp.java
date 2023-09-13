package tdtu.edu.ex04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.ex04.models.Student;

import java.util.Optional;

@Service
public class StudentServiceImp {
    @Autowired
    private StudentService studentService;
    public Iterable<Student> findAll() {
        return studentService.findAll();
    }

    public void save(Student student) {
        studentService.save(student);
    }

    public void deleteById(Long id) {
        studentService.deleteById(id);
    }
    public void update(Student student) {
        studentService.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentService.findById(id);
    }
    public Iterable<Student> findAllByAgeGreaterThanX(int x){
        return studentService.findAllByAgeGreaterThan(x);
    }
    public Iterable<Student> countStudentByIeltsScoreEquals(Double x){
        return studentService.countStudentByIeltsScoreEquals(x);
    }
    public Iterable<Student> findAllByNameContainingXXX(String xxx){
        return studentService.findAllByNameContaining(xxx);
    }
}