package kz.metateam.hackday.service.implementation.news;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;
import kz.metateam.hackday.repository.TagRepository;
import kz.metateam.hackday.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    @Override
    public Tag save(Tag entity) {
        return tagRepository.save(entity);
    }

    @Override
    public Tag update(Tag entity) {
        Tag tag = findById(entity.getId());
        tag.setName(entity.getName());
        return tag;
    }

    @Override
    public void delete(Tag entity) {
        tagRepository.delete(entity);
    }

    @Override
    public Tag findById(Long aLong) {
        return tagRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }
}
