package kz.metateam.hackday.service;

import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;

public interface FaqQuestionService extends CrudService<FaqQuestion, Long> {
    FaqQuestion saveQ(FaqQuestion faqQuestion, FaqCategory faqCategory);
}
