package ua.lviv.pancha.services;

import ua.lviv.pancha.entity.User;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 10.08.2016.
 */
public interface UserService
{
    void addOrEdit(User user);

    void delete(int id);

    List<User> findAll();

    User findOne(int id);
}
