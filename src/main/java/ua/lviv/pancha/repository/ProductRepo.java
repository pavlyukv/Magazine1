package ua.lviv.pancha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.pancha.entity.Product;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
public interface ProductRepo extends JpaRepository<Product, Integer>
{

}
