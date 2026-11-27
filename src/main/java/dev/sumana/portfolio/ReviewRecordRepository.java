package dev.sumana.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRecordRepository extends JpaRepository<ReviewRecord, Long> {
    java.util.List<ReviewRecord> findBySourceCodeContainingIgnoreCase(String value);
}
