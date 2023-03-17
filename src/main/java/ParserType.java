import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
        import java.util.Map;
        import java.util.TreeMap;


public class ParserType {

    public static String   getJsonFile (String path){
        StringBuilder builder =  new StringBuilder();
    try
    {
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.forEach(line -> builder.append(line));
    }
    catch(Exception ex)
    { return ex.toString();} //надо логировать в лог
        return builder.toString();

    };

}
