package kz.metateam.hackday.dto;

import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.models.faq.FaqCategory;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Data
public class FaqQuestionDto {
    private String question;
    private String answer;
    private String categoryName;
}
