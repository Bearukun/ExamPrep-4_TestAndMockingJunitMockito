/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import exercise.CommunicationException;
import exercise.Emailer;
import exercise.Fetcher;
import exercise.Joke;
import exercise.JokeFetcher;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bearu
 */
@Path("jokes")
public class JokesResource {

     private Gson gson = new Gson();
     
     private Fetcher fc = new Fetcher(new JokeFetcher(), new Emailer());
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JokesResource
     */
    public JokesResource() {
    }

    @GET
    @Path("/getourstolenjoke")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() {
        
        String errMsg;
        
         try {
             return gson.toJson(fc.fetchJoke(), Joke.class);
         } catch (CommunicationException ex) {
             errMsg = ex.getMessage();
         }
        return gson.toJson(errMsg, String.class);
    }

}
