package dev.sumana.portfolio.service.impl;

import dev.sumana.portfolio.ReviewRecord;
import dev.sumana.portfolio.ReviewService;
import dev.sumana.portfolio.service.ReviewServiceOperations;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewServiceOperations {

    private final ReviewService delegate;

    public ReviewServiceImpl(ReviewService delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<ReviewRecord> findAll() {
        return delegate.list();
    }

    @Override
    public ReviewRecord findById(Long id) {
        return delegate.get(id);
    }
}
