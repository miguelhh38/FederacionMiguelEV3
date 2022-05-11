package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Equipo;
import utils.ConexBD;

public class EquiposDAO implements operacionesCRUD<Equipo> {
	Connection conex;

	public EquiposDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Equipo eq) {
		boolean ret = false;

	/*	String consultaInsertStr1 = "insert into equipos(id_equipo, nombre, anioinscripcion, id_manager) values (?,?,?,?)";
		String consultaInsertStr2 = "insert into atletas(id, altura, peso, idequipo, idpersona) values (?,?,?,?,?)";
		
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			
			pstmt.setLong(1, eq.getId());
			pstmt.setString(2, eq.getNombre());
			pstmt.setInt(3, eq.getAnioinscripcion());
			pstmt.setLong(4, eq.getManager().getId());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr2);
				pstmt2.setLong(1, eq.getId());
				pstmt2.setFloat(2, eq.getAtletas().get);
				pstmt2.setFloat(3, a.getPeso());
				pstmt2.setNull(4, java.sql.Types.INTEGER);
				pstmt2.setLong(5, a.getPersona().getId());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente al Atleta el equipo");
					ret = true;
				}
				if (conex != null)
					conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
	*/	

		return ret;
	}

	@Override
	public long insertarSinID(Equipo elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Equipo buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Equipo> buscarTodos() {
		List<Equipo> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM equipos";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Equipo equipo;
				long idBD = result.getLong("id_equipo");
				String nom = result.getString("nombre");
				int anios = result.getInt("anios_experiencia");
				equipo = new Equipo();
				equipo.setId(idBD);
				equipo.setNombre(nom);
				equipo.setAnioinscripcion(anios);
				
				todos.add(equipo);
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
	
		return todos;
	}

	@Override
	public boolean modificar(Equipo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Equipo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
