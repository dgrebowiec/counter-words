package pl.dgrebowiec.counterwords.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dgrebowiec.counterwords.domain.entity.Word;

/**
 * User: mgalezewska
 * Date: 2016-02-15
 */
@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

    @Override
    Word save(Word s);

}
