package kz.metateam.hackday.service;

import kz.metateam.hackday.models.specialties.Specialization;

public interface SpecializationService extends CrudService<Specialization, Long> {
    Specialization findByName(String name);
}
