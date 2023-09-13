package tdtu.edu.ex05.services;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tdtu.edu.ex05.models.Student;
import tdtu.edu.ex05.repository.StudentRepository;

@Service
public interface StudentService extends StudentRepository {
    @Query(value = "select s from Student s where s.age =:x")
    public Iterable<Student> cau5a (Integer x);
    @Query(value = "select count(s) from Student s where s.ieltsScore=:x")
    public Integer cau5b(Double x);
    @Query(value = "select s from Student s where s.name like %:xxx%")
    public Iterable<Student> cau5c(String xxx);
}
