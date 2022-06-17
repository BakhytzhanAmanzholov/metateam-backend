package kz.metateam.hackday.service.implementation.test;

import kz.metateam.hackday.models.test.Question;
import kz.metateam.hackday.repository.test.QuestionRepository;
import kz.metateam.hackday.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Question save(Question entity) {
        log.info("Save question, answer A: {}, answer B: {}", entity.getAnswerA().getName(), entity.getAnswerB().getName());
        return questionRepository.save(entity);
    }

    @Override
    public Question update(Question entity) {
        return null; // TODO: исправить
    }

    @Override
    public void delete(Question entity) {
        questionRepository.delete(entity);
    }

    @Override
    public Question findById(Long aLong) {
        return questionRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }
}
