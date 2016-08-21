package ua.lviv.pancha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.entity.Product;
import ua.lviv.pancha.services.GroupService;
import ua.lviv.pancha.services.ProductService;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Controller
public class GroupController
{
    @Autowired
    private GroupService groupService;

    @Autowired
    private ProductService productService;

    // Show all groups & products
    @RequestMapping(value = "/group/", method = RequestMethod.GET)
    public String showPage()
    {
        return "redirect:/group/0";
    }
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String showPage(@PathVariable String id, Model model)
    {
        Group group = null;
        try
        {
            int i = Integer.parseInt(id);
            if (i <= 0)
                throw new Exception();
            group = groupService.findOne(i);
        }
        catch(Exception e)
        {
        }
        model.addAttribute("group", group);
        model.addAttribute("groups", groupService.findAllByGroup(group));

        List<Product> productList = productService.findAllByGroup(group);
        for (Product product : productList)
            product.loadImage();
        model.addAttribute("products", productList);
        return "group/all";
    }

    // Add Group
    @RequestMapping(value = "/admin/addGroup/", method = RequestMethod.GET)
    public String addGroup()
    {
        return "redirect:/admin/addGroup/0";
    }
    @RequestMapping(value = "/admin/addGroup/{id}", method = RequestMethod.GET)
    public String addGroup(@PathVariable String id, Model model)
    {
        model.addAttribute("id", id);
        return "group/addGroup";
    }
    @RequestMapping(value = "/admin/addGroup", method = RequestMethod.POST)
    public String addGroup(@RequestParam("name") String name, @RequestParam("id") String id)
    {
        groupService.add(name, id);
        return "redirect:/group/" + id;
    }

    // Delete Group
    @RequestMapping(value = "/admin/deleteGroup/{id}", method = RequestMethod.GET)
    public String deleteGroup(@PathVariable String id)
    {
        groupService.delete(Integer.parseInt(id));
        return "redirect:/group/all";
    }

    // Edit Group
    @RequestMapping(value = "/admin/editGroup/{id}", method = RequestMethod.GET)
    public String editGroup(@PathVariable String id, Model model)
    {
        model.addAttribute("group", groupService.findOne(Integer.parseInt(id)));
        return "group/editGroup";
    }
    @RequestMapping(value = "/admin/editGroup", method = RequestMethod.POST)
    public String editGroup(@RequestParam("id") String id, @RequestParam("name") String name)
    {
        Group group = groupService.findOne(Integer.parseInt(id));
        group.setName(name);
        groupService.addOrEdit(group);
        return "redirect:/group/all";
    }
}
