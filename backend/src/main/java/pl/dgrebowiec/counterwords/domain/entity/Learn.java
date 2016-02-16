package pl.dgrebowiec.counterwords.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * User: mgalezewska
 * Date: 2016-02-15
 */
@Entity
@Getter
@Setter
public class Learn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long learnId;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Boolean learned;


}
