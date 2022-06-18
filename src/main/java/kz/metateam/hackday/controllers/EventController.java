package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.CategoryDto;
import kz.metateam.hackday.dto.EventDto;
import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.service.CategoryService;
import kz.metateam.hackday.service.EventService;
import kz.metateam.hackday.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Event event = eventService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(event);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EventDto eventDto){
        Set<Category> categories = new HashSet<>();
        for (String categoryName: eventDto.getCategoriesName()) {
            categories.add(categoryService.findByName(categoryName));
        }
        Event event = new Event(eventDto.getName(), eventDto.getCity());
        event.setCategorySet(categories);
        eventService.save(event);
        return new ResponseEntity<>("Мероприятие успешно создано", HttpStatus.OK);
    }
}
