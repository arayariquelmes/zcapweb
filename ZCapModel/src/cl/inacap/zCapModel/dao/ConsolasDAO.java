package cl.inacap.zCapModel.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.zCapModel.dto.Consola;

public class ConsolasDAO {

	private static List<Consola> consolas = new ArrayList<Consola>();
	public void add(Consola consola) {
		consolas.add(consola);
	}
	public List<Consola> getAll(){
		return consolas;
	}
	
	public Consola find(String nombre) {
//		Consola buscada = null;
//		
//		for(Consola c:consolas) { //for extendido
//			if(c.getNombre().equals(nombre)) {
//				buscada = c;
//				break;
//			}
//		}
//		return buscada;                  Expresion lambda
		return consolas.stream().filter(c->c.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	public void remove(Consola consola) {
		consolas.remove(consola);
	}
}
