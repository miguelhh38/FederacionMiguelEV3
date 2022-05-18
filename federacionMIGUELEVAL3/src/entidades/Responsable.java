package entidades;

import java.time.LocalTime;

import utils.Datos;

public class Responsable {

	private long id;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;

	private DatosPersona persona;

	private int numeroResponsables;

	public Responsable() {
		numeroResponsables++;
		this.id = numeroResponsables;
	}

//	public Responsable(String telefonoProf, LocalTime horarioIni, LocalTime horarioFin) {
//		super();
//		this.telefonoProf = telefonoProf;
//		this.horarioIni = horarioIni;
//		this.horarioFin = horarioFin;
//		this.persona = Datos.buscarPersonaPorId(id);
//	}

	public Responsable(String telefonoProf, LocalTime horarioIni, LocalTime horarioFin, DatosPersona dp) {
		this();
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.persona = dp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalTime getHorarioIni() {
		return horarioIni;
	}

	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}

	public int getNumeroResponsables() {
		return numeroResponsables;
	}

	public void setNumeroResponsables(int numeroResponsables) {
		this.numeroResponsables = numeroResponsables;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}
	
	

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Responsable [id=" + id + ", telefonoProf=" + telefonoProf + ", horarioIni=" + horarioIni
				+ ", horarioFin=" + horarioFin + ", numeroResponsables=" + numeroResponsables + "]";
	}

	/**
	 * Metodo Data -> Ejercicio 4
	 */

	public String responsableData() {
		return "" + this.id + "|" + persona.getId() + "|" + this.telefonoProf + "|" + this.getHorarioIni().toString()
				+ "|" + this.getHorarioFin().toString();

	}

}
