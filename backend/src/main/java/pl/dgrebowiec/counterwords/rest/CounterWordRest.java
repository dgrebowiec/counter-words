package pl.dgrebowiec.counterwords.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dgrebowiec.counterwords.domain.CounterWord;
import pl.dgrebowiec.counterwords.service.ContentService;
import pl.dgrebowiec.counterwords.service.PersistenceService;
import pl.dgrebowiec.counterwords.service.WebServices;

import java.util.List;

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */

@RestController
@RequestMapping("/words")
@CrossOrigin
class CounterWordRest {

    private WebServices webService;

    @Autowired
    public CounterWordRest(WebServices webService) {
        this.webService = webService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CounterWord> getCounterWordList() {
        return webService.getContentService().getCounterWords();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void saveWords() {
        webService.saveWords();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void learnedWord(@RequestBody String word) {
        webService.getPersistenceService().saveLearn(word);
    }

    @RequestMapping(value = "/showLearned", method = RequestMethod.GET)
    public List<CounterWord> getCounterWordLearnedList() {
        return webService.getContentService().getCounterWords();
    }
}
