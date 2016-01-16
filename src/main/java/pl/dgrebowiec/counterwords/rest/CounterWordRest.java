package pl.dgrebowiec.counterwords.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dgrebowiec.counterwords.domain.CounterWord;
import pl.dgrebowiec.counterwords.service.ContentService;

import java.util.List;

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */

@RestController
@RequestMapping("/words")
class CounterWordRest {

    private ContentService contentService;

    @Autowired
    public CounterWordRest(ContentService contentService) {
        this.contentService = contentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    public List<CounterWord> getCounterWords() {
        return contentService.getCounterWords();
    }
}
