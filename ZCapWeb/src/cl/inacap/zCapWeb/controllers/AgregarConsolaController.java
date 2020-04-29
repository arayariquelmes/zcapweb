package cl.inacap.zCapWeb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.ConsolasDAO;
import cl.inacap.zCapModel.dto.Consola;

/**
 * Servlet implementation class AgregarConsolaController
 */
@WebServlet("/AgregarConsolaController.do")
public class AgregarConsolaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarConsolaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**Esto se llama al navegar en la página
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirigir la petición a la página destino
		request.getRequestDispatcher("WEB-INF/paginas/agregarConsola.jsp")
			.forward(request, response);
	}

	/** Esto se llama desde un formulario
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<String> errores = new ArrayList<String>();
		String nombre = request.getParameter("nombre-txt").trim();
		String marca = request.getParameter("marca-select").trim();
		String anioTxt = request.getParameter("anio-txt").trim();
		
		if(nombre.isEmpty()) {
			errores.add("Debe ingresar un nombre");
		}
		if(marca.isEmpty()) {
			errores.add("Debe seleccionar una marca");
		}
		int anio =0;
		try {
			anio = Integer.parseInt(anioTxt);
		}catch(Exception ex) {
			errores.add("El año debe ser numérico");
		}
		
		//Si no hay errores
		if(errores.isEmpty()) {
			Consola consola = new Consola();
			consola.setNombre(nombre);
			consola.setMarca(marca);
			consola.setAnio(anio);
			new ConsolasDAO().add(consola);
			//Con getParameter el Servlet recibe lo que manda la web
			//Con setAttribute el Servlet envia cosas a la web
			request.setAttribute("mensaje", "Consola agregada exitosamente");
		} else {
			request.setAttribute("errores", errores);
		}
		
		request.getRequestDispatcher("WEB-INF/paginas/agregarConsola.jsp").forward(request,response);
		
	}

}
