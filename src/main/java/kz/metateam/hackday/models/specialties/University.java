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
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    private String region;
    @ManyToMany
    private Set<Specialization> specializations = new HashSet<>();

    public University(String name, String city, String region) {
        this.name = name;
        this.city = city;
        this.region = region;
    }
}
