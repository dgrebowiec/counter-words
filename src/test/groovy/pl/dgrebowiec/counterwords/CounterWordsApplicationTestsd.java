package pl.dgrebowiec.counterwords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.dgrebowiec.counterwords.service.ContentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CounterWordsApplication.class)
@WebAppConfiguration
public class CounterWordsApplicationTestsd {

	@Autowired
	ContentService content;

	@Test
	public void contextLoads() {


	}

}
