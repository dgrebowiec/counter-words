package pl.dgrebowiec.counterwords.provider.datasource

import pl.dgrebowiec.counterwords.provider.CounterWordsProvider
import spock.lang.Specification

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */

class FileDataSourceTest extends Specification {

    def "should name"() {
        given:
            FileDataSource dataSource = new FileDataSource("../file_import");
            dataSource.readFile();
            CounterWordsProvider counterWordsProvider = new CounterWordsProvider();

        when:
            Map map = counterWordsProvider.counterWords(dataSource.getText());
        then:
            map.get("aa").getNumberRepeat() == 4
            map.get("cc").getNumberRepeat() == 3
            map.get("dew").getNumberRepeat() == 2
    }
}
