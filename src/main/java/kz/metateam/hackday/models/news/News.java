package kz.metateam.hackday.models.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @ManyToMany
    private Set<Tag> tagSet;
    private boolean pinned;

    public News(String title, String description, boolean pinned) {
        this.title = title;
        this.description = description;
        this.pinned = pinned;
    }
}
