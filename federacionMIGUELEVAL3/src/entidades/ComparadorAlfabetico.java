package entidades;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Datos;

public class ComparadorAlfabetico implements Comparator<DatosPersona> {

	@Override
	public int compare(DatosPersona o1, DatosPersona o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}
	
	public void nombresOrdenados(String o1, String o2) {
		LinkedList<DatosPersona> ret = new LinkedList<DatosPersona>();
		for (DatosPersona d : Datos.PERSONAS) {
			ret.add(d);
		}
		
		Collections.sort(ret, new ComparadorAlfabetico());
		System.out.println("La lista ordenada de todas las medallas es:");
		Iterator<DatosPersona> it = ret.iterator();
		
		
			
	}
	
}




