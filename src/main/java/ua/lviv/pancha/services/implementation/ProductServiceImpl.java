package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.pancha.entity.Product;
import ua.lviv.pancha.repository.ProductRepo;
import ua.lviv.pancha.services.ProductService;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepo productRepo;

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
