package cl.inacap.zCapModel.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Juego {

	private String nombre;
	private String descripcion;
	private Consola consola;
	private boolean esAptoNinios;
	private int precio;
	private LocalDate fecha;
	
	public String getFechaTexto() {
		return this.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Consola getConsola() {
		return consola;
	}
	public void setConsola(Consola consola) {
		this.consola = consola;
	}
	public boolean isEsAptoNinios() {
		return esAptoNinios;
	}
	public void setEsAptoNinios(boolean esAptoNinios) {
		this.esAptoNinios = esAptoNinios;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
