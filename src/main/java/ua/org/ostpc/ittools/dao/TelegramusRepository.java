package ua.org.ostpc.ittools.dao;

import org.springframework.data.repository.CrudRepository;
import ua.org.ostpc.ittools.entity.Telegramus;

import java.util.List;

public interface TelegramusRepository extends CrudRepository<Telegramus, Long>  {

    List<Telegramus> findByTelegramname (String telegramname);
    List<Telegramus> findByUsername (String name);
    List<Telegramus> findById(long id);
}
