package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.specialties.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Lesson findByName(String name);
}
