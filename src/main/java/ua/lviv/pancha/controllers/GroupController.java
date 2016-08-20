package ua.lviv.pancha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.services.GroupService;
import ua.lviv.pancha.services.ProductService;

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

    @RequestMapping(value = "/group/all", method = RequestMethod.GET)
    public String allGroups(Model model)
    {
        model.addAttribute("group", null);
        model.addAttribute("groups", groupService.findAllByGroup(null));
        return "group/all";
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String groupPage(@PathVariable String id, Model model)
    {
        Group group = groupService.findOne(Integer.parseInt(id));
        model.addAttribute("group", group);
        model.addAttribute("groups", groupService.findAllByGroup(group));
        return "group/all";
    }

    @RequestMapping(value = "/admin/addGroup", method = RequestMethod.GET)
    public String addGroup()
    {
        return "group/addGroup";
    }

    @RequestMapping(value = "/admin/addGroup", method = RequestMethod.POST)
    public String addGroup(@RequestParam("name") String name)
    {
        groupService.add(name);
        return "redirect:/group/all";
    }

    @RequestMapping(value = "/admin/deleteGroup/{id}", method = RequestMethod.GET)
    public String deleteGroup(@PathVariable String id)
    {
        groupService.delete(Integer.parseInt(id));
        return "redirect:/group/all";
    }

    @RequestMapping(value = "/admin/editGroup/{id}", method = RequestMethod.GET)
    public String editGroup(@PathVariable String id, Model model)
    {
        model.addAttribute("group", groupService.findOne(Integer.parseInt(id)));
        return "group/editGroup";
    }

    @RequestMapping(value = "/admin/editGroup", method = RequestMethod.POST)
    public String editGroup(@ModelAttribute Group group)
    {
        groupService.addOrEdit(group);
        return "redirect:/group/all";
    }
}
