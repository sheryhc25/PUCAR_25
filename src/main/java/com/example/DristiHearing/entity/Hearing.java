package com.example.DristiHearing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "hearings")

public class Hearing {
  @Id
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
