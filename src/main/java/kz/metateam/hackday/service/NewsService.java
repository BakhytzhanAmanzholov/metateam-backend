package kz.metateam.hackday.service;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;

import java.util.List;
import java.util.Set;

public interface NewsService extends CrudService<News, Long>{
    List<News> findAllByTags(Set<Tag> tagSet);
    void addTagToNews(Tag tag, News news);
}
