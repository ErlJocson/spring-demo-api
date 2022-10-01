package com.example.demo.quote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class QuoteConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuoteRepository repository) {
        return args -> {
            Quote newQuote = new Quote("No one", "Everything's happens for a reason", new Date(System.currentTimeMillis()));
            repository.save(newQuote);
        };
    }
}
