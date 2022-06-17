package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;
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

import java.util.HashSet;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tagService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTag(@PathVariable("id") Long id) {
        Tag tag = tagService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tag);
    }

    @GetMapping("/newslist/{id}")
    public ResponseEntity<?> findAllNewsByTag(@PathVariable("id") Long id) {
        Tag tag = tagService.findById(id);
        Set<Tag> tagSet = new HashSet<>();
        tagSet.add(tag);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newsService.findAllByTags(tagSet));
    }
}
