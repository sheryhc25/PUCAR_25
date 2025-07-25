package com.example.DristiHearing.service;

import com.example.DristiHearing.entity.Hearing;
import com.example.DristiHearing.repository.HearingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HearingService {

    @Autowired
    private HearingRepository hearingRepository;

    public List<Hearing> getAllHearings(){
        return (List<Hearing>) hearingRepository.findAll();
    }

    public Optional<Hearing> getHearingById(String id){
        return hearingRepository.findById(id);
    }

    public Hearing createHearing(Hearing hearing){
        return hearingRepository.save(hearing);
    }


    public Hearing updateHearing(String id, Hearing hearing){
        hearing.setId(id);
        return hearingRepository.save(hearing);
    }


    public boolean deleteHearing(String id){
        if(hearingRepository.existsById(id)){
            hearingRepository.deleteById(id);
            return  true;
        }
        return false;
    }

}
