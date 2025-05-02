package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.model.Quote;
import com.silentgarden.silentgarden.repository.QuoteRepository;
import com.silentgarden.silentgarden.dto.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quotes")
@CrossOrigin(origins = "*")
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        Quote newQuote = quoteRepository.save(quote);

        System.out.println(("Quote created: " + newQuote.getQuote_text()));

        return newQuote;
    }

    @GetMapping
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public List<QuoteDTO> getQuoteByUserId(@PathVariable Integer id) {
        return quoteRepository.findByUserId(id)
                .stream()
                .map(quote -> new QuoteDTO(
                        quote.getQuote_text(),
                        quote.getUser().getUsername(),
                        quote.getCreated_at()
                ))
                .collect(Collectors.toList());
    }
}
