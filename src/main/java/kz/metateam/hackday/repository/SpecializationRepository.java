package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.specialties.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    Specialization findByName(String name);
}
