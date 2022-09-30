package com.example.demo.quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Query("SELECT q FROM Quote q WHERE q.quote = ?1")
    Optional<Quote> findQuote(String quote);

    @Query("SELECT q FROM Quote q WHERE q.id = ?1")
    Quote getRandomQuote(Long id);
}
