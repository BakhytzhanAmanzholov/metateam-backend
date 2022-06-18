package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByCategorySetIn(Set<Category> categorySet);
    Event findByName(String name);
}
