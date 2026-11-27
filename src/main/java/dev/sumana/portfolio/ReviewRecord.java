package dev.sumana.portfolio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReviewRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20000)
    private String sourceCode;
    private String feedback;

    protected ReviewRecord() {
    }

    public ReviewRecord(String input) {
        this.sourceCode = input;
        this.feedback = input.contains("System.out.println") ? "Consider using structured logging instead of System.out.println." : "No simple logging anti-pattern detected. Manual review still required.";
    }

    public Long getId() { return id; }
    public String getSourceCode() { return sourceCode; }
    public String getFeedback() { return feedback; }
}
