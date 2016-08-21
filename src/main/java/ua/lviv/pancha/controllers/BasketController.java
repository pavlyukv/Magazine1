package ua.lviv.pancha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.pancha.entity.Basket;
import ua.lviv.pancha.entity.Product;
import ua.lviv.pancha.entity.User;
import ua.lviv.pancha.services.BasketService;
import ua.lviv.pancha.services.ProductService;
import ua.lviv.pancha.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 20.08.2016.
 */
@Controller
public class BasketController
{
    @Autowired
    private BasketService basketService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    // Show basket
    @RequestMapping(value = "/cabinet/basket", method = RequestMethod.GET)
    public String showBasket(Principal principal, Model model)
    {
        Basket basket = basketService.giveMyBasket(userService.findOne(Integer.parseInt(principal.getName())));
        List<Product> productList = basket.getProductList();

        double sum = 0.0;
        for (Product product : productList)
            sum += product.getPrice();

        model.addAttribute("products", productList);
        model.addAttribute("sum", sum);
        return "group/basket";
    }

    // Add product to basket
    @RequestMapping(value = "/cabinet/add/{id}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable String id, Principal principal)
    {
        Basket basket = basketService.giveMyBasket(userService.findOne(Integer.parseInt(principal.getName())));
        List<Product> productList = basket.getProductList();

        Product product = null;
        try
        {
            int i = Integer.parseInt(id);
            if (i <= 0)
                throw new Exception();
            product = productService.findOne(i);
            if (product == null)
                throw new Exception();
        }
        catch(Exception e)
        {
            return "redirect:/group/all";
        }

        if (product.getQuantity() > 0)
            productList.add(product);

        basket.setProductList(productList);
        basketService.addOrEdit(basket);

        return "redirect:/cabinet/basket";
    }

    @RequestMapping(value = "/cabinet/clear", method = RequestMethod.GET)
    public String clearBasket(Principal principal)
    {
        Basket basket = basketService.giveMyBasket(userService.findOne(Integer.parseInt(principal.getName())));
        basket.setProductList(new ArrayList<>());
        basketService.addOrEdit(basket);
        return "redirect:/cabinet/basket";
    }
}
