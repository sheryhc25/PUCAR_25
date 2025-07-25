package com.example.DristiHearing.controller;


import com.example.DristiHearing.entity.Hearing;
import com.example.DristiHearing.repository.HearingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/hearings")
public class HearingController {
    @Autowired
    private HearingRepository hearingRepository;

    @GetMapping
    public Iterable<Hearing> getAllHearings(){
        return hearingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hearing> getHearingById(@PathVariable String id){
        Optional<Hearing> hearing = hearingRepository.findById(id);
        return hearing.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Hearing> createHearing(@RequestBody Hearing hearing){
        Hearing saved = hearingRepository.save(hearing);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping
    public ResponseEntity<Hearing>  updateHearing(@PathVariable String id, @RequestBody Hearing updateHearing){
        if(!hearingRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        updateHearing.setId(id);
        Hearing saved = hearingRepository.save(updateHearing);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHearing(@PathVariable String id){
        if(!hearingRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hearing with ID" + id + "not found");
        }
        hearingRepository.deleteById(id);
        return ResponseEntity.ok("Hearing with ID" + id + "deleted successfully");
    }
}
