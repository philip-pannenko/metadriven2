package net.pannenko.resource;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.pannenko.bo.User;
import net.pannenko.uitemplate.UserForm;
import net.pannenko.utils.Mapper;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

  @GET
  public String getForm() throws JsonProcessingException {
    UserForm object = new UserForm();
    ObjectMapper myObjectMapper = new ObjectMapper();
    myObjectMapper.setSerializationInclusion(Include.NON_NULL);
    ObjectWriter ow = myObjectMapper.writer().withDefaultPrettyPrinter();
    return ow.writeValueAsString(object);
  }

  @POST
  @Path("/post")
  public Response createTrackInJSON2(UserForm form) throws Exception {
    
    User user = (User) Mapper.map(form, User.class);
    
    System.out.println(user);

    return Response.status(200).build();

  }
}