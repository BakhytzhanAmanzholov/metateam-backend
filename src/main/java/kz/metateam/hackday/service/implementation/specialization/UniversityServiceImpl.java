package kz.metateam.hackday.service.implementation.specialization;

import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.models.specialties.University;
import kz.metateam.hackday.repository.UniversityRepository;
import kz.metateam.hackday.service.UniversityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    @Override
    public University save(University entity) {
        return universityRepository.save(entity);
    }

    @Override
    public University update(University entity) {
        University university = universityRepository.findByName(entity.getName());
        university.setRegion(entity.getRegion());
        university.setCity(entity.getCity());
        return university;
    }

    @Override
    public void delete(University entity) {
        universityRepository.delete(entity);
    }

    @Override
    public University findById(Long aLong) {
        return universityRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public void addSpecializationToUniversity(Specialization specialization, University university) {
        University university1 = findById(university.getId());
        university1.getSpecializations().add(specialization);
    }

    @Override
    public List<University> findAllBySpecializations(Set<Specialization> specializationList) {
        return universityRepository.findAllBySpecializationsIn(specializationList);
    }
}
