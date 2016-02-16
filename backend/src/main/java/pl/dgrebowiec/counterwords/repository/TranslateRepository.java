package pl.dgrebowiec.counterwords.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dgrebowiec.counterwords.domain.entity.Translate;

import java.util.List;

/**
 * User: mgalezewska
 * Date: 2016-02-16
 */
@Repository
public interface TranslateRepository extends CrudRepository<Translate, Long> {
    @Override
    Translate save(Translate s);

    List<Translate> findByLanguageAndValueIn(String language, List<String> valueList);
}
