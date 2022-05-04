package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import entidades.Metal;
import utils.ConexBD;

public class MetalesDAO implements operacionesCRUD<Metal> {

	Connection conex;

	public MetalesDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Metal m) {
		boolean ret = false; 
		
		
		String consultaInsert = "insert into metales(idMetal, idTipoMetal, pureza, es_oro, es_plata, es_bronce) values (?,?,?,?,?,?)";
	
		
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsert);
			pstmt.setLsetLong(1, Long.valueOf(m.idMetal));
			pstmt.setString(2, a.getPersona().getNombre());
			pstmt.setString(3, a.getPersona().getTelefono());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(a.getPersona().getFechaNac());
			pstmt.setDate(4, fechaSQL);
			pstmt.setString(5, a.getPersona().getNifnie().mostrar());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr3);
				pstmt2.setLong(1, a.getId());
				pstmt2.setFloat(2, a.getAltura());
				pstmt2.setFloat(3, a.getPeso());
				pstmt2.setNull(4, java.sql.Types.INTEGER);
				pstmt2.setLong(5, a.getPersona().getId());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Atleta.");
					ret = true;
				}
				if (conex != null)
					conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;
	}
		return false;
	}

	@Override
	public long insertarSinID(Metal elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Metal buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Metal> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Metal elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Metal elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
