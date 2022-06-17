package kz.metateam.hackday.repository.test;

import kz.metateam.hackday.models.test.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
