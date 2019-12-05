package DotNet;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entity.Criteria;
import services.CriteriaService;


@Path("criteria")
@RequestScoped
public class CriteriaRSBean {
	
@EJB
CriteriaService CS =new CriteriaService();

@GET
@Produces(MediaType.APPLICATION_JSON)
//obtenir la liste de tous les criterias
public Response displayCriteriasList() {
	return Response.status(Status.OK).entity(CS.getAllCriterias()).build();
}


//Ajouter un criteria
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response addCriterias(Criteria criteria)
{
	CS.ajouterCriteria(criteria);
	System.out.println(criteria);
	return Response.status(Status.CREATED).entity("votre employee a ete ajoutee avec success !").build();
}


@DELETE
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response DeleteEmployee(@PathParam(value="id")int id )
{
	System.out.println("DELETE INITIATED");
	CS.deleteCriteriaById(id);
	return Response.status(Status.ACCEPTED).entity("deleted").build();
}

@PUT 
@Path("{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response updateReclamationAdmin(@PathParam("id")int id ,Criteria c)  {

	CS.updateByIdCriteria(id, c);
	return Response.status(Status.ACCEPTED).entity("updated:\n ").build();

}



}
