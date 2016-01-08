package pl.dgrebowiec.counterwords.provider.datasource

import pl.dgrebowiec.counterwords.provider.CounterWordsProvider
import spock.lang.Specification

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */

class FileDataSourceTest extends Specification {

    def "should name"() {
        given:
            FileDataSource dataSource = new FileDataSource();
            CounterWordsProvider counterWordsProvider = new CounterWordsProvider();
        when:
            Map map = counterWordsProvider.counterWords(dataSource.getText());
        then:
            map == [cc:7, aa:4, bb:1]
    }
}
