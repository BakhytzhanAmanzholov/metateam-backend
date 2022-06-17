package kz.metateam.hackday.service.implementation.test;

import kz.metateam.hackday.models.test.Answer;
import kz.metateam.hackday.repository.test.AnswerRepository;
import kz.metateam.hackday.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;


    @Override
    public Answer save(Answer entity) {
        log.info("Save answer {}", entity.getName());
        return answerRepository.save(entity);
    }

    @Override
    public Answer update(Answer entity) {
        Answer answer = answerRepository.findByName(entity.getName());
        answer.setType(entity.getType());
        return answer;
    }

    @Override
    public void delete(Answer entity) {
        answerRepository.delete(entity);
    }

    @Override
    public Answer findById(Long aLong) {
        return answerRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }
}
