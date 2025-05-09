package com.silentgarden.silentgarden.controller;

import com.silentgarden.silentgarden.model.Journal;
import com.silentgarden.silentgarden.repository.JournalRepository;
import com.silentgarden.silentgarden.dto.JournalDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journals")
@CrossOrigin(origins = "*")
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @PostMapping("/save-journal")
    public ResponseEntity<?> createJournal(@RequestBody @Valid Journal journal) {
        if (journal == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Journal cannot be null"));
        }

        journalRepository.save(journal);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(journal);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getAllJournalById(@PathVariable("user_id") Integer userId) {
        if (userId == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "User id is necessary"));
        }

        List<JournalDTO> listJournal = journalRepository.findByUserId(userId)
                .stream()
                .map(journal -> new JournalDTO(
                        journal.getTitle(),
                        journal.getContent(),
                        journal.getUser().getUsername(),
                        journal.getCreated_at()
                ))
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listJournal);
    }


}
