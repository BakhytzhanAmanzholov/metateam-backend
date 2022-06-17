package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.specialties.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
    University findByName(String name);
}
