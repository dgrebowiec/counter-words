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
@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"value", "language"}))
public class Translate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long translateId;

    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn( name = "wordId")
    private Word word;

    @Column
    private String value;

    @Column
    private String language;

}
