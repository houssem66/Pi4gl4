package tn.esprit.Rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.mission.entity.Affectation;
import tn.esprit.mission.entity.MissionPolicy;
import tn.esprit.mission.interfaces.IAffectationService;
import tn.esprit.mission.interfaces.IMissionPolicyService;
import tn.esprit.mission.service.AffectationService;
import tn.esprit.mission.service.MissionPolicyService;


@Path("/Services")
@RequestScoped
public class ApiServices {
	@EJB
	IMissionPolicyService p = new MissionPolicyService();
	@EJB
	IAffectationService a = new AffectationService();	
	
	private static List<Affectation> emp = new ArrayList<Affectation>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getAllModules() {  
		emp=a.getAllAffectation();
		System.out.println(emp);
		if(emp == null)  {  
			
			return Response.status(Status.NOT_FOUND).build(); 
				}        
	return Response.status(Status.OK).entity(emp).build(); 
	} 
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmploye(@PathParam(value="id") int id) {
		p.deleteMissionPolicyById(id);
		if(p.getMissioPolicynById(id) == null) {
			return Response.status(Status.OK).entity("TRUE").build();    
	}
		else  
		{  
	    return Response.status(Status.NOT_FOUND).entity("FALSE").build(); 
			}  

		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmploye(Affectation aff) {
   	if(aff!=null) {
   		a.addAffectation(aff);
   		
   		return Response.status(Status.CREATED).entity("add succesfull").build();    
   	}
   		else  
   		{  
   	    return Response.status(Status.NOT_FOUND).entity("add failed").build(); 
   			}  
   }
}
