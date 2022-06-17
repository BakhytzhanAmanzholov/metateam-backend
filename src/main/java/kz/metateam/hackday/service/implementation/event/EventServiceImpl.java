package kz.metateam.hackday.service.implementation.event;

import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.models.event.Event;
import kz.metateam.hackday.repository.EventRepository;
import kz.metateam.hackday.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    @Override
    public Event update(Event entity) {
        Event event = findById(entity.getId());
        event.setCity(entity.getCity());
        event.setName(event.getName());
        return event;
    }

    @Override
    public void delete(Event entity) {
        eventRepository.delete(entity);
    }

    @Override
    public Event findById(Long aLong) {
        return eventRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void addCategoryToEvent(Category category, Event event) {
        Event event1 = findById(event.getId());
        event1.getCategorySet().add(category);
    }

    @Override
    public List<Event> findAllByCategorySetIn(Set<Category> categorySet) {
        return eventRepository.findAllByCategorySetIn(categorySet); // TODO : тестировать
    }
}
