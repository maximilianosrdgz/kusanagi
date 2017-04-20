package mizu.rest;

import mizu.domain.Category;
import mizu.proxy.JsonObjectProxy;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Created by ms.rodriguez on 20/4/2017.
 */
@Path("/category")
public class CategoryFacadeREST extends AbstractFacade<Category> {

    public CategoryFacadeREST() {
        super(Category.class);
    }

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return input;
    }

    @POST
    @Consumes("application/json")
    public void create(@RequestBody String json) throws IOException {
        super.create(JsonObjectProxy.CategoryFromJson(json));
    }

}
