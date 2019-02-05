package ua.org.ostpc.ittools.dao;

import org.springframework.data.repository.CrudRepository;
import ua.org.ostpc.ittools.entity.Book;
import ua.org.ostpc.ittools.entity.Employees;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employees, Long> {
    /*List<Employees> findByTitle(String title);*/
}
