package com.example.DristiHearing.controller;

import com.example.DristiHearing.entity.Hearing;
import com.example.DristiHearing.service.HearingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hearings")
@CrossOrigin(origins = "*")
public class HearingController {

    @Autowired
    private HearingService hearingService;

    @GetMapping
    public ResponseEntity<List<Hearing>> getAllHearings() {
        List<Hearing> hearings = hearingService.getAllHearings();
        return ResponseEntity.ok(hearings);
    }

    // Get a hearing by filingNumber (ID)
    @GetMapping("/{filingNumber}")
    public ResponseEntity<Hearing> getHearingById(@PathVariable("filingNumber") String filingNumber) {
        Optional<Hearing> hearing = hearingService.getHearingById(filingNumber);
        return hearing.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new hearing
    @PostMapping
    public ResponseEntity<Hearing> createHearing(@RequestBody Hearing hearing) {
        Hearing saved = hearingService.createHearing(hearing);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Update hearing by filingNumber
    @PutMapping("/{filingNumber}")
    public ResponseEntity<Hearing> updateHearing(@PathVariable("filingNumber") String filingNumber,
                                                 @RequestBody Hearing updatedHearing) {
        Optional<Hearing> existing = hearingService.getHearingById(filingNumber);
        if (existing.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Set the same ID to ensure update
        updatedHearing.setFilingNumber(filingNumber);
        Hearing updated = hearingService.updateHearing(filingNumber, updatedHearing);
        return ResponseEntity.ok(updated);
    }

    // Delete hearing by filingNumber
    @DeleteMapping("/{filingNumber}")
    public ResponseEntity<String> deleteHearing(@PathVariable("filingNumber") String filingNumber) {
        boolean deleted = hearingService.deleteHearing(filingNumber);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Hearing with filing number " + filingNumber + " not found");
        }
        return ResponseEntity.ok("Hearing with filing number " + filingNumber + " deleted successfully");
    }
}
