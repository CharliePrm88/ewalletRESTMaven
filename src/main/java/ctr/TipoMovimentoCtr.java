package ctr;

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
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.naming.NamingException;
import dao.TipoMovimentoDao;
import model.TipoMovimento;
import response.ResponseTipoMovimento;

@Path("/TipoMovimenti")
public class TipoMovimentoCtr {

	private TipoMovimentoDao ccd = new TipoMovimentoDao(); 
	private ResponseTipoMovimento rcc;
	
	@POST
	@Path("/inserisci")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento inserisciTM(TipoMovimento cc) {
		try {
			ccd.inserisciTipoMovimento(cc);
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo Movimento Creato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@DELETE
	@Path("/cancella")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento cancellaTM(TipoMovimento cc) {
		try {
			ccd.cancellaTipoMovimento(cc);
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo movimento Cancellato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@GET
	@Path("/listaTM")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento ritornaListaTM(){
		List<TipoMovimento> l1 = null;
		try {
			l1 = ccd.ritornaListaTipoMovimento();
			if(l1.isEmpty()) {
				rcc = new ResponseTipoMovimento("Oooops!",201,"Lista vuota!",null,l1);
			}else {
			rcc = new ResponseTipoMovimento("Ok!",200,"Lista Tipo Movimento Creata!",null,l1);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",null,l1);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",null,l1);
		}
		return rcc;
	}
	
	@GET
	@Path("/ritornaTM")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento ritornaTM(@QueryParam("id") int id) {
		TipoMovimento cc = null;
		try {
			cc = ccd.ritornaTipoMovimento(id);
			if(cc.getDescrizione().isEmpty()) {
				rcc = new ResponseTipoMovimento("Non esiste!",404,"Tipo Movimento non trovato!", cc, null);
			}else {
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo Movimento trovato!", cc, null);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}
	
	@PUT
	@Path("/aggiorna")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseTipoMovimento modificaTM(TipoMovimento cc) {
		try {
			ccd.updateTipoMovimento(cc);
			rcc = new ResponseTipoMovimento("Ok!",200,"Tipo Movimento Modificato!",cc,null);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1001,"Naming Exception!",cc,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rcc = new ResponseTipoMovimento("Oooops!",1002,"Eccezione in SQL",cc,null);
		}
		return rcc;
	}


}
