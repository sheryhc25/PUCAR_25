package com.example.DristiHearing.mapper;

import com.example.DristiHearing.dto.HearingDto;
import com.example.DristiHearing.entity.Hearing;

public class HearingMapper {
    public static HearingDto mapToHearingDto(Hearing hearing){
        return new HearingDto(
                hearing.getId(),
                hearing.getFilingNumber(),
                hearing.getCnrNumber(),
                hearing.getHearingDate(),
                hearing.getJudgeId(),
                hearing.getCaseType(),
                hearing.getCourtRoom(),
                hearing.getStatus(),
                hearing.getCreatedBy(),
                hearing.getModifiedBy(),
                hearing.getCreatedAt(),
                hearing.getModifiedAt()
        );
    }
    public static Hearing mapToHearing(HearingDto hearingDto){
        return new Hearing(
                hearingDto.getId(),
                hearingDto.getFilingNumber(),
                hearingDto.getCnrNumber(),
                hearingDto.getHearingDate(),
                hearingDto.getJudgeId(),
                hearingDto.getCaseType(),
                hearingDto.getCourtRoom(),
                hearingDto.getStatus(),
                hearingDto.getCreatedBy(),
                hearingDto.getModifiedBy(),
                hearingDto.getCreatedAt(),
                hearingDto.getModifiedAt()
        );
    }
}
