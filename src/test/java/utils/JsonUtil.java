package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;

public class JsonUtil {

    public static <T> T readJson(String filePath, Class<T> clazz) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), clazz);
    }

    public static <T> java.util.List<T> readJsonList(
            String filePath,
            Class<T> clazz) throws Exception{

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                new File(filePath),
                mapper.getTypeFactory()
                        .constructCollectionType(
                                java.util.List.class,
                                clazz
                        ));
    }
}
