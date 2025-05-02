package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.repository.SavedQuoteRepository;
import com.silentgarden.silentgarden.model.SavedQuote;
import com.silentgarden.silentgarden.dto.SavedQuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/saved-quotes")
@CrossOrigin(origins = "*")
public class SavedQuoteController {

    @Autowired
    private SavedQuoteRepository savedQuoteRepository;

    @PostMapping("saving-quote")
    public SavedQuote savedQuote(@RequestBody SavedQuote quote) {

        return savedQuoteRepository.save(quote);
    }

    @GetMapping("/{id}")
    public List<SavedQuoteDTO> getSavedQuoteByUser(@PathVariable Integer id) {
        return savedQuoteRepository.findByUserId(id)
                .stream()
                .map(saved -> new SavedQuoteDTO(
                        saved.getQuote().getQuote_text(),
                        saved.getQuote().getUser().getUsername(),
                        saved.getQuote().getCreated_at(),
                        saved.getSaved_at()
                ))
                .collect(Collectors.toList());
    }
}
