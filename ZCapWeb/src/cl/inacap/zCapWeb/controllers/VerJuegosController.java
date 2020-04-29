package cl.inacap.zCapWeb.controllers;

import java.io.IOException;
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
 * Servlet implementation class VerJuegosController
 */
@WebServlet("/VerJuegosController.do")
public class VerJuegosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private JuegosDAO juegosDAO = new JuegosDAO();
    private ConsolasDAO consolasDAO = new ConsolasDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerJuegosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Juego> juegos = this.juegosDAO.getAll();
		List<Consola> consolas = this.consolasDAO.getAll();
		request.setAttribute("juegos", juegos);
		request.setAttribute("consolas", consolas);
		request.getRequestDispatcher("WEB-INF/paginas/verJuegos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Consola> consolas = this.consolasDAO.getAll();
		request.setAttribute("consolas", consolas);
		
		List<Juego> juegos = null;
		if(request.getParameter("filtrar-cbx") != null) {
			String nombreConsola = request.getParameter("filtrar-cbx").trim();
			juegos = this.juegosDAO.findByConsola(nombreConsola);
			request.setAttribute("consolaSeleccionada", nombreConsola);
		} else {
			juegos = this.juegosDAO.getAll();
		}
		
		request.setAttribute("juegos", juegos);
	
		request.getRequestDispatcher("WEB-INF/paginas/verJuegos.jsp").forward(request, response);
	
	}

}
