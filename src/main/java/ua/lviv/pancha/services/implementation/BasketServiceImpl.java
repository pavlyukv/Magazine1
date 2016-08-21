package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.pancha.entity.Basket;
import ua.lviv.pancha.entity.Product;
import ua.lviv.pancha.entity.User;
import ua.lviv.pancha.repository.BasketRepo;
import ua.lviv.pancha.services.BasketService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
@Service
public class BasketServiceImpl implements BasketService
{
    @Autowired
    private BasketRepo basketRepo;

    public Basket giveMyBasket(User user)
    {
        Basket basket;
        List<Basket> basketList = findUserBaskets(user, false);
        if (basketList == null || basketList.size() == 0)
        {
            basket = new Basket();
            basket.setUser(user);
            basket.setProductList(new ArrayList<>());
        }
        else
            basket = basketList.get(0);

        return basket;
    }

    public List<Basket> findUserBaskets(User user, boolean ordered)
    {
        return basketRepo.findByUserAndOrdered(user, ordered);
    }

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
