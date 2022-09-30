package com.example.demo.quote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class QuoteConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuoteRepository repository) {
        return args -> {
            Quote newQuote = new Quote("No one", "Everything's happens for a reason", LocalDate.of(2022, Month.NOVEMBER, 21));
            repository.save(newQuote);
        };
    }

}
