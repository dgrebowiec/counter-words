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
@Table(name = "system_user")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String login;

    @OneToMany
//    @JoinColumn(name = "learn_id")
    private List<Learn> learnList = new ArrayList<>();

}
