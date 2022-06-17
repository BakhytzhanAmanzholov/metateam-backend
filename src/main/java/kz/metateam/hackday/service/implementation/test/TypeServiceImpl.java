package kz.metateam.hackday.service.implementation.test;

import kz.metateam.hackday.models.test.Type;
import kz.metateam.hackday.repository.TypeRepository;
import kz.metateam.hackday.service.TypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Override
    public Type save(Type entity) {
        log.info("Save type {}", entity.getName());
        return typeRepository.save(entity);
    }

    @Override
    public Type update(Type entity) {
        Type type = typeRepository.findByName(entity.getName());
        type.setDescription(entity.getDescription());
        return type;
    }

    @Override
    public void delete(Type entity) {
        typeRepository.delete(entity);
    }

    @Override
    public Type findById(Long aLong) {
        return typeRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
