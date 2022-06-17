package kz.metateam.hackday.service;

public interface CrudService<T, ID>{
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    T findById(ID id);
}
