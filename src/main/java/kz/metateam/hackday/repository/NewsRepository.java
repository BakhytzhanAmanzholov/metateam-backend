package kz.metateam.hackday.repository;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByTagSetIn(Set<Tag> tagSet);
    List<News> findAllByPinned(boolean pinned);
}
