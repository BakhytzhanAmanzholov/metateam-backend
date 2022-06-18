package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.faq.FaqQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqQuestionRepository extends JpaRepository<FaqQuestion, Long> {
}
