package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.repository.SavedQuoteRepository;
import com.silentgarden.silentgarden.model.SavedQuote;
import com.silentgarden.silentgarden.dto.SavedQuoteDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/saved-quotes")
@CrossOrigin(origins = "*")
public class SavedQuoteController {

    @Autowired
    private SavedQuoteRepository savedQuoteRepository;

    @PostMapping("saving-quote")
    public ResponseEntity<?> savedQuote(@RequestBody @Valid SavedQuote quote) {

        if (quote == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "quote cannot be null"));
        }

        savedQuoteRepository.save(quote);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quote);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getSavedQuoteByUser(@PathVariable("user_id") @Valid Integer userId) {
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "userId cannot be null"));
        }

        List<SavedQuoteDTO> allSavedQuote = savedQuoteRepository.findByUserId(userId)
                .stream()
                .map(saved -> new SavedQuoteDTO(
                        saved.getQuote().getQuote_text(),
                        saved.getQuote().getUser().getUsername(),
                        saved.getQuote().getCreated_at(),
                        saved.getSaved_at()
                ))
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allSavedQuote);
    }
}
