package pl.dgrebowiec.counterwords.service

import pl.dgrebowiec.counterwords.repository.LearnRepository
import pl.dgrebowiec.counterwords.repository.TranslateRepository
import pl.dgrebowiec.counterwords.repository.WordRepository

//import pl.dgrebowiec.counterwords.domain.entity.Word
//import pl.dgrebowiec.counterwords.repository.WordRepository
import spock.lang.Specification

/**
 * User: mgalezewska
 * Date: 2016-02-20
 */
class PersistenceServiceTest extends Specification {

    TranslateRepository translateRepository = Mock(TranslateRepository.class);
    WordRepository wordRepository = Mock(WordRepository.class);
    LearnRepository learnRepository = Mock(LearnRepository.class);

    PersistenceService persistenceService = new PersistenceService(translateRepository, wordRepository, learnRepository);

    def "saveLearn"() {

    }

}
