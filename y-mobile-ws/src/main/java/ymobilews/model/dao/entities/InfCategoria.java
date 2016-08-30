package ymobilews.model.dao.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the inf_categoria database table.
 * 
 */
@Entity
@Table(name="inf_categoria")
@NamedQuery(name="InfCategoria.findAll", query="SELECT i FROM InfCategoria i")
@XmlRootElement
public class InfCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cat_codigo", length=5)
	@XmlElement(name="codigo")
	private String catCodigo;

	@Column(name="cat_descripcion", length=50)
	@XmlElement(name="descripcion")
	private String catDescripcion;

	@Column(name="cat_icon", columnDefinition="text")
	@XmlElement(name="icon")
	private String catIcon;
	
	@Column(name="cat_orden")
	@XmlElement(name="orden")
	private Integer catOrden;

	@Column(name="cat_titulo", length=50)
	@XmlElement(name="titulo")
	private String catTitulo;
	
	@Column(name="cat_estado", length=100)
	@XmlElement(name="estado")
	private String catEstado;

	//bi-directional many-to-one association to InfInformacion
	@OneToMany(mappedBy="infCategoria", fetch = FetchType.EAGER)
	@XmlElement(name="informacion")
	private List<InfInformacion> infInformacions;

	public InfCategoria() {
	}

	public String getCatCodigo() {
		return this.catCodigo;
	}

	public void setCatCodigo(String catCodigo) {
		this.catCodigo = catCodigo;
	}

	public String getCatDescripcion() {
		return this.catDescripcion;
	}

	public void setCatDescripcion(String catDescripcion) {
		this.catDescripcion = catDescripcion;
	}

	public String getCatIcon() {
		return this.catIcon;
	}

	public void setCatIcon(String catIcon) {
		this.catIcon = catIcon;
	}

	public Integer getCatOrden() {
		return this.catOrden;
	}

	public void setCatOrden(Integer catOrden) {
		this.catOrden = catOrden;
	}
	
	public String getCatTitulo() {
		return this.catTitulo;
	}

	public void setCatTitulo(String catTitulo) {
		this.catTitulo = catTitulo;
	}
	
	public String getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(String catEstado) {
		this.catEstado = catEstado;
	}

	public List<InfInformacion> getInfInformacions() {
		return this.infInformacions;
	}

	public void setInfInformacions(List<InfInformacion> infInformacions) {
		this.infInformacions = infInformacions;
	}

	public InfInformacion addInfInformacion(InfInformacion infInformacion) {
		getInfInformacions().add(infInformacion);
		infInformacion.setInfCategoria(this);

		return infInformacion;
	}

	public InfInformacion removeInfInformacion(InfInformacion infInformacion) {
		getInfInformacions().remove(infInformacion);
		infInformacion.setInfCategoria(null);

		return infInformacion;
	}

}