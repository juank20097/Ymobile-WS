package ymobilews.services;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ymobilews.model.manager.ManagerServicios;

@Path("/info")
public class InfoServicio {
	
	@EJB
	private ManagerServicios m;

	@GET
    @Path("/igen")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response infogen(){
    	return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(m.findAllGeneraL())
                .build();
    }
	    
    @GET
    @Path("/icat")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response categorias(){
    	return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(m.findAllCategoria())
                .build();
    }
}
