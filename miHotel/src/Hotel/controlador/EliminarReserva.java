package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.modelo.servicio.ServicioTipoServicio;

@WebServlet("/EliminarReserva")
public class EliminarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminarReserva() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioTipoServicio s = new ServicioTipoServicio();
		s.eliminarServicio(Integer.parseInt((String) request.getParameter("comboServicio")));
		
		request.setAttribute("mensaje", "Servicio eliminado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);

	}

}
