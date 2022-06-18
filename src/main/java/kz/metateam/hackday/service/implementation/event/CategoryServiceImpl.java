package kz.metateam.hackday.service.implementation.event;

import kz.metateam.hackday.models.event.Category;
import kz.metateam.hackday.repository.CategoryRepository;
import kz.metateam.hackday.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category update(Category entity) {
        Category category = findById(entity.getId());
        category.setName(entity.getName());
        return category;
    }

    @Override
    public void delete(Category entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
