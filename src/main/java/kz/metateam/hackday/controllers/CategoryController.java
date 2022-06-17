package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.news.Tag;
import kz.metateam.hackday.service.CategoryService;
import kz.metateam.hackday.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> findAllNewsByTag(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eventService.findAllByCategorySetIn(categorySet));
    }
}
