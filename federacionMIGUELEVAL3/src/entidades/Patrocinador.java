package entidades;

import java.time.format.DateTimeFormatter;

public class Patrocinador {

	private long id;
	private String nombre;
	private String web;
	private double dotacion;

	private Responsable responsable;

	private int numeroPatrocinadores;

	public Patrocinador() {
		numeroPatrocinadores++;
		this.id = numeroPatrocinadores;
	}

	public Patrocinador(String nombre, double dotacion, String web, Responsable responsable) {
		this();
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		this.responsable = responsable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	public int getNumeroPatrocinadores() {
		return numeroPatrocinadores;
	}

	public void setNumeroPatrocinadores(int numeroPatrocinadores) {
		this.numeroPatrocinadores = numeroPatrocinadores;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + ", web=" + web + ", dotacion=" + dotacion + "]";
	}

	public String patrocinadorData() {
		return "" + this.id + "|" + this.responsable.getId() + "|" + this.nombre + "|" + this.dotacion + "|" + this.web;
	}

	public static Patrocinador nuevoPatrocinador() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String mostrarBasico() {
		String ret = "";
		ret += this.id + ". " + this.nombre + (!this.web.equals("") ? " " + web : " ");
		return ret;
	}

}
