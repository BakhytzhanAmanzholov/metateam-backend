package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.Role;
import kz.metateam.hackday.models.test.Answer;
import kz.metateam.hackday.models.test.Question;
import kz.metateam.hackday.service.AccountService;
import kz.metateam.hackday.service.AnswerService;
import kz.metateam.hackday.service.QuestionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final AccountService accountService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    private List<Long> longs = new ArrayList<>();

    @GetMapping("/test")
    public ResponseEntity<?> startTest(){
        Question question = questionService.findAll().stream().findFirst().orElseThrow(IllegalArgumentException::new);
        test(question.getId());
        return new ResponseEntity<>("The test has been completed successfully.", HttpStatus.OK);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<QuestionData> test(@PathVariable("id") Long id) {
        Question question = questionService.findById(id);
        Answer answerA = question.getAnswerA();
        Answer answerB = question.getAnswerB();
        return ResponseEntity.ok(new QuestionData(answerA, answerB));
    }
    @PostMapping("/test/{qid}/{aid}")
    public ResponseEntity<?> answer(@PathVariable("qid") Long qid, @PathVariable("aid") Long aid) {
        Question question = questionService.findById(qid);
        Answer answer = answerService.findById(aid);
        longs = accountService.test(question, answer, longs);
        if(longs.get(0)!=-1){
            test(longs.get(0));
        }
        return new ResponseEntity<>("The test has been completed successfully.", HttpStatus.OK);
    }

}

@Data
class QuestionData{
   private Answer answerA;
   private Answer answerB;

    public QuestionData(Answer answerA, Answer answerB) {
        this.answerA = answerA;
        this.answerB = answerB;
    }
}
