package mizu.rest;

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

/**
 * Created by ms.rodriguez on 20/4/2017.
 */
@Path("/product")
public class ProductFacadeREST extends AbstractFacade<Product> {

    public ProductFacadeREST() {
        super(Product.class);
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
        super.create(JsonObjectProxy.ProductFromJson(json));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Product find(@PathParam("id") String id) throws IOException {
        return super.find(id);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void update(@PathParam("id") String id, @RequestBody String json) throws IOException {
        super.update(JsonObjectProxy.ProductFromJson(json));
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        super.delete(super.find(id));
    }

}
