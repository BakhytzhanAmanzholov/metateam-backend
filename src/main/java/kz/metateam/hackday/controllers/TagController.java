package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.CategoryDto;
import kz.metateam.hackday.dto.TagDto;
import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TagDto tagDto){
        if(tagService.findByName(tagDto.getName())!=null){
            return new ResponseEntity<>("Данная категория уже создана", HttpStatus.BAD_REQUEST);
        }
        Tag tag = new Tag(tagDto.getName());
        tagService.save(tag);
        return new ResponseEntity<>("Категория успешно создана", HttpStatus.OK);
    }
}
