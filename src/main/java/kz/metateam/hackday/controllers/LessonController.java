package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lessonService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAllSpecializationByLesson(@PathVariable("id") Long id){
        Lesson lesson = lessonService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lesson);
    }
    @GetMapping("/{id1}/{id2}")
    public ResponseEntity<?> findAllSpecializationByLessons(@PathVariable("id1") Long id1, @PathVariable("id2") Long id2){
        Lesson lesson1 = lessonService.findById(id1);
        Lesson lesson2 = lessonService.findById(id2);
        Set<Specialization> specializations = lesson1.getSpecializationSet();
        specializations.retainAll(lesson2.getSpecializationSet());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(specializations);
    }
}
