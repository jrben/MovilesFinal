package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.modelo.servicio.ServicioTipoServicio;

/**
 * Servlet implementation class EliminarServicio1
 */
@WebServlet("/EliminarServicio1")
public class EliminarServicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarServicio1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioTipoServicio s = new ServicioTipoServicio();
		s.eliminarServicio(Integer.parseInt((String) request.getParameter("comboServicio")));
		
		request.setAttribute("mensaje", "Servicio eliminado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);
	}

}
