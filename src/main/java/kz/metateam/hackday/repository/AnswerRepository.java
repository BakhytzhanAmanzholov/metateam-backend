package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.test.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByName(String name);
}
