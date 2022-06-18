package kz.metateam.hackday.service.implementation.faq;

import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;
import kz.metateam.hackday.repository.FaqQuestionRepository;
import kz.metateam.hackday.service.FaqCategoryService;
import kz.metateam.hackday.service.FaqQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FaqQuestionServiceImpl implements FaqQuestionService {
    private final FaqQuestionRepository faqQuestionRepository;
    private final FaqCategoryService faqCategoryService;

    @Override
    public FaqQuestion saveQ(FaqQuestion faqQuestion, FaqCategory faqCategory) {
        FaqCategory faqCategory1 = faqCategoryService.findById(faqCategory.getId());
        faqQuestion.setNumber(faqCategory1.getQuestionSet().size() + 1);
        faqCategoryService.addQuestionToCategory(faqQuestion, faqCategory);
        return faqQuestionRepository.save(faqQuestion);
    }

    @Override
    public FaqQuestion save(FaqQuestion entity) {
        Set<FaqQuestion> faqQuestionSet = new HashSet<>();
        faqQuestionSet.add(entity);
        FaqCategory faqCategory = faqCategoryService.findCategoryByQuestion((Set<FaqQuestion>) entity);
        entity.setNumber(faqCategory.getQuestionSet().size()+1);
        return faqQuestionRepository.save(entity);
    }

    @Override
    public FaqQuestion update(FaqQuestion entity) {
        FaqQuestion faqQuestion = findById(entity.getId());
        faqQuestion.setAnswer(faqQuestion.getAnswer());
        faqQuestion.setQuestion(faqQuestion.getQuestion());
        return faqQuestion;
    }

    @Override
    public void delete(FaqQuestion entity) {
        faqQuestionRepository.delete(entity);
    }

    @Override
    public FaqQuestion findById(Long aLong) {
        return faqQuestionRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<FaqQuestion> findAll() {
        return faqQuestionRepository.findAll();
    }
}
