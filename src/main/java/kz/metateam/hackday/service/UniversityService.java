package kz.metateam.hackday.service;

import kz.metateam.hackday.models.specialties.Specialization;
import kz.metateam.hackday.models.specialties.University;

import java.util.List;
import java.util.Set;

public interface UniversityService extends CrudService<University, Long> {
    void addSpecializationToUniversity(Specialization specialization, University university);
    List<University> findAllBySpecializations(Set<Specialization> specializationList);
}
