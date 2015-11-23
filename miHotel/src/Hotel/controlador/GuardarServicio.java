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
 * Servlet implementation class GuardarServicio
 */
@WebServlet("/GuardarServicio")
public class GuardarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarServicio() {
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
		ServicioTipoServicio servicio = new ServicioTipoServicio();
		String nombre=request.getParameter("tipoServicio");
		String precio=request.getParameter("precioServicio");
		servicio.ingresarServicio(nombre, precio);
		
		request.setAttribute("mensaje", "Servicio ingresado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);
		
	}

}
