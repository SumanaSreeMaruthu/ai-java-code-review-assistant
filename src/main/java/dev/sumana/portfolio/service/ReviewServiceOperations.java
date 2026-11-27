package dev.sumana.portfolio.service;

import dev.sumana.portfolio.ReviewRecord;
import java.util.List;

public interface ReviewServiceOperations {
    List<ReviewRecord> findAll();
    ReviewRecord findById(Long id);
}
