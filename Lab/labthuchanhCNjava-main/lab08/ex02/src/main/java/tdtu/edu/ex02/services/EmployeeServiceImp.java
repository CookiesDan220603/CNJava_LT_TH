package tdtu.edu.ex02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.ex02.models.Employee;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmployeeService employeeService;
    public void init(){
        save(new Employee(1L,"a.@gmail.com","Tan phong, quan 7","0141414561","Tran Van Thao"));
        save(new Employee(2L,"b.@gmail.com","Tan phong, quan 7","01244219744","Tran Van Teo"));
        save(new Employee(3L,"c.@gmail.com","Tan phong, quan 7","014141423561","Tran Van Lord"));
    }
    public Employee save(Employee employee){
        return employeeService.save(employee);
    }
    public Iterable<Employee> findAll(){
        return employeeService.findAll();
    }

    public Employee findById(Long id) {return employeeService.findById(id).get();}

    public void deleteById(Long id) {
        employeeService.deleteById(id);
    }
}
