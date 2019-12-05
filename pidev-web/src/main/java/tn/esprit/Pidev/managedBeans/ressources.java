package tn.esprit.Pidev.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import tn.esprit.entity.Competance;
import tn.esprit.entity.Type;
import tn.esprit.entity.lol;
import tn.esprit.service.impl.CompetanceService;
import tn.esprit.service.impl.FicheMetierService;
import tn.esprit.service.interfaces.ICompetanceServiceRemote;
import tn.esprit.service.interfaces.IFicheMetierServiceRemote;
import tn.esprit.service.interfaces.INiveauxFicheServiceRemote;
@Path("users")
@RequestScoped
public class ressources {
	List<Competance>Modules  = new ArrayList<Competance>();
@EJB
 CompetanceService x ;

/*@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("all")
public Response getemp(@QueryParam("id")int id)
{
	return Response.ok(x.getAllCompetancesByFicheId(id)).build();
}*/
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("all")
public Response getemp()
{
	return Response.ok(x.getAllCompetances()).build();
}
@POST
@Path("add")
@Consumes(MediaType.APPLICATION_XML)
public Response AddModule (@QueryParam("name")String name,@QueryParam("Description") String Description,@QueryParam("type")String type)
{Competance comp = new Competance();
	comp.setDescription(Description);
	comp.setName(name);
	if (type.equals("langues")) {
	comp.setType(Type.langues);}
	else if(type.equals("")){
		comp.setType(Type.concept);}
		else if(type.equals("coding")){
			comp.setType(Type.coding);
			}else {
			return 	Response.status(Status.BAD_REQUEST).build();
			}
			


	return Response.status(Status.CREATED).build();

}
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("del")
public Response deluser(@QueryParam(value="id")int id)
{ x.removeCompetance(id);
	return Response.status(Status.OK).entity("deleted").build();
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response AddModule (Competance l)
{ if (l== null)
	{
		return Response.ok().entity("employe vide").build();
	}
x.addCompetance(l);
	return Response.status(Status.CREATED).build();

}
@Path("add")
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response AddModule (lol l)
{ if (l== null)
	{
		return Response.ok().entity("employe vide").build();
	}
x.addlol(l);
	return Response.status(Status.CREATED).build();

}
}
