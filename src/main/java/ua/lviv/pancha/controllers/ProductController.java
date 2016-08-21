package ua.lviv.pancha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.entity.Product;
import ua.lviv.pancha.services.GroupService;
import ua.lviv.pancha.services.ProductService;

/**
 * Created by Vasyl.Pavlyuk on 21.08.2016.
 */
@Controller
public class ProductController
{
    @Autowired
    private ProductService productService;

    @Autowired
    private GroupService groupService;

    // Show product
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public String showProduct()
    {
        return "redirect:/group/all";
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String showProduct(@PathVariable String id, Model model)
    {
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
        product.loadImage();
        model.addAttribute("product", product);
        return "group/product";
    }

    // Add Product
    @RequestMapping(value = "/admin/addProduct/", method = RequestMethod.GET)
    public String addProduct()
    {
        return "redirect:/admin/addProduct/0";
    }
    @RequestMapping(value = "/admin/addProduct/{id}", method = RequestMethod.GET)
    public String addProduct(@PathVariable String id, Model model)
    {
        model.addAttribute("id", id);
        return "group/addProduct";
    }
    @RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("quantity") Integer quantity, @RequestParam("price") Double price, @RequestParam("image") MultipartFile multipartFile, @RequestParam("id") String id)
    {
        Group group = null;
        int i = Integer.parseInt(id);
        if (i > 0)
            group = groupService.findOne(i);

        productService.add(name, description, quantity, price, multipartFile, group);
        return "redirect:/group/" + id;
    }

    // Delete Product
    @RequestMapping(value = "/admin/deleteProduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable String id)
    {
        productService.delete(Integer.parseInt(id));
        return "redirect:/group/all";
    }

    // Edit Product
    @RequestMapping(value = "/admin/editProduct/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable String id, Model model)
    {
        model.addAttribute("product", productService.findOne(Integer.parseInt(id)));
        return "group/editProduct";
    }
    @RequestMapping(value = "/admin/editProduct", method = RequestMethod.POST)
    public String editProduct(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("quantity") Integer quantity, @RequestParam("price") Double price)
    {
        productService.edit(id, name, description, quantity, price);
        return "redirect:/group/all";
    }
}
