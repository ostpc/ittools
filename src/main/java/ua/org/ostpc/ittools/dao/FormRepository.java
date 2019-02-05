package ua.org.ostpc.ittools.dao;

import org.springframework.data.repository.CrudRepository;
import ua.org.ostpc.ittools.entity.Book;
import ua.org.ostpc.ittools.entity.Form;

import java.util.List;

public interface FormRepository  extends CrudRepository<Form, Long> {
    List<Form> findByName(String name);
}
