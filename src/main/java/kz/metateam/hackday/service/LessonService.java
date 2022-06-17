package kz.metateam.hackday.service;

import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.models.specialties.Specialization;

public interface LessonService extends CrudService<Lesson, Long> {
    void addSpecializationToLesson(Specialization specialization, Lesson lesson);
}
