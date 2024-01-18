package com.example.demo.controller;
import com.example.demo.global.GlobalData;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.razorpay.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CartController {
    @Autowired
    public ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }
    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }
    @PostMapping("/createOrder")
    public String createOrder(@RequestBody Map<String , Object> data) throws Exception{
        System.out.println(data);
        int amount = Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient= new RazorpayClient("rzp_test_giVjo9rILkpMB","yZ0MJMS6P1eJmjdZ81d7GHOV");
        JSONObject options = new JSONObject();
        options.put("amount", amount*100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order = razorpayClient.orders.create(options);
        System.out.println("hey order function done.");
        return "done";
    }
}
