package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.service.EventService;
import kz.metateam.hackday.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Event event = eventService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(event);
    }
}