package tdtu.edu.ex05.services;

import tdtu.edu.ex05.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp {
    @Autowired
    private StudentService studentService;
    public void save(Student student) {
        studentService.save(student);
    }
    public Iterable<Student> cau5a(int x){
        return studentService.cau5a(x);
    }
    public Integer cau5b(Double x){
        return studentService.cau5b(x);
    }
    public Iterable<Student> cau5c(String xxx){
        return studentService.cau5c(xxx);
    }
}