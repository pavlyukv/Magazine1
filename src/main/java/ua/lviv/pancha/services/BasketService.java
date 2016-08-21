package ua.lviv.pancha.services;

import ua.lviv.pancha.entity.Basket;
import ua.lviv.pancha.entity.User;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
public interface BasketService
{
    Basket giveMyBasket(User user);

    List<Basket> findUserBaskets(User user, boolean ordered);

    void addOrEdit(Basket basket);

    void delete(int id);

    List<Basket> findAll();

    Basket findOne(int id);
}
