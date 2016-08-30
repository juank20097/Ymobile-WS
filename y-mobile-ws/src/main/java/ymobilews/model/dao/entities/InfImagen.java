package ymobilews.model.dao.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the inf_imagen database table.
 * 
 */
@Entity
@Table(name="inf_imagen")
@NamedQuery(name="InfImagen.findAll", query="SELECT i FROM InfImagen i")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InfImagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ima_codigo", length=150)
	@XmlElement(name="codigo")
	private String imaCodigo;

	@Column(name="ima_direccion", columnDefinition="text")
	@XmlElement(name="url")
	private String imaDireccion;

	@Column(name="ima_nombre", columnDefinition="text")
	@XmlElement(name="nombre")
	private String imaNombre;

	//bi-directional many-to-one association to InfInformacion
	@ManyToOne
	@JoinColumn(name="inf_codigo")
	@XmlTransient
	private InfInformacion infInformacion;

	//bi-directional many-to-one association to InfInformacionGeneral
	@ManyToOne
	@JoinColumn(name="inf_codigo_gen")
	@XmlTransient
	private InfInformacionGeneral infInformacionGeneral;

	public InfImagen() {
	}

	public String getImaCodigo() {
		return this.imaCodigo;
	}

	public void setImaCodigo(String imaCodigo) {
		this.imaCodigo = imaCodigo;
	}

	public String getImaDireccion() {
		return this.imaDireccion;
	}

	public void setImaDireccion(String imaDireccion) {
		this.imaDireccion = imaDireccion;
	}

	public String getImaNombre() {
		return this.imaNombre;
	}

	public void setImaNombre(String imaNombre) {
		this.imaNombre = imaNombre;
	}

	public InfInformacion getInfInformacion() {
		return this.infInformacion;
	}

	public void setInfInformacion(InfInformacion infInformacion) {
		this.infInformacion = infInformacion;
	}

	public InfInformacionGeneral getInfInformacionGeneral() {
		return this.infInformacionGeneral;
	}

	public void setInfInformacionGeneral(InfInformacionGeneral infInformacionGeneral) {
		this.infInformacionGeneral = infInformacionGeneral;
	}

}