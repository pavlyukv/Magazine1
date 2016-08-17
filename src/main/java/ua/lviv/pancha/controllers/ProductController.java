package ua.lviv.pancha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.pancha.services.ProductService;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Controller
public class ProductController
{
    @Autowired
    private ProductService productService;

    // TODO
}
