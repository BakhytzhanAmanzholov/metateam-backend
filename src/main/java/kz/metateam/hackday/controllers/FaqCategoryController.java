package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.FaqCategoryDto;
import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;
import kz.metateam.hackday.service.FaqCategoryService;
import kz.metateam.hackday.service.FaqQuestionService;
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
@RequestMapping("/faqcategory")
public class FaqCategoryController {
    private final FaqCategoryService faqCategoryService;
    private final FaqQuestionService faqQuestionService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(faqCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        FaqCategory faqCategory = faqCategoryService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(faqCategory);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FaqCategoryDto faqCategoryDto){
        if(faqCategoryService.findByName(faqCategoryDto.getName())!=null){
            return new ResponseEntity<>("Данная категория уже создана", HttpStatus.BAD_REQUEST);
        }
        FaqCategory faqCategory = new FaqCategory(faqCategoryDto.getName());
        faqCategoryService.save(faqCategory);
        return new ResponseEntity<>("Категория успешно создана", HttpStatus.OK);
    }
}
