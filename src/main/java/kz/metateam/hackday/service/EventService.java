package kz.metateam.hackday.service;

import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface EventService extends CrudService<Event, Long> {
    void addCategoryToEvent(Category category, Event event);
    List<Event> findAllByCategorySetIn(Set<Category> categorySet);
    Event findByName(String name);
}
