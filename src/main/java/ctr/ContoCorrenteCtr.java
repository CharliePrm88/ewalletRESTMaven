package ctr;

import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;
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
import dao.ContoCorrenteDao;

import model.ContoCorrente;
import response.ResponseContoCorrente;

@Path("/ContoCorrente")
public class ContoCorrenteCtr {
	private ContoCorrenteDao ccd = new ContoCorrenteDao(); 
	private ResponseContoCorrente rcc;
	
	@POST
	@Path("/inserisci")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseContoCorrente inserisciCC(ContoCorrente cc) {
		try {
			ccd.inserisciContoCorrente(cc);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Creato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@DELETE
	@Path("/cancella")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseContoCorrente cancellaCC(ContoCorrente cc) {
		try {
			ccd.cancellaContoCorrente(cc);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Cancellato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@GET
	@Path("/listaCC")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseContoCorrente ritornaListaCC(){
		List<ContoCorrente> l1;
		try {
			l1 = ccd.ritornaListaContoCorrente();
			rcc = new ResponseContoCorrente("Ok!",200,"Lista dei conto Correnti ritornata!",null,l1);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",null,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",null,null);
		}
		return rcc;
	}
	
	@GET
	@Path("/ritornaCC")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseContoCorrente ritornaCC(@QueryParam("idCliente") int id) {
		try {
			ContoCorrente cc= ccd.ritornaContoCorrente(id);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente trovato!", cc, null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",null,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",null,null);
		}
		return rcc;
	}
	
	@PUT
	@Path("/aggiorna")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseContoCorrente modificaCC(ContoCorrente cc) {
		try {
			ccd.updateContoCorrente(cc);
			rcc = new ResponseContoCorrente("Ok!",200,"Conto Corrente Modificato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseContoCorrente("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rcc = new ResponseContoCorrente("Oooops!",1002,"Eccezione in SQL",cc,null);
			e.printStackTrace();
		}
		return rcc;
	}
}
