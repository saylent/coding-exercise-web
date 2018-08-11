package io.swagger.api.impl;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.CommentsApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.Comment;

@RequestScoped
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2018-08-06T19:44:40.063-04:00")
public class CommentsApiServiceImpl implements CommentsApiService {
	// generated by swagger code gen, modified by Anne

	@Override
	public Response commentsGet(SecurityContext securityContext) throws NotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(createComments());

			return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, jsonString)).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage())).build();
		}
	}

	private Comment[] createComments() {
		Comment[] comments = new Comment[100];
		Integer postId = 0;
		for (int i = 1; i <= 100; i++) {
			int index = i - 1;
			postId = getRandomPostId();
			comments[index] = createComment(i, postId, "Comment #" + i, "somename@me.com", "Comment Body#" + i);
		}
		return comments;
	}

	private Comment createComment(Integer id, Integer postId, String name, String email, String body) {
		Comment c = new Comment();
		c.setId(id);
		c.setPostId(postId);
		c.setName(name);
		c.setEmail(email);
		c.setBody(body);
		return c;
	}

	private int getRandomPostId() {
		Random r = new Random();
		return r.nextInt((20 - 1) + 1) + 1;
	}
}