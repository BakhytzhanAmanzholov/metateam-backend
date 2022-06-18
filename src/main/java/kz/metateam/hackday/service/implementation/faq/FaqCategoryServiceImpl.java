package kz.metateam.hackday.service.implementation.faq;

import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;
import kz.metateam.hackday.repository.FaqCategoryRepository;
import kz.metateam.hackday.service.FaqCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FaqCategoryServiceImpl implements FaqCategoryService {
    private final FaqCategoryRepository faqCategoryRepository;

    @Override
    public FaqCategory save(FaqCategory entity) {
        int size = findAll().size();
        entity.setNumber(size+1);
        return faqCategoryRepository.save(entity);
    }

    @Override
    public FaqCategory update(FaqCategory entity) {
        FaqCategory faqCategory = findById(entity.getId());
        faqCategory.setName(entity.getName());
        return faqCategory;
    }

    @Override
    public void delete(FaqCategory entity) {
        faqCategoryRepository.delete(entity);
    }

    @Override
    public FaqCategory findById(Long aLong) {
        return faqCategoryRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<FaqCategory> findAll() {
        return faqCategoryRepository.findAll();
    }

    @Override
    public FaqCategory findCategoryByQuestion(Set<FaqQuestion> faqQuestionSet) {
        return faqCategoryRepository.findByQuestionSetIn(Collections.singleton(faqQuestionSet));
    }

    @Override
    public void addQuestionToCategory(FaqQuestion faqQuestion, FaqCategory faqCategory) {
        FaqCategory category = findById(faqCategory.getId());
        category.getQuestionSet().add(faqQuestion);
    }

    @Override
    public FaqCategory findByName(String name) {
        return faqCategoryRepository.findByName(name);
    }
}
