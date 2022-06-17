package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.service.NewsService;
import kz.metateam.hackday.service.TagService;
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
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findLesson(@PathVariable("id") Long id){
        News news = newsService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(news);
    }


}
