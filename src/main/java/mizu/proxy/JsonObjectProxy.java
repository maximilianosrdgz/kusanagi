package mizu.proxy;

import mizu.domain.Category;
import mizu.domain.Product;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by ms.rodriguez on 20/4/2017.
 */
public class JsonObjectProxy {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Product ProductFromJson(String json) throws IOException {
        return mapper.readValue(json, Product.class);
    }

    public static Category CategoryFromJson(String json) throws IOException {
        return mapper.readValue(json, Category.class);
    }

}
