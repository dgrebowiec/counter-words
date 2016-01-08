package pl.dgrebowiec.counterwords.provider.datasource;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Dariusz Grebowiec <dariusz.grebowiec@coi.gov.pl>
 */
public class FileDataSource implements DataSource {

    private String text;
    private String path;


    public FileDataSource() {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() throws IOException {
        Path path = Paths.get("file_import");

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
        return text;
    }
}
