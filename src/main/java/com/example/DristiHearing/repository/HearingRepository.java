package com.example.DristiHearing.repository;

import com.example.DristiHearing.entity.Hearing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class HearingRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Hearing> rowMapper = (ResultSet rs, int rowNum) -> {
        Hearing hearing = new Hearing();
        hearing.setFilingNumber(rs.getString("filing_number"));
        hearing.setCnrNumber(rs.getString("cnr_number"));
        hearing.setHearingDate(rs.getDate("hearing_date").toLocalDate());
        hearing.setJudgeId(rs.getString("judge_id"));
        hearing.setCaseType(rs.getString("case_type"));
        hearing.setCourtRoom(rs.getString("court_room"));
        hearing.setStatus(rs.getString("status"));
        hearing.setCreatedBy(rs.getString("created_by"));
        hearing.setModifiedBy(rs.getString("modified_by"));
        hearing.setCreatedAt(rs.getDate("created_at").toLocalDate());
        hearing.setModifiedAt(rs.getDate("modified_at").toLocalDate());
        return hearing;
    };

    public List<Hearing> findAll() {
        return jdbcTemplate.query("SELECT * FROM hearings", rowMapper);
    }

    public Optional<Hearing> findById(String filingNumber) {
        List<Hearing> result = jdbcTemplate.query("SELECT * FROM hearings WHERE filing_number = ?", rowMapper, filingNumber);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    public int insert(Hearing h) {
        return jdbcTemplate.update(
                "INSERT INTO hearings (filing_number, cnr_number, hearing_date, judge_id, case_type, court_room, status, created_by, modified_by, created_at, modified_at) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                h.getFilingNumber(), h.getCnrNumber(), h.getHearingDate(),
                h.getJudgeId(), h.getCaseType(), h.getCourtRoom(), h.getStatus(),
                h.getCreatedBy(), h.getModifiedBy(), h.getCreatedAt(), h.getModifiedAt()
        );
    }

    public int update(String filingNumber, Hearing h) {
        return jdbcTemplate.update(
                "UPDATE hearings SET cnr_number=?, hearing_date=?, judge_id=?, case_type=?, court_room=?, status=?, created_by=?, modified_by=?, created_at=?, modified_at=? " +
                        "WHERE filing_number = ?",
                h.getCnrNumber(), h.getHearingDate(),
                h.getJudgeId(), h.getCaseType(), h.getCourtRoom(), h.getStatus(),
                h.getCreatedBy(), h.getModifiedBy(), h.getCreatedAt(), h.getModifiedAt(),
                filingNumber
        );
    }

    public boolean delete(String filingNumber) {
        return jdbcTemplate.update("DELETE FROM hearings WHERE filing_number = ?", filingNumber) > 0;
    }

    public boolean existsById(String filingNumber) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hearings WHERE filing_number = ?", Integer.class, filingNumber);
        return count != null && count > 0;
    }
}
