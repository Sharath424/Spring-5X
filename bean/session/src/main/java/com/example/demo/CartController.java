package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private Cart cart;

    @GetMapping("/add-to-cart")
    @ResponseBody
    public String addToCart(@RequestParam String item) {
        cart.addItem(item);
        return "Added item to cart: " + item;
    }

    @GetMapping("/view-carts")
    @ResponseBody
    public String viewCart(HttpSession httpSession) {
        List<String> items = cart.getItems();
        return "Cart items: " + items;
    }
}
