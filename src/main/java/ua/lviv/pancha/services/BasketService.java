package ua.lviv.pancha.services;

import ua.lviv.pancha.entity.Basket;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
public interface BasketService
{
    void addOrEdit(Basket basket);

    void delete(int id);

    List<Basket> findAll();

    Basket findOne(int id);
}
