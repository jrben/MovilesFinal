package Hotel.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hotel.modelo.servicio.ServicioReserva;
import Hotel.modelo.vo.ReservaVO;


@WebServlet("/VerReserva")
public class VerReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VerReserva() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ServicioReserva servicio = new ServicioReserva();
		
		List<ReservaVO> reserva = servicio.consultarReserva((int) session.getAttribute("id_cliente"));
		request.setAttribute("reserva", reserva);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/verReserva.jsp");
		rd.forward(request, response);

	}

}
