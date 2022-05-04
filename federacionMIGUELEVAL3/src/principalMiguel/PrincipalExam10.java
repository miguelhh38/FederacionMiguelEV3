package principalMiguel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.util.ArrayList;
import utils.*;
import entidades.*;

public class PrincipalExam10 {

	public static void main(String[] args) {
		Responsable r1 = new Responsable("902422202", java.time.LocalTime.of(0, 0), java.time.LocalTime.of(23, 59),
				Datos.buscarPersonaPorId(1011));
		Responsable r2 = new Responsable("985185503", java.time.LocalTime.of(9, 0), java.time.LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Responsable r3 = new Responsable("985103000", java.time.LocalTime.of(8, 30), java.time.LocalTime.of(20, 00),
				Datos.buscarPersonaPorId(1013));
		Responsable r4 = new Responsable("985185503", java.time.LocalTime.of(8, 30), java.time.LocalTime.of(18, 0),
				Datos.buscarPersonaPorId(1014));

		Patrocinador patrocinador1 = new Patrocinador("ALSA", 500.00, "www.alsa.es", r1);
		Patrocinador patrocinador2 = new Patrocinador("Ayto. Gijón", 250.00, "www.gijon.es", r2);
		Patrocinador patrocinador3 = new Patrocinador("Universidade de Oviedo", 350.00, "www.uniovi.es", r3);
		Patrocinador patrocinador4 = new Patrocinador("CIFP La Laboral", 255.99, "www.cifplalaboral.es", r4);

		ArrayList<Patrocinador> listaPatrocinadores = new ArrayList<Patrocinador>();
		listaPatrocinadores.add(patrocinador1);
		listaPatrocinadores.add(patrocinador2);
		listaPatrocinadores.add(patrocinador3);
		listaPatrocinadores.add(patrocinador4);
	}

	public static void insertarPatrocinador() {
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr1 = "insert into patrocinadores(id, nombre, dotacion, web) values (?, ?, ";
	}
	
	
}
