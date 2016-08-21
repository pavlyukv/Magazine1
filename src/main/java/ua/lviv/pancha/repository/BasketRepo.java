package ua.lviv.pancha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.pancha.entity.Basket;
import ua.lviv.pancha.entity.User;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
public interface BasketRepo extends JpaRepository<Basket, Integer>
{
    List<Basket> findByUserAndOrdered(User user, boolean ordered);
}
