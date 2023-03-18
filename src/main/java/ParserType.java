import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserType {
    public static String getJsonFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            return ex.toString();
        } //надо логировать в лог
        return builder.toString();
    }
}
