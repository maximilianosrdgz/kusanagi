package mizu.proxy;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by ms.rodriguez on 20/4/2017.
 */
public class JsonObjectProxy<T> {

    private final Class<T> entityClass;

    public JsonObjectProxy(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    private ObjectMapper mapper = new ObjectMapper();

    public T getObjectFromJson(String json) throws IOException {
        return mapper.readValue(json, this.entityClass);
    }
}
