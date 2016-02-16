package pl.dgrebowiec.counterwords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgrebowiec.counterwords.domain.entity.Translate;
import pl.dgrebowiec.counterwords.domain.entity.Word;
import pl.dgrebowiec.counterwords.repository.TranslateRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: mgalezewska
 * Date: 2016-02-15
 */
@Service
public class PersistenceService {

    private TranslateRepository translateRepository;

    @Autowired
    public PersistenceService(TranslateRepository translateRepository) {
        this.translateRepository = translateRepository;
    }


    @Transactional
    public void saveWords(List<String> wordList) {
        for(String value : getDontExistWords(wordList)) {
            try {
                saveWord(value);
            } catch (NonTransientDataAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional
    private List<String> getDontExistWords(List<String> wordList) {
        List<Translate> translateList = translateRepository.findByLanguageAndValueIn("PL", wordList);
         wordList.removeAll(translateList
                .stream().map(s -> s.getValue()).collect(Collectors.toList()));
        return wordList;

    }


    public void saveWord(String value) throws NonTransientDataAccessException {

        Translate translate = new Translate();
        translate.setWord(new Word());
        translate.setLanguage("PL");
        translate.setValue(value);
        translateRepository.save(translate);
    }


}
