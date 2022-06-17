package kz.metateam.hackday.repository.test;

import kz.metateam.hackday.models.test.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByName(String name);
}
