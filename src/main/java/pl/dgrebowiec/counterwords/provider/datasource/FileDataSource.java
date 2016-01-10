package pl.dgrebowiec.counterwords.provider.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */
@Component
public class FileDataSource implements DataSource {

    private String text;
    private  String path;

    @Autowired
    public FileDataSource(@Value("${file.import.path}")String path) throws IOException {
        this.path = path;
    }

    public void readFile() throws IOException {
        Path path = Paths.get(this.path);

        StringBuilder sb = new StringBuilder();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path fileName: stream) {
                try(Stream<String> lines = Files.lines(fileName)){
                    lines.forEach(s -> sb.append(" "+s));
                }
            }
        }
        text = sb.toString();
    }

    @Override
    public String getText() {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
