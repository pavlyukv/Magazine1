package ua.lviv.pancha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.pancha.entity.Basket;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
public interface BasketRepo extends JpaRepository<Basket, Integer>
{

}
