package mizu.rest;

import mizu.domain.Category;
import mizu.domain.Product;
import mizu.proxy.JsonObjectProxy;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.List;

/**
 * Created by ms.rodriguez on 20/4/2017.
 */
@Path("/category")
public class CategoryFacadeREST extends AbstractFacade<Category> {

    private JsonObjectProxy<Category> proxy = new JsonObjectProxy<>(Category.class);

    private CategoryFacadeREST() {
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
        super.create(proxy.getObjectFromJson(json));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Category find(@PathParam("id") String id) throws IOException {
        return super.find(id);
    }

    @GET
    @Produces("application/json")
    public List<Category> findAll() {
        return super.findAll();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") String id, @RequestBody String json) throws IOException {
        super.update(proxy.getObjectFromJson(json));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        super.delete(super.find(id));
    }

    @GET
    @Path("/count")
    @Produces("application/json")
    public int count() {
        return super.count(super.findAll());
    }
}
