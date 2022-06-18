package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.UniversityDto;
import kz.metateam.hackday.models.specialties.Lesson;
import kz.metateam.hackday.models.specialties.University;
import kz.metateam.hackday.service.UniversityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(universityService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findUniversity(@PathVariable("id") Long id){
        University university = universityService.findById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(university);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UniversityDto universityDto){
        if(universityService.findByName(universityDto.getName())!=null){
            return new ResponseEntity<>("Данный университет уже создан!", HttpStatus.BAD_REQUEST);
        }
        University university = new University(universityDto.getName(), universityDto.getCity(), universityDto.getRegion());
        universityService.save(university);
        return new ResponseEntity<>("Университет успешно создан", HttpStatus.OK);
    }
}
