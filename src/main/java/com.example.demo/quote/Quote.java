package com.example.demo.quote;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity @Table
public class Quote {
    @Id
    @SequenceGenerator(
            name = "quote_sequence",
            sequenceName = "quote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quote_sequence"
    )
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String quote;

    @Temporal(TemporalType.DATE)
    private Date dateUploaded = new Date();

    public Quote() {
    }

    public Quote(String name, String quote, Date dateUploaded) {
        this.name = name;
        this.quote = quote;
        this.dateUploaded = dateUploaded;
    }

    public Quote(
            Long id,
            String name,
            String quote,
            Date dateUploaded) {
        this.id = id;
        this.name = name;
        this.quote = quote;
        this.dateUploaded = dateUploaded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quote='" + quote + '\'' +
                ", dateUploaded=" + dateUploaded +
                '}';
    }
}
