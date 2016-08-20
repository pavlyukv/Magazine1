package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.pancha.entity.Basket;
import ua.lviv.pancha.repository.BasketRepo;
import ua.lviv.pancha.services.BasketService;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
@Service
public class BasketServiceImpl implements BasketService
{
    @Autowired
    private BasketRepo basketRepo;

    public void addOrEdit(Basket basket)
    {
        basketRepo.save(basket);
    }

    public void delete(int id)
    {
        basketRepo.delete(id);
    }

    public List<Basket> findAll()
    {
        return basketRepo.findAll();
    }

    public Basket findOne(int id)
    {
        return basketRepo.findOne(id);
    }
}
