package kz.metateam.hackday.service.implementation.news;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;
import kz.metateam.hackday.repository.NewsRepository;
import kz.metateam.hackday.service.NewsService;
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
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public News save(News entity) {
        return newsRepository.save(entity);
    }

    @Override
    public News update(News entity) {
        News news = findById(entity.getId());
        news.setDescription(entity.getDescription());
        news.setTitle(entity.getTitle());
        return news;
    }

    @Override
    public void delete(News entity) {
        newsRepository.delete(entity);
    }

    @Override
    public News findById(Long aLong) {
        return newsRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<News> findAll() {
        List<News> news = newsRepository.findAllByPinned(true);
        news.addAll(newsRepository.findAllByPinned(false));
        return news;
    }

    @Override
    public List<News> findAllByTags(Set<Tag> tagSet) {
        return newsRepository.findAllByTagSetIn(tagSet);
    }

    @Override
    public void addTagToNews(Tag tag, News news) {
        News news1 = findById(news.getId());
        news1.getTagSet().add(tag);
    }
}
