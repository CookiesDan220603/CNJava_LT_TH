package tdtu.edu.ex06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tdtu.edu.ex06.models.Student;
import tdtu.edu.ex06.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAllDescByAge() {
        return studentRepository.findStudentsSortedByAgeAndIeltsScore();
    }

    @Override
    public Page<Student> findAll(PageRequest of) {
        return studentRepository.findAll(of);
    }
}