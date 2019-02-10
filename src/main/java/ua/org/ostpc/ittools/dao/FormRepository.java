package ua.org.ostpc.ittools.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.org.ostpc.ittools.entity.Book;
import ua.org.ostpc.ittools.entity.Form;

import java.util.List;

public interface FormRepository  extends CrudRepository<Form, Long> {

    List<Form> findByName(String name);

    List<Form> findByLevel(int level);

    List<Form> findById(long id);

    @Transactional
    @Modifying
    @Query("update Form form set form.level = :level where form.id = :id")
    void setLevelForForm(@Param("level") Integer level, @Param("id") Long id);

}
