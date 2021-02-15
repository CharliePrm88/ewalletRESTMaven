package ctr;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.MovimentiDao;
import model.Movimenti;
import response.ResponseMovimenti;

@Path("/Movimenti")
public class MovimentiCtr {
	private MovimentiDao ccd = new MovimentiDao(); 
	private ResponseMovimenti rcc;
	
	@POST
	@Path("/inserisci")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMovimenti inserisciM(Movimenti cc) {
		try {
			ccd.inserisciMovimenti(cc);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Creato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@DELETE
	@Path("/cancella")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMovimenti cancellaM(Movimenti cc) {
		try {
			ccd.cancellaMovimenti(cc);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1000,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@GET
	@Path("/listaM")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMovimenti ritornaListaM(){
		List<Movimenti> l1 = null;
		try {
			l1 = ccd.ritornaListaMovimenti();
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Cancellato!",null,l1);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Classe non trovata",null,l1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",null,l1);
		}
		if(l1.isEmpty()) {
			rcc = new ResponseMovimenti("Oooops!",201,"La lista è vuota!",null,l1);
		}
		return rcc;
	}
	
	@GET
	@Path("/ritornaM")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMovimenti ritornaM(@QueryParam("id") int id) {
		Movimenti cc = null;
		try {
			cc = ccd.ritornaMovimenti(id);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente trovato!", cc, null);
		} catch (NamingException e) {
			rcc = new ResponseMovimenti("Oooops!",1001,"Classe non trovata",cc,null);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@PUT
	@Path("/aggiorna")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseMovimenti modificaM(Movimenti cc) {
		try {
			ccd.updateMovimenti(cc);
			rcc = new ResponseMovimenti("Ok!",200,"Conto Corrente Modificato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseMovimenti("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}

}
