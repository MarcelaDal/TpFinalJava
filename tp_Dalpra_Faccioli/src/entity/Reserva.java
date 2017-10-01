package entity;



import java.sql.Time;
import java.util.Date;

public class Reserva {
	private int id;
	private Date fecha;
	private Time hora;
	private String detalle;
<<<<<<< HEAD
	private Boolean estado;
=======
	private boolean estado;
>>>>>>> refs/remotes/origin/master
	private Persona persona;
	private Elemento elemento;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
<<<<<<< HEAD
	public Boolean getEstado() {
=======
	public boolean getEstado() {
>>>>>>> refs/remotes/origin/master
		return estado;
	}
<<<<<<< HEAD
	public void setEstado(Boolean estado) {
=======
	public void setEstado(boolean estado) {
>>>>>>> refs/remotes/origin/master
		this.estado = estado;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	
	
}
