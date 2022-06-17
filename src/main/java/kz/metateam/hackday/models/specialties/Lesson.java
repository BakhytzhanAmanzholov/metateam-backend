package kz.metateam.hackday.models.specialties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToMany
    private Set<Specialization> specializationSet = new HashSet<>();

    public Lesson(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
