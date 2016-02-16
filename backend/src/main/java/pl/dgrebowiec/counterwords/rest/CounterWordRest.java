package pl.dgrebowiec.counterwords.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
class CounterWordRest {

    private WebServices webService;

    @Autowired
    public CounterWordRest(WebServices webService) {
        this.webService = webService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<CounterWord> getCounterWords() {
        return webService.getContentService().getCounterWords();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT)
    public void saveWords() {
        webService.saveWords();
    }
}
