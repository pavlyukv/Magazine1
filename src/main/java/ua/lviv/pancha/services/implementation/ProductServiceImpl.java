package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.entity.Product;
import ua.lviv.pancha.repository.ProductRepo;
import ua.lviv.pancha.services.ProductService;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAllByGroup(Group group)
    {
        List<Product> productList = productRepo.findByGroup(group);

        // Sort by Name
        Collections.sort(productList, new Comparator<Product>()
        {
            @Override
            public int compare(Product o1, Product o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return productList;
    }

    public void add(String name, String description, Integer quantity, Double price, MultipartFile multipartFile, Group group)
    {
        Product product = new Product();
        if (name == null || name.isEmpty())
            name = "empty";
        product.setName(name);
        if (description == null || description.isEmpty())
            description = "none";
        product.setDescription(description);
        if (quantity == null || quantity < 0)
            quantity = 0;
        product.setQuantity(quantity);
        if (price == null || price < 0.0)
            price = 0.0;
        product.setPrice(price);
        try
        {
            if (multipartFile != null)
                product.setImage(multipartFile.getBytes());
        }
        catch (IOException e)
        {
        }
        product.setGroup(group);
        productRepo.save(product);
    }

    public void edit(String id, String name, String description, Integer quantity, Double price)
    {
        Product product = productRepo.findOne(Integer.parseInt(id));
        if (name == null || name.isEmpty())
            name = "empty";
        product.setName(name);
        if (description == null || description.isEmpty())
            description = "none";
        product.setDescription(description);
        if (quantity == null || quantity < 0)
            quantity = 0;
        product.setQuantity(quantity);
        if (price == null || price < 0.0)
            price = 0.0;
        product.setPrice(price);
        productRepo.save(product);
    }

    public void addOrEdit(Product product)
    {
        productRepo.save(product);
    }

    public void delete(int id)
    {
        productRepo.delete(id);
    }

    public List<Product> findAll()
    {
        return productRepo.findAll();
    }

    public Product findOne(int id)
    {
        return productRepo.findOne(id);
    }
}
