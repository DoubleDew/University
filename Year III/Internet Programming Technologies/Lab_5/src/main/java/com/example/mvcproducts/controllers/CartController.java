package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Cart;
import com.example.mvcproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes({"cart"})
@RequestMapping({"/cart"})
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping({"/add"})
    public String addToCart(@RequestParam Long pid, @ModelAttribute("cart") Cart cart, RedirectAttributes redirectAttributes) {
        this.productService.findById(pid).ifPresentOrElse(product -> {
            cart.addProduct(product);
            redirectAttributes.addFlashAttribute("success", "Product added to cart successfully!");
        }, () -> {
            redirectAttributes.addFlashAttribute("error", "Product not found!");
        });
        return "redirect:/products";
    }

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping
    public String seeCart(Model model, @ModelAttribute("cart") Cart cart) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
