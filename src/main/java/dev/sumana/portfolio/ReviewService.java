package dev.sumana.portfolio;

import java.util.List;
import dev.sumana.portfolio.audit.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRecordRepository repository;
    private final ActivityService activity;
    

    public ReviewService(ReviewRecordRepository repository, ActivityService activity) {
        this.repository = repository;
        this.activity = activity;
        
    }

    public List<ReviewRecord> list() {
        return repository.findAll();
    }

    public ReviewRecord get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found"));
    }

    @Transactional
    public ReviewRecord create(ApiController.Request request) {
        ReviewRecord saved = repository.save(new ReviewRecord(request.sourceCode()));
        activity.record("CREATED", "ReviewRecord", saved.getId());
        return saved;
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found");
        }
        repository.deleteById(id);
        activity.record("DELETED", "ReviewRecord", id);
    }

    public List<ReviewRecord> search(String value) {
        if (value == null || value.isBlank()) {
            return repository.findAll();
        }
        return repository.findBySourceCodeContainingIgnoreCase(value.trim());
    }
}
