package ymobilews.model.dao.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the inf_informacion database table.
 * 
 */
@Entity
@Table(name="inf_informacion")
@NamedQuery(name="InfInformacion.findAll", query="SELECT i FROM InfInformacion i")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InfInformacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="inf_codigo", length=5)
	@XmlElement(name="codigo")
	private String infCodigo;

	@Column(name="inf_descripcion", columnDefinition="text")
	@XmlElement(name="descripcion")
	private String infDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="inf_fecha")
	@XmlElement(name="fecha")
	private Date infFecha;

	@Column(name="inf_latitud", columnDefinition="text")
	@XmlElement(name="latitud")
	private String infLatitud;

	@Column(name="inf_longitud", columnDefinition="text")
	@XmlElement(name="longitud")
	private String infLongitud;
	
	@Column(name="inf_orden")
	@XmlElement(name="orden")
	private Integer infOrden;

	@Column(name="inf_titulo", length=150)
	@XmlElement(name="titulo")
	private String infTitulo;
	
	@Column(name="inf_url", columnDefinition="text")
	@XmlElement(name="url")
	private String infUrl;
	
	@Column(name="inf_estado", length=100)
	@XmlElement(name="estado")
	private String infEstado;
	
	//bi-directional many-to-one association to InfImagen
	@OneToMany(mappedBy="infInformacion", fetch = FetchType.EAGER)
	@XmlElement(name="imgs")
	private List<InfImagen> infImagens;
	
	//bi-directional many-to-one association to InfCategoria
	@ManyToOne
	@JoinColumn(name="cat_codigo")
	@XmlTransient
	private InfCategoria infCategoria;

	public InfInformacion() {
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

	public Date getInfFecha() {
		return this.infFecha;
	}

	public void setInfFecha(Date infFecha) {
		this.infFecha = infFecha;
	}

	public String getInfLatitud() {
		return this.infLatitud;
	}

	public void setInfLatitud(String infLatitud) {
		this.infLatitud = infLatitud;
	}

	public String getInfLongitud() {
		return this.infLongitud;
	}

	public void setInfLongitud(String infLongitud) {
		this.infLongitud = infLongitud;
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
	
	public String getInfUrl() {
		return this.infUrl;
	}

	public void setInfUrl(String infUrl) {
		this.infUrl = infUrl;
	}
	
	public List<InfImagen> getInfImagens() {
		return this.infImagens;
	}

	public void setInfImagens(List<InfImagen> infImagens) {
		this.infImagens = infImagens;
	}

	public InfImagen addInfImagen(InfImagen infImagen) {
		getInfImagens().add(infImagen);
		infImagen.setInfInformacion(this);

		return infImagen;
	}

	public InfImagen removeInfImagen(InfImagen infImagen) {
		getInfImagens().remove(infImagen);
		infImagen.setInfInformacion(null);

		return infImagen;
	}

	public InfCategoria getInfCategoria() {
		return this.infCategoria;
	}

	public void setInfCategoria(InfCategoria infCategoria) {
		this.infCategoria = infCategoria;
	}
	
	public String getInfEstado() {
		return this.infEstado;
	}

	public void setInfEstado(String infEstado) {
		this.infEstado = infEstado;
	}
}