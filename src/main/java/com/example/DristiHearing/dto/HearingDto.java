package com.example.DristiHearing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HearingDto {
    private String filingNumber;
    private String cnrNumber;
    private LocalDate hearingDate;
    private String judgeId;
    private String caseType;
    private String courtRoom;
    private String status;
    private String createdBy;
    private String modifiedBy;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
