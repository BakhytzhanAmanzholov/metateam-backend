package kz.metateam.hackday.service.implementation.specialization;

import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.repository.LessonRepository;
import kz.metateam.hackday.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public Lesson save(Lesson entity) {
        return lessonRepository.save(entity);
    }

    @Override
    public Lesson update(Lesson entity) {
        Lesson lesson = lessonRepository.findByName(entity.getName());
        lesson.setDescription(entity.getDescription());
        return lesson;
    }

    @Override
    public void delete(Lesson entity) {
        lessonRepository.delete(entity);
    }

    @Override
    public Lesson findById(Long aLong) {
        return lessonRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public void addSpecializationToLesson(Specialization specialization, Lesson lesson) {
        Lesson lesson1 = findById(lesson.getId());
        lesson1.getSpecializationSet().add(specialization);
    }

    @Override
    public Lesson findByName(String name) {
        return lessonRepository.findByName(name);
    }
}
