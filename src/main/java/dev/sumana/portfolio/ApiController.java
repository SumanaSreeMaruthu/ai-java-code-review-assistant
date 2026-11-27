package dev.sumana.portfolio;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ApiController {

    public record Request(@NotBlank String sourceCode) {}

    private final ReviewService service;

    public ApiController(ReviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReviewRecord> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ReviewRecord get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewRecord create(@Valid @RequestBody Request request) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
