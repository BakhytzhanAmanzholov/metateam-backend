package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.FaqQuestionDto;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.faq.FaqCategory;
import kz.metateam.hackday.models.faq.FaqQuestion;
import kz.metateam.hackday.service.FaqCategoryService;
import kz.metateam.hackday.service.FaqQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/faqquestion")
public class FaqQuestionController {
    private final FaqCategoryService faqCategoryService;
    private final FaqQuestionService faqQuestionService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody FaqQuestionDto faqQuestionDto){
        FaqCategory faqCategory = faqCategoryService.findByName(faqQuestionDto.getCategoryName());
        faqQuestionService.saveQ(new FaqQuestion(faqQuestionDto.getQuestion(), faqQuestionDto.getAnswer()), faqCategory);
        return new ResponseEntity<>("FAQ успешно создан", HttpStatus.OK);
    }
}
