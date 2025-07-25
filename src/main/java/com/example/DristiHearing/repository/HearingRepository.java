package com.example.DristiHearing.repository;

import com.example.DristiHearing.entity.Hearing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HearingRepository extends CrudRepository<Hearing, String> {
}
