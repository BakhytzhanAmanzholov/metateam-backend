package kz.metateam.hackday.service.implementation.specialization;

import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.repository.SpecializationRepository;
import kz.metateam.hackday.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecializationServiceImpl implements SpecializationService {
    private final SpecializationRepository specializationRepository;

    @Override
    public Specialization save(Specialization entity) {
        return specializationRepository.save(entity);
    }

    @Override
    public Specialization update(Specialization entity) {
        Specialization specialization = specializationRepository.findByName(entity.getName());
        specialization.setDescription(entity.getDescription());
        return specialization;
    }

    @Override
    public void delete(Specialization entity) {
        specializationRepository.delete(entity);
    }

    @Override
    public Specialization findById(Long aLong) {
        return specializationRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }
}
