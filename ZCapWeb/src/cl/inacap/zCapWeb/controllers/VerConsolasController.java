package cl.inacap.zCapWeb.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.zCapModel.dao.ConsolasDAO;
import cl.inacap.zCapModel.dto.Consola;

/**
 * Servlet implementation class VerConsolasController
 */
@WebServlet("/VerConsolasController.do")
public class VerConsolasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerConsolasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Me enviaron a eliminar algo?
		if(request.getParameter("nombreEliminar") != null) {
			String nombre = request.getParameter("nombreEliminar");
			ConsolasDAO dao = new ConsolasDAO();
			//1. Ir a buscar la consola a eliminar en el dao
			Consola consolaEliminada = dao.find(nombre);
			//2. Eliminar la consola
			dao.remove(consolaEliminada);
		}
		
		//1. Ir al DAO y traer la lista
		List<Consola> consolas = new ConsolasDAO().getAll();
		//2. Pasar la lista a la interfaz
		request.setAttribute("consolas", consolas);
		//3. Redirigir a la vista verConsolas.jsp
		request.getRequestDispatcher("WEB-INF/paginas/verConsolas.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
