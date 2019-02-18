package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ua.org.ostpc.ittools.dao.EmployeeRepository;
import ua.org.ostpc.ittools.entity.Employees;

import java.util.List;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public Iterable findAll() {
        return employeeRepository.findAll();
    }

    /*@GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return employeeRepository.findByTitle(bookTitle);
    }
*/
    @GetMapping("{id}")
    public Employees findOne(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employees create(@RequestBody Employees employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employeeRepository.findById(id)
                .orElseThrow(NullPointerException::new);
        employeeRepository.deleteById(id);
    }

    @GetMapping("/create1/{fullName}/{salary}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employees createDefault(@PathVariable String fullName, @PathVariable double salary){
        Employees employees = new Employees();
        employees.setFullName(fullName);
        employees.setSalary(salary);
        return  employeeRepository.save(employees);
    }
    /*
    добавление книги и автора http://localhost:8080/api/books/title/create/book1/author1
    http://localhost:8080/api/Employee/create/book1/1
    */
    @PutMapping("/{id}")
    public Employees updateBook(@RequestBody Employees employee, @PathVariable Long id) {
        if (employee.getId() != id) {
            throw new NullPointerException();
        }
        employeeRepository.findById(id)
                .orElseThrow(NullPointerException::new);
        return employeeRepository.save(employee);
    }
}
