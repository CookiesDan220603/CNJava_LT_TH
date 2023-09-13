package tdtu.edu.ex02.repository;

import org.springframework.data.repository.CrudRepository;
import tdtu.edu.ex02.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
