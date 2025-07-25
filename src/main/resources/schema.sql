CREATE TABLE hearings (
  id VARCHAR(100) PRIMARY KEY,
  filing_number VARCHAR(100),
  cnr_number VARCHAR(100),
  hearing_date BIGINT,
  judge_id VARCHAR(100),
  case_type VARCHAR(100),
  court_room VARCHAR(100),
  status VARCHAR(100),
  created_by VARCHAR(100),
  modified_by VARCHAR(100),
  created_at BIGINT,
  modified_at BIGINT
);
