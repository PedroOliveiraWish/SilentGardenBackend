package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.model.Quote;
import com.silentgarden.silentgarden.repository.QuoteRepository;
import com.silentgarden.silentgarden.dto.QuoteDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quotes")
@CrossOrigin(origins = "*")
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    @PostMapping("/save-quote")
    public ResponseEntity<?> createQuote(@RequestBody @Valid Quote quote) {
        if (quote == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "quote cannot be null"));
        }

        quoteRepository.save(quote);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quote);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllQuotes() {
        List<Quote> allQuotes = quoteRepository.findAll();

        List<QuoteDTO> allQuotesDTO = allQuotes
                .stream()
                .map(quote -> new QuoteDTO(
                        quote.getId(),
                        quote.getQuote_text(),
                        quote.getUser().getUsername(),
                        quote.getCreated_at()
                ))
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allQuotesDTO);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getQuoteByUserId(@PathVariable("user_id") @Valid Integer userId) {

        System.out.println(userId + " User id");

        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "userId is necessary"));
        }

        List<QuoteDTO> listQuote = quoteRepository.findByUserId(userId)
                .stream()
                .map(quote -> new QuoteDTO(
                        quote.getId(),
                        quote.getQuote_text(),
                        quote.getUser().getUsername(),
                        quote.getCreated_at()
                ))
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listQuote);
    }
}
