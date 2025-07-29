package com.example.DristiHearing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "hearings")

public class Hearing {

  @Id
  @Column("filing_number")
  private String filingNumber;

  @Column( "cnr_number")
  private String cnrNumber;

  @Column( "hearing_date")
  private  LocalDate hearingDate;

  @Column( "judge_id")
  private String judgeId;

  @Column("case_type")
  private String caseType;

  @Column("court_room")
  private String courtRoom;

  @Column( "status")
  private String status;

  @Column("created_by")
  private String createdBy;

  @Column( "modified_by")
  private String modifiedBy;

  @Column( "created_at")
  private  LocalDate createdAt;

  @Column("modified_at")
  private  LocalDate modifiedAt;

}
