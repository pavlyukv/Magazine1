package ua.lviv.pancha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.pancha.entity.User;

/**
 * Created by Vasyl.Pavlyuk on 08.08.2016.
 */
public interface UserRepo extends JpaRepository<User, Integer>
{
    @Query("SELECT u FROM User u WHERE u.email LIKE :login OR u.phone LIKE :login")
    User findByLogin(@Param("login") String login);
}
