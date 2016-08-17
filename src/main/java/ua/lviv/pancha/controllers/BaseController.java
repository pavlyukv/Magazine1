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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home()
    {
        return "base/home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin()
    {
        return "admin/admin";
    }
}
