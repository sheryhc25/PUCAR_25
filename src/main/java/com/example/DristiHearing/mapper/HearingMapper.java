package com.example.DristiHearing.mapper;

import com.example.DristiHearing.dto.HearingDto;
import com.example.DristiHearing.entity.Hearing;

public class HearingMapper {

    public static HearingDto mapToHearingDto(Hearing hearing) {
        return new HearingDto(
                hearing.getFilingNumber(),
                hearing.getCnrNumber(),
                hearing.getHearingDate(),   // no conversion needed
                hearing.getJudgeId(),
                hearing.getCaseType(),
                hearing.getCourtRoom(),
                hearing.getStatus(),
                hearing.getCreatedBy(),
                hearing.getModifiedBy(),
                hearing.getCreatedAt(),     // no conversion needed
                hearing.getModifiedAt()
        );
    }

    public static Hearing mapToHearing(HearingDto dto) {
        return new Hearing(
                dto.getFilingNumber(),
                dto.getCnrNumber(),
                dto.getHearingDate(),       // no conversion needed
                dto.getJudgeId(),
                dto.getCaseType(),
                dto.getCourtRoom(),
                dto.getStatus(),
                dto.getCreatedBy(),
                dto.getModifiedBy(),
                dto.getCreatedAt(),         // no conversion needed
                dto.getModifiedAt()
        );
    }
}
