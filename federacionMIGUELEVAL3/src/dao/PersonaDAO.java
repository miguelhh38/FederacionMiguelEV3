package dao;

import java.lang.management.OperatingSystemMXBean;
import java.sql.Connection;
import java.util.Collection;

import javax.management.ObjectName;

import entidades.Atleta;
import entidades.DatosPersona;

public class PersonaDAO implements operacionesCRUD<DatosPersona> {
	Connection conex;

	public PersonaDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(DatosPersona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(DatosPersona elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DatosPersona buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<DatosPersona> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(DatosPersona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(DatosPersona elemento) {
		// TODO Auto-generated method stub
		return false;
	}


}
