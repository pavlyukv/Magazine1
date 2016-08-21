package ua.lviv.pancha.services;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.entity.Product;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
public interface ProductService
{
    List<Product> findAllByGroup(Group group);

    void add(String name, String description, Integer quantity, Double price, MultipartFile multipartFile, Group group);

    void edit(String id, String name, String description, Integer quantity, Double price);

    void addOrEdit(Product product);

    void delete(int id);

    List<Product> findAll();

    Product findOne(int id);
}
