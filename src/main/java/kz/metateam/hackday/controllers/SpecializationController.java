package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.models.specialties.University;
import kz.metateam.hackday.service.SpecializationService;
import kz.metateam.hackday.service.UniversityService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/specializations")
public class SpecializationController {
    private final SpecializationService specializationService;
    private final UniversityService universityService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(specializationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FullInfoAboutSpecialization> findById(@PathVariable("id") Long id){
        Specialization specialization = specializationService.findById(id);
        Set<Specialization> specializations = new HashSet<>();
        specializations.add(specialization);
        List<University> universities = universityService.findAllBySpecializations((specializations));
        return ResponseEntity.ok(new FullInfoAboutSpecialization(specialization,
                universities, (long) universities.size()));
    }

}

@Data
class FullInfoAboutSpecialization {
    private Specialization specialization;
    private Long numberOfUniversities;
    private List<University> universities;

    public FullInfoAboutSpecialization(Specialization specialization, List<University> universitySet, Long numberOfUniversities) {
        this.specialization = specialization;
        this.universities = universitySet;
        this.numberOfUniversities = numberOfUniversities;
    }
}
