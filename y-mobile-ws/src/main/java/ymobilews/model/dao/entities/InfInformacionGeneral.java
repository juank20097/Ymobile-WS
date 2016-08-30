package ymobilews.model.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the inf_informacion_general database table.
 * 
 */
@Entity
@Table(name="inf_informacion_general")
@NamedQuery(name="InfInformacionGeneral.findAll", query="SELECT i FROM InfInformacionGeneral i")
@XmlRootElement
public class InfInformacionGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="inf_codigo_gen", length=5)
	@XmlElement(name="codigo")
	private String infCodigo;

	@Column(name="inf_descripcion", columnDefinition="text")
	@XmlElement(name="descripcion")
	private String infDescripcion;

	@Column(name="inf_estado", length=100)
	@XmlElement(name="estado")
	private String infEstado;

	@Column(name="inf_icono", columnDefinition="text")
	@XmlElement(name="icono")
	private String infIcono;
	
	@Column(name="inf_orden")
	@XmlElement(name="orden")
	private Integer infOrden;

	@Column(name="inf_titulo", length=150)
	@XmlElement(name="titulo")
	private String infTitulo;
	
	//bi-directional many-to-one association to InfImagen
	@OneToMany(mappedBy="infInformacionGeneral", fetch = FetchType.EAGER)
	@XmlElement(name="imgs")
	private List<InfImagen> infImagens;

	public InfInformacionGeneral() {
	}

	public String getInfCodigo() {
		return this.infCodigo;
	}

	public void setInfCodigo(String infCodigo) {
		this.infCodigo = infCodigo;
	}

	public String getInfDescripcion() {
		return this.infDescripcion;
	}

	public void setInfDescripcion(String infDescripcion) {
		this.infDescripcion = infDescripcion;
	}

	public String getInfEstado() {
		return this.infEstado;
	}

	public void setInfEstado(String infEstado) {
		this.infEstado = infEstado;
	}

	public String getInfIcono() {
		return this.infIcono;
	}

	public void setInfIcono(String infIcono) {
		this.infIcono = infIcono;
	}
	
	public Integer getInfOrden() {
		return this.infOrden;
	}

	public void setInfOrden(Integer infOrden) {
		this.infOrden = infOrden;
	}
	
	public String getInfTitulo() {
		return this.infTitulo;
	}

	public void setInfTitulo(String infTitulo) {
		this.infTitulo = infTitulo;
	}
	
	public List<InfImagen> getInfImagens() {
		return this.infImagens;
	}

	public void setInfImagens(List<InfImagen> infImagens) {
		this.infImagens = infImagens;
	}

	public InfImagen addInfImagen(InfImagen infImagen) {
		getInfImagens().add(infImagen);
		infImagen.setInfInformacionGeneral(this);

		return infImagen;
	}

	public InfImagen removeInfImagen(InfImagen infImagen) {
		getInfImagens().remove(infImagen);
		infImagen.setInfInformacionGeneral(null);

		return infImagen;
	}
}