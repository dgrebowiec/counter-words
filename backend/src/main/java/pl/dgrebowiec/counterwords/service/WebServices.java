package pl.dgrebowiec.counterwords.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dgrebowiec.counterwords.domain.CounterWord;
import pl.dgrebowiec.counterwords.provider.CounterWordsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: mgalezewska
 * Date: 2016-02-16
 */
@Service
@Getter
public class WebServices {

    private ContentService contentService;
    private PersistenceService persistenceService;

    @Autowired
    public WebServices(ContentService contentService, PersistenceService persistenceService) {
        this.contentService = contentService;
        this.persistenceService = persistenceService;
    }

    public void saveWords() {
        List<CounterWord> counterWordList = contentService.getCounterWords();
        List<String> wordList = counterWordList.stream().map(s -> s.getWord()).collect(Collectors.toList());
        persistenceService.saveWords(wordList);
    }

    public void getCounterWordLearnedList() {
        List<String> learnedWordList = persistenceService.getLearnedWords(
                contentService.getCounterWords().stream().map(s -> s.getWord()).collect(Collectors.toList())
        );

       /* List<CounterWord> counterWordLearnedList = new ArrayList<>();
        learnedWordList.stream().forEach(
                counterWordLearnedList.add(new )
        );*/

    }
}
