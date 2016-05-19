package pl.dgrebowiec.counterwords.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dgrebowiec.counterwords.domain.entity.Word;

/**
 * User: mgalezewska
 * Date: 2016-02-15
 */
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

}
