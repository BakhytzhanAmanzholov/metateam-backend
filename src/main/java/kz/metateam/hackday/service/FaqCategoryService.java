package kz.metateam.hackday.service;

import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;
import kz.metateam.hackday.models.test.Question;

import java.util.Set;

public interface FaqCategoryService extends CrudService<FaqCategory, Long> {
    FaqCategory findCategoryByQuestion(Set<FaqQuestion> faqQuestionSet);
    void addQuestionToCategory(FaqQuestion faqQuestion, FaqCategory faqCategory);
}
