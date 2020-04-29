package cl.inacap.zCapWeb.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.ConsolasDAO;
import cl.inacap.zCapModel.dao.JuegosDAO;
import cl.inacap.zCapModel.dto.Consola;
import cl.inacap.zCapModel.dto.Juego;

/**
 * Servlet implementation class AgregarJuegoController
 */
@WebServlet("/AgregarJuegoController.do")
public class AgregarJuegoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConsolasDAO consolasDAO = new ConsolasDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarJuegoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Consola> consolas = this.consolasDAO.getAll();
		request.setAttribute("consolas", consolas);
		request.getRequestDispatcher("WEB-INF/paginas/agregarJuego.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre-txt").trim();
		String descripcion = request.getParameter("descripcion-txt").trim();
		String consolaText = request.getParameter("consola-cbx");
		String apto = request.getParameter("apto-rb");
		String precioTxt = request.getParameter("precio-txt").trim();
		String fechaTxt = request.getParameter("fecha-txt").trim();
		
		List<String> errores = new ArrayList<String>();
		
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar nombre");
		}
		if(descripcion.isEmpty()) {
			errores.add("Debe ingresar descripción");
		}
		if(consolaText == null) {
			errores.add("Debe seleccionar consola");
		}
		
		
		boolean aptoBol = apto.equals("si");
		int precio=0;
		try {
			precio = Integer.parseInt(precioTxt);
		}catch(Exception ex) {
			errores.add("Debe ingresar precio");
		}
		
		LocalDate fecha=null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			fecha = LocalDate.parse(fechaTxt, dtf);
		}catch(Exception ex) {
			errores.add("Debe ingresar fecha válida");
		}
		
		if(errores.isEmpty()) {
			
			Juego juego = new Juego();
			Consola consolaSel = this.consolasDAO.find(consolaText);
			juego.setNombre(nombre);
			juego.setConsola(consolaSel);
			juego.setDescripcion(descripcion);
			juego.setEsAptoNinios(aptoBol);
			juego.setFecha(fecha);
			juego.setPrecio(precio);
			
			new JuegosDAO().add(juego);
			response.sendRedirect("VerJuegosController.do");
			
		}else {
			request.setAttribute("errores", errores);
			doGet(request, response);
		}
		
		
		
		
		
	}

}
