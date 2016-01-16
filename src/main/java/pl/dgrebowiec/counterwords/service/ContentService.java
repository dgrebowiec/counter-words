package pl.dgrebowiec.counterwords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dgrebowiec.counterwords.domain.CounterWord;
import pl.dgrebowiec.counterwords.provider.CounterWordsProvider;
import pl.dgrebowiec.counterwords.provider.datasource.DataSource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */
@Component
public class ContentService {

    private CounterWordsProvider counterWordsProvider;
    private DataSource dataSource;

    @Autowired
    public ContentService(CounterWordsProvider counterWordsProvider, DataSource dataSource) {
        this.counterWordsProvider = counterWordsProvider;
        this.dataSource = dataSource;
    }

    public List<CounterWord> getCounterWords() {
        counterWordsProvider.counterWords(dataSource.getText());
        counterWordsProvider.convertPercent();
        return counterWordsProvider.getWords().entrySet().stream().map(s -> s.getValue()).collect(Collectors.toList());
    }





}
