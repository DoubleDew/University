package com.example.mvcproducts.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String home(){
    return "home";
  }

  @GetMapping("/checkAuth")
  public String checkAuthentication(Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      log.info("User is authenticated: {}", authentication.getName());
      return "authenticated";
    } else {
      log.info("User is not authenticated");
      return "notAuthenticated";
    }
  }

}
