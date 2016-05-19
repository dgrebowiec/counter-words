package pl.dgrebowiec.counterwords.provider;

import org.springframework.stereotype.Component;
import pl.dgrebowiec.counterwords.domain.CounterWord;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */

@Component
public class CounterWordsProvider {

    private int countWords = 0;
    private Map<String, CounterWord> wordMap = new LinkedHashMap<>();

    private List<String> getWordMap(String text) {
        List<String> words = new ArrayList<>();
        if (text == null) return words;

        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        while (matcher.find()) {
          //  if(matcher.group().length() > 3)
            words.add(matcher.group());
        }
        countWords = words.size();
        return words;
    }

    private Map<String, CounterWord> getGroupAndSortedWordMap(List<String> wordsString) {
        Map<String, CounterWord> groupWords = new LinkedHashMap<>();
        for (String word : wordsString) {
            if (groupWords.containsKey(word)) {
                groupWords.put(word, new CounterWord(word, groupWords.get(word).getNumberRepeat() + 1));
            } else {
                groupWords.put(word, new CounterWord(word, 1));
            }
        }
        groupWords.entrySet().stream()
                .sorted(Map.Entry.<String, CounterWord>comparingByValue().reversed())
                        // .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(s -> wordMap.put(s.getKey(), s.getValue()));

        return wordMap;
    }


    public Map<String, CounterWord> counterWordMap(String text) {
        return getGroupAndSortedWordMap(getWordMap(text));
    }

    public void convertPercent() {
        wordMap.entrySet().stream().
                forEach(s -> s.getValue().setPercent((s.getValue().getNumberRepeat() / (double) countWords) * 100d));
    }

    public Map<String, CounterWord> getWordMap() {
        return wordMap;
    }


}


