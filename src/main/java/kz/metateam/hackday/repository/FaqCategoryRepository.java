package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Set;

public interface FaqCategoryRepository extends JpaRepository<FaqCategory, Long> {
    FaqCategory findByQuestionSetIn(Collection<Set<FaqQuestion>> questionSet);
    FaqCategory findByName(String name);
}
