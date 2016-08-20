package ua.lviv.pancha.services;

import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.entity.Product;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
public interface ProductService
{
    void addOrEdit(Product product);

    void delete(int id);

    List<Product> findAll();

    Product findOne(int id);
}
