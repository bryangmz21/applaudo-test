package com.applaudo.applaudotest;

import com.applaudo.applaudotest.data.Item;
import com.applaudo.applaudotest.services.ItemEjb;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections4.CollectionUtils;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/app")
public class ApplaudoResource {

    @EJB(lookup = "java:global/applaudo-challenge/ItemEjbImpl!com.applaudo.applaudotest.services.ItemEjb")
    ItemEjb itemEjb;

    @GET
    @Path("/item/{id}")
    @ApiResponses({
            @ApiResponse(code=404, message="NO_DATA_FOUND")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
            Item itemFind = itemEjb.findById(id);
            if (itemFind != null) {
                return Response.status(200).entity(itemFind).build();
            } else {
                return Response.status(404).entity("Item with id: ".concat(String.valueOf(id))
                        .concat(" ").concat(Response.Status.NOT_FOUND.toString())).build();
            }
    }

    @GET
    @Path("/item")
    @ApiResponses({
            @ApiResponse(code=404, message="NO_DATA_FOUND")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByStatusAndName(@QueryParam("itemStatus") String status, @QueryParam("itemName") String name) {
        List<Item> item = itemEjb.findAllByStatusAndName(status, name);

        if (!CollectionUtils.isEmpty(item) || item.size() > 0) {
            return Response.status(200).entity(item).build();
        } else {
            return Response.status(404).entity(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses({
            @ApiResponse(code=201, message="CREATED"),
            @ApiResponse(code=400, message="ALREADY_EXISTS")
    })
    public Response save(Item item) {
        try {
            itemEjb.save(item);
            return Response.status(201).entity(item).build();
        } catch (Exception e) {
            return Response.status(400).entity("Exception: ".concat(e.getMessage())).build();
        }
    }
}