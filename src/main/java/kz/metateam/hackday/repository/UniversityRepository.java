package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.models.specialties.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UniversityRepository extends JpaRepository<University, Long> {
    University findByName(String name);
    List<University> findAllBySpecializationsIn(Set<Specialization> specializations);
}
