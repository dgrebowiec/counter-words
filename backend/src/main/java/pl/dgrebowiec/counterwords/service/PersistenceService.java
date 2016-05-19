package pl.dgrebowiec.counterwords.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgrebowiec.counterwords.domain.entity.Learn;
import pl.dgrebowiec.counterwords.domain.entity.Translate;
import pl.dgrebowiec.counterwords.domain.entity.Word;
import pl.dgrebowiec.counterwords.repository.LearnRepository;
import pl.dgrebowiec.counterwords.repository.TranslateRepository;
import pl.dgrebowiec.counterwords.repository.WordRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: mgalezewska
 * Date: 2016-02-15
 */
@Service
public class PersistenceService {

    private TranslateRepository translateRepository;
    private WordRepository wordRepository;
    private LearnRepository learnRepository;

    @Autowired
    public PersistenceService(
            TranslateRepository translateRepository,
            WordRepository wordRepository,
            LearnRepository learnRepository) {
        this.translateRepository = translateRepository;
        this.wordRepository = wordRepository;
        this.learnRepository = learnRepository;
    }

    @Transactional
    public void saveLearn(@NonNull final String word) {
        Translate translate = translateRepository.findByValue(word);
        if(translate == null) {
         translate = saveWord(word);
        }
        Learn learn = learnRepository.findByWord_WordId(translate.getWord().getWordId());
        if (learn == null) {
            learn = new Learn();
        }
        learn.setLearned(!learn.getLearned());
        learn.setWord(translate.getWord());
        learnRepository.save(learn);

    }

    @Transactional
    public void saveWords(final List<String> wordList) {
        for(String value : getDontExistWords(wordList)) {
            try {
                saveWord(value);
            } catch (NonTransientDataAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Z przekazanej listy zwraca tylko te slowa, ktorych nie ma w bazie
     * @param wordList
     * @return
     */
    @Transactional
    private List<String> getDontExistWords(final List<String> wordList) {
        List<Translate> translateList = translateRepository.findByLanguageAndValueIn("PL", wordList);
        getLearnedWords(wordList);
         wordList.removeAll(translateList
                .stream().map(s -> s.getValue()).collect(Collectors.toList()));
        return wordList;

    }


    public Translate saveWord(final String value) throws NonTransientDataAccessException {

        Translate translate = new Translate();
        translate.setWord(new Word());
        translate.setLanguage("PL");
        translate.setValue(value);
        translateRepository.save(translate);
        return translate;
    }

    public List<String> getLearnedWords(final List<String> words) {
        List<String> learnedWordList = new ArrayList<>();

        translateRepository.findByWord_LearnList_LearnedTrueAndLanguageAndValueIn("PL", words);
        return learnedWordList;
    }


}
