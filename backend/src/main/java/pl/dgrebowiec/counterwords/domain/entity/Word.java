package pl.dgrebowiec.counterwords.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mgalezewska
 * Date: 2016-02-15
 */
@Entity
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wordId;

    @OneToMany
    @JoinColumn(name = "translateId")
    private List<Translate> translateList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "learnId")
    private List<Learn> learnList = new ArrayList<>();
}
