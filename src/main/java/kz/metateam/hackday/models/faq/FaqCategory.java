package kz.metateam.hackday.models.faq;

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
public class FaqCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int number = 1;
    @OneToMany
    private Set<FaqQuestion> questionSet = new HashSet<>();

    public FaqCategory(String name) {
        this.name = name;
    }
}
