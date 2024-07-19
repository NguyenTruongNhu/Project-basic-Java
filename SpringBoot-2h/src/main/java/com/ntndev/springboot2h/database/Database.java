package com.ntndev.springboot2h.database;

import com.ntndev.springboot2h.models.Product;
import com.ntndev.springboot2h.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
@Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
    return new CommandLineRunner() {
        @Override
        public void run(String... args) throws Exception {
            Product productA = new Product("Macbook",2002,2230.4,"");
            Product productB = new Product("Air",2005,2250.4,"");
//            System.out.println("Insert : " + productRepository.save(productA));
//            System.out.println("Insert : " + productRepository.save(productB));
        }
    };
}

}
