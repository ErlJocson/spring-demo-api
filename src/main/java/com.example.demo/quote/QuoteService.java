package com.example.demo.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    public void addNewQuote(Quote quote) {
        Optional<Quote> searchQuote = quoteRepository.findQuote(quote.getQuote());
        if (searchQuote.isPresent()) {
            throw new IllegalStateException("Quote already exist!");
        } else {
            quoteRepository.save(quote);
        }
    }

    public Quote getRandomQuote() {
        Random randomNumber = new Random();
        int upperBound = (int) quoteRepository.count();
        long randomInt = (long) randomNumber.nextInt(upperBound);
        return quoteRepository.getRandomQuote(randomInt+1);
    }
}
