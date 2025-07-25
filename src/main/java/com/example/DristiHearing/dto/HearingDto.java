package com.example.DristiHearing.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HearingDto {
    private String Id;
    private String filingNumber;
    private String cnrNumber;
    private Long hearingDate;
    private String judgeId;
    private String caseType;
    private String courtRoom;
    private String status;
    private String createdBy;
    private String modifiedBy;
    private Long createdAt;
    private Long modifiedAt;
}
