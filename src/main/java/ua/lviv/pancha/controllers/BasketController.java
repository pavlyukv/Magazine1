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
import java.util.Calendar;
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
        {
            if (product == null)
                continue;
            sum += product.getPrice();
        }

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
        else
            return "redirect:/group/all";

        basket.setProductList(productList);
        basketService.addOrEdit(basket);

        return "redirect:/cabinet/basket";
    }

    // Remove product from basket
    @RequestMapping(value = "/cabinet/remove/{id}", method = RequestMethod.GET)
    public String removeFromBasket(@PathVariable String id, Principal principal)
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

        productList.remove(productList.indexOf(product));
        basket.setProductList(productList);
        basketService.addOrEdit(basket);

        return "redirect:/cabinet/basket";
    }

    // Cler all from basket
    @RequestMapping(value = "/cabinet/clear", method = RequestMethod.GET)
    public String clearBasket(Principal principal)
    {
        Basket basket = basketService.giveMyBasket(userService.findOne(Integer.parseInt(principal.getName())));
        basket.setProductList(new ArrayList<>());
        basketService.addOrEdit(basket);
        return "redirect:/cabinet/basket";
    }

    // Order\buy products from basket
    @RequestMapping(value = "/cabinet/buy", method = RequestMethod.GET)
    public String orderBasket(Principal principal)
    {
        Basket basket = basketService.giveMyBasket(userService.findOne(Integer.parseInt(principal.getName())));
        List<Product> productList = basket.getProductList();
        if(productList.isEmpty())
            return "redirect:/cabinet/basket";

        List<Product> orderedList = new ArrayList<>();
        for (Product product : productList)
        {
            int quantity = product.getQuantity();
            if (quantity > 0)
            {
                quantity--;
                product.setQuantity(quantity);
                orderedList.add(product);
                productService.addOrEdit(product);
            }
        }
        if(orderedList.isEmpty())
            return "redirect:/cabinet/clear";

        basket.setProductList(orderedList);
        basket.setOrdered(true);
        basket.setRegistrationDate(Calendar.getInstance().getTime());
        basketService.addOrEdit(basket);
        return "redirect:/cabinet/orders";
    }

    // My orders
    @RequestMapping(value = "/cabinet/orders", method = RequestMethod.GET)
    public String myOrders(Principal principal, Model model)
    {
        List<Basket> basketList = basketService.findUserBaskets(userService.findOne(Integer.parseInt(principal.getName())), true);
        model.addAttribute("orders", basketList);
        return "group/orders";
    }

    // All orders
    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String allOrders(Model model)
    {
        model.addAttribute("orders", basketService.findAll());
        return "group/allOrders";
    }

    @RequestMapping(value = "/cabinet/order/{id}", method = RequestMethod.GET)
    public String order(@PathVariable String id, Principal principal, Model model)
    {
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        Basket basket = null;
        try
        {
            int i = Integer.parseInt(id);
            if (i <= 0)
                throw new Exception();
            basket = basketService.findOne(i);
            if (basket == null)
                throw new Exception();
            if (!basket.isOrdered())
                throw new Exception();
            if (!basket.getUser().equals(user))
                throw new Exception();
        }
        catch(Exception e)
        {
            return "redirect:/group/all";
        }

        List<Product> productList = basket.getProductList();
        double sum = 0.0;
        for (Product product : productList)
        {
            if (product == null)
                continue;
            sum += product.getPrice();
        }

        model.addAttribute("products", productList);
        model.addAttribute("sum", sum);
        return "group/order";
    }

    @RequestMapping(value = "/admin/buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable String id, Model model)
    {
        Basket basket = basketService.findOne(Integer.parseInt(id));

        List<Product> productList = basket.getProductList();
        double sum = 0.0;
        for (Product product : productList)
        {
            if (product == null)
                continue;
            sum += product.getPrice();
        }

        model.addAttribute("products", productList);
        model.addAttribute("sum", sum);
        model.addAttribute("user", basket.getUser());
        model.addAttribute("id", id);
        return "group/buy";
    }
}
