package com.weixao;

import com.weixiao.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> listAll() {
        return User.listAll();
    }

    @GET
    @Path("/search")
    public List<User> search(@QueryParam("name") String name, @QueryParam("email") String email) {
        return User.findUserDynamic(name, email);
    }

    @POST
    @Transactional
    public Response create(User user) {
        user.persist();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public User update(@PathParam("id") Long id, User updatedUser) {
        User entity = User.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.name = updatedUser.name;
        entity.email = updatedUser.email;
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        User entity = User.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }
}