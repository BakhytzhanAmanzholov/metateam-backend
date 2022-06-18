package kz.metateam.hackday.service;

import kz.metateam.hackday.models.news.News;
import kz.metateam.hackday.models.news.Tag;

public interface TagService extends CrudService<Tag, Long>{
    Tag findByName(String name);
}
