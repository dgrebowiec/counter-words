package pl.dgrebowiec.counterwords.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dgrebowiec.counterwords.domain.entity.Learn;

/**
 * User: mgalezewska
 * Date: 2016-02-20
 */
@Repository
public interface LearnRepository extends JpaRepository<Learn, Long> {
    Learn findByWord_WordId(Long wordId);
}
