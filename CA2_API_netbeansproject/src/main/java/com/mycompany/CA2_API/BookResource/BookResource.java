/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CA2_API.BookResource;

import com.mycompany.CA2_API.BookService.BookService;
import com.mycompany.CA2_API.model.Book;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author x14532757
 */
@Path("/books")
public class BookResource {
    
    BookService bookservice = new BookService(); 
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getMessagesXML(){
        return bookservice.GetAllBooks();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getMessagesJSON(){
        return bookservice.GetAllBooks();
    }
    
    @GET
    @Path("/{bookId}")
    @Produces(MediaType.APPLICATION_XML)
    public Book getMessagesXML(@PathParam("bookId") int id){
        return bookservice.getBook(id);
    }
    
    @GET
    @Path("/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getMessagesJSON(@PathParam("bookId") int id){
        return bookservice.getBook(id);
    }
   
   @DELETE
   @Path("/{bookId}")
   @Produces(MediaType.APPLICATION_XML)
   public Response deleteBookXML(@PathParam("bookId") int id){
       Book deletedbook = bookservice.deleteBook(id);
       String resp = "Book: " + "ID:" + id 
               + ", author:" + deletedbook.getAuthor()
               + ", publisher:" + deletedbook.getPublisher() 
               + ", title:" + deletedbook.getTitle() + 
               " (delete status: " + "success)";
       return Response.status(Response.Status.CREATED).entity(resp).build();	
   }
    
   
   @POST
   @Path("/{bookId}")
   @Consumes({ MediaType.APPLICATION_JSON })
   @Produces({MediaType.APPLICATION_JSON})
   public Response createBookJSON(final Book book) {
    	Book createdBook = bookservice.createBook(book);
        String resp = "Book created: true \n\nLocation => localhost:49000/api/books/"  ;
    	return Response.status(Response.Status.CREATED).entity(
                resp + 
                createdBook.getId()).build();
   }
   
   //codingpedia was used as a reference in coding the delete and post.
   //no actual from it was used. 
   //http://www.codingpedia.org/ama/tutorial-rest-api-design-and-implementation-in-java-with-jersey-and-spring/
   
}
