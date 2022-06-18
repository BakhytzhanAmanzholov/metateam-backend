package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.EventDto;
import kz.metateam.hackday.dto.NewsDto;
import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;
import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.service.NewsService;
import kz.metateam.hackday.service.TagService;
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
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findLesson(@PathVariable("id") Long id){
        News news = newsService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(news);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody NewsDto newsDto){
        Set<Tag> tags = new HashSet<>();
        for (String tagName: newsDto.getTags()) {
            tags.add(tagService.findByName(tagName));
        }
        News news = new News(newsDto.getTitle(), newsDto.getDescription(), newsDto.isPinned());
        news.setTagSet(tags);
        newsService.save(news);
        return new ResponseEntity<>("Новость успешно сохранена", HttpStatus.OK);
    }
}
