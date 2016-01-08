package pl.dgrebowiec.counterwords

import pl.dgrebowiec.counterwords.provider.CounterWordsProvider
import spock.lang.Specification
/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */
class CounterWordsApplicationTest extends Specification {

    String text = "aa bb aa cc aa aa cc cc dew dew"
    CounterWordsProvider counterWordsProvider = new CounterWordsProvider();

    def "should be grouped and sorted words"() {
        when:
            Map map = counterWordsProvider.counterWords(text);
        then:
            map == [aa:4, cc:3, bb:1]
    }

    def "should be empty map if text is empty"() {
        when:
            Map map = counterWordsProvider.counterWords("")
        then:
            map == [:]
    }

    def "should be empty map if text is null"() {
        when:
            Map map = counterWordsProvider.counterWords(null)
        then:
            map == [:]
    }
}
