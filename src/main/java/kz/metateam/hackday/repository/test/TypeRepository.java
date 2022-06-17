package kz.metateam.hackday.repository.test;

import kz.metateam.hackday.models.test.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
