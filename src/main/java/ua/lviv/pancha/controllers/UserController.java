package ua.lviv.pancha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.pancha.entity.User;
import ua.lviv.pancha.services.UserService;

/**
 * Created by Vasyl.Pavlyuk on 10.08.2016.
 */
@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home()
    {
        return "base/home";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login()
    {
        return "base/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute("user", new User());
        return "base/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute User user, BindingResult bindingResult)
    {
//        userValidator.validate(user, bindingResult);
//        if (bindingResult.hasErrors())
//        {
//            return "views-base-registration";
//        }
//        else
//        {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.addOrEdit(user);
//        }
        return "redirect:/";
    }
}
