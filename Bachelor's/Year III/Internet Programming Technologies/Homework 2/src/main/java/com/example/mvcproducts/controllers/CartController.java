package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Cart;
import com.example.mvcproducts.domain.OrderLineItem;
import com.example.mvcproducts.domain.ProductOrder;
import com.example.mvcproducts.repositories.OrderRepository;
import com.example.mvcproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/checkout")
    @Transactional
    public String checkout(@ModelAttribute("cart") Cart cart, Authentication authentication, RedirectAttributes redirectAttributes) {
        if (cart.getProducts().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Your cart is empty!");
            return "redirect:/cart";
        }

        ProductOrder productOrder = new ProductOrder();
        cart.getProducts().forEach((product, quantity) -> {
            OrderLineItem lineItem = new OrderLineItem();
            lineItem.setProduct(product);
            lineItem.setQty(quantity);
            lineItem.setOrder(productOrder);  // Ensure each line item is linked back to the order
            productOrder.getOrderLineItems().add(lineItem);
        });

        orderRepository.save(productOrder);
        cart.clear();

        redirectAttributes.addFlashAttribute("success", "Order placed successfully!");
        return "redirect:/products";
    }


}
