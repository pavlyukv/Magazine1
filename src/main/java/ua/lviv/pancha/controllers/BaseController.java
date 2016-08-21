package ua.lviv.pancha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Controller
public class BaseController
{
    // Home page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home()
    {
        return "base/home";
    }

    // About page
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about()
    {
        return "base/about";
    }

    // Contacts page
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts()
    {
        return "base/contacts";
    }
}
