package ua.org.ostpc.ittools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ua.org.ostpc.ittools.dao.EmployeeRolesRepository;

import ua.org.ostpc.ittools.entity.EmployeeRoles;

import java.util.List;

@RestController
@RequestMapping("/api/EmployeeRoles")
public class EmployeeRolesController {

    @Autowired
    private EmployeeRolesRepository employeeRoles;

    @GetMapping
    public Iterable findAll() {
        return employeeRoles.findAll();
    }

 /*   @GetMapping("/title/{employeeRolesTitle}")
    public List findByTitle(@PathVariable String employeeRoles) {
        return employeeRoles.findByTitle1(employeeRoles);
    }*/

    @GetMapping("/{id}")
    public EmployeeRoles findOne(@PathVariable Long id) {
        return employeeRoles.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRoles create(@RequestBody EmployeeRoles employeeRoles1) {
        return employeeRoles.save(employeeRoles1);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRoles.findById(id)
                .orElseThrow(NullPointerException::new);
        employeeRoles.deleteById(id);
    }

    @GetMapping("/title/create/{Title}")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeRoles createDefault(@PathVariable String Title){
        EmployeeRoles Employee = new EmployeeRoles();
        Employee.setTitle(Title);
        return  employeeRoles.save(Employee);
    }


    @PutMapping("/{id}")
    public EmployeeRoles updateBook(@RequestBody EmployeeRoles Employee, @PathVariable Long id) {
        if (Employee.getId() != id) {
            throw new NullPointerException();
        }
        employeeRoles.findById(id)
                .orElseThrow(NullPointerException::new);
        return employeeRoles.save(Employee);
    }
}
