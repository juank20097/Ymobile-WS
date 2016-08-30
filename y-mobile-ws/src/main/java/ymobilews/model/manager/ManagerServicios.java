package ymobilews.model.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ymobilews.model.dao.entities.InfCategoria;
import ymobilews.model.dao.entities.InfInformacionGeneral;

@Stateless
public class ManagerServicios {
	
	@EJB
	private ManagerDAO mngDAO;
	
	public ManagerServicios() {
	}
	
	@SuppressWarnings("unchecked")
	public List<InfCategoria> findAllCategoria(){
		return mngDAO.findWhere(InfCategoria.class, 
				"o.catCodigo IN (SELECT DISTINCT(p.infCategoria.catCodigo) FROM InfInformacion p)"
				+ " AND o.catEstado='A'", "o.catOrden");
	}
	
	@SuppressWarnings("unchecked")
	public List<InfInformacionGeneral> findAllGeneraL(){
		return mngDAO.findWhere(InfInformacionGeneral.class, "o.infEstado='A'","o.infOrden");
	}
	
}
