package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.news.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
