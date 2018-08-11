package io.swagger.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.api.impl.CommentsApiServiceImpl;
import io.swagger.model.Comment;

@Path("/comments")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the comments API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-08-06T19:44:40.063-04:00")
public class CommentsApi  {

	private CommentsApiService commentsApiService = new CommentsApiServiceImpl();

	@GET

	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "", response = Comment.class, responseContainer = "List", tags={  })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successful Operation", response = Comment.class, responseContainer = "List") })
	public Response commentsGet(@Context SecurityContext securityContext)
			throws NotFoundException {
		return commentsApiService.commentsGet(securityContext);
	}
}