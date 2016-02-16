package pl.dgrebowiec.counterwords.domain.entity;

import lombok.Getter;
import lombok.Setter;

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
//    @JoinColumn(name = "translate_id")
    private List<Translate> translateList = new ArrayList<>();
}
