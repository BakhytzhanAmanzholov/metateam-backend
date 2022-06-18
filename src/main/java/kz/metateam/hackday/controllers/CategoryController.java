package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.CategoryDto;
import kz.metateam.hackday.dto.LessonDto;
import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.news.Tag;
import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.service.CategoryService;
import kz.metateam.hackday.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(category);
    }

    @GetMapping("/eventlist/{id}")
    public ResponseEntity<?> findAllEventsByCategory(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventService.findAllByCategorySetIn(categorySet));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryDto categoryDto){
        if(categoryService.findByName(categoryDto.getName())!=null){
            return new ResponseEntity<>("Данная категория уже создана", HttpStatus.BAD_REQUEST);
        }
        Category category = new Category(categoryDto.getName());
        categoryService.save(category);
        return new ResponseEntity<>("Категория успешно создана", HttpStatus.OK);
    }
}
