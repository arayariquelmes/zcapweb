package cl.inacap.zCapModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cl.inacap.zCapModel.dto.Juego;

public class JuegosDAO {

	private static List<Juego> juegos = new ArrayList<Juego>();
	
	public void add(Juego juego) {
		juegos.add(juego);
	}
	public List<Juego> getAll(){
		return juegos;
	}
	
	public List<Juego> findByConsola(String nombreConsola){
		return juegos.stream().filter(j->j.getConsola().getNombre().equals(nombreConsola))
				.collect(Collectors.toList());
	}
	public Juego find(String nombre) {
		return juegos.stream().filter(j->j.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	public void delete(Juego juego) {
		juegos.remove(juego);
	}
}
