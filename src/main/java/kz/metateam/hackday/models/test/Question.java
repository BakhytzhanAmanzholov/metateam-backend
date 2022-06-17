package kz.metateam.hackday.models.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private Answer answerA;
    @OneToOne
    private Answer answerB;

    public Question(Answer answerA, Answer answerB) {
        this.answerA = answerA;
        this.answerB = answerB;
    }
}
