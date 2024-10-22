package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.repositories.ProductRepository;
import com.wad.firstmvc.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner{
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DataInitializer(UserRepository userRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {}
}
