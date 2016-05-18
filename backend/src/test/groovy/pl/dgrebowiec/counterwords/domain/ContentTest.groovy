package pl.dgrebowiec.counterwords.domain

import pl.dgrebowiec.counterwords.provider.CounterWordsProvider
import pl.dgrebowiec.counterwords.provider.datasource.FileDataSource
import pl.dgrebowiec.counterwords.service.ContentService
import spock.lang.Specification

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */
class ContentTest extends Specification {
    CounterWordsProvider counterWordsProvider = new CounterWordsProvider();
    String text = "aa bb aa cc aa aa cc cc dew dew"
    FileDataSource dataSource = new FileDataSource("../file_import2")

    def "should name"() {

        when:
            dataSource.readFile()
            Map map = counterWordsProvider.counterWords(dataSource.getText())
            counterWordsProvider.convertPercent();
        then:
            1==1


            // TODO implement assertions
    }
}
