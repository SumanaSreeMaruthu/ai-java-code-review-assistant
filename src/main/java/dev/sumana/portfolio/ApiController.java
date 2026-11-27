package dev.sumana.portfolio;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/reviews")
public class ApiController {

    public record Request(@NotBlank String sourceCode) {
    }

    private final ReviewRecordRepository repository;

    public ApiController(ReviewRecordRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewRecord create(@Valid @RequestBody Request request) {
        return repository.save(new ReviewRecord(request.sourceCode()));
    }

    @GetMapping
    public List<ReviewRecord> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ReviewRecord get(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        repository.deleteById(id);
    }
}
