package kz.metateam.hackday.models.faq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FaqQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String answer;
    private int number = 1;

    public FaqQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
