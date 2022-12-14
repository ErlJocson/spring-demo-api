package com.example.demo.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/quote/")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(path = "/all") @CrossOrigin
    public List<Quote> getQuotes(){
        return quoteService.getQuotes();
    }

    @GetMapping(path = "/1") @CrossOrigin
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @PostMapping @CrossOrigin
    public void addQuote(@RequestBody Quote quote){
        quoteService.addNewQuote(quote);
    }
}
