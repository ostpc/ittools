package ua.org.ostpc.ittools.dao;

import org.springframework.data.repository.CrudRepository;
import ua.org.ostpc.ittools.entity.HTMLTest;
import java.util.List;

public interface HTMLTestRepository extends CrudRepository<HTMLTest, Long>{
    List<HTMLTest> findByType(String type);

}

