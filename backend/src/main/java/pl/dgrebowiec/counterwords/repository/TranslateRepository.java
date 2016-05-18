package pl.dgrebowiec.counterwords.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dgrebowiec.counterwords.domain.entity.Translate;

import java.util.List;

/**
 * User: mgalezewska
 * Date: 2016-02-16
 */
@Repository
public interface TranslateRepository extends JpaRepository<Translate, Long> {
    List<Translate> findByLanguageAndValueIn(String language, List<String> valueList);

    Translate findByValue(String word);
    Translate findByWord_LearnList_LearnedTrueAndLanguageAndValueIn(String language, List<String> valueList);
}
