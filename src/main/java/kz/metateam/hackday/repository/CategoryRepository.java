package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.event.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
