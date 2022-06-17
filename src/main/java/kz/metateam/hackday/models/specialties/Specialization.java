package kz.metateam.hackday.models.specialties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String lessonA;
    private String lessonB;
    private int minMark;

    public Specialization(String name, String description, String lessonA, String lessonB, int minMark) {
        this.name = name;
        this.description = description;
        this.lessonA = lessonA;
        this.lessonB = lessonB;
        this.minMark = minMark;
    }
}
