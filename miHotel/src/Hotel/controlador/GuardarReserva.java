package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.modelo.servicio.ServicioCliente;
import Hotel.modelo.servicio.ServicioReserva;
import Hotel.modelo.vo.ClienteVO;
import Hotel.modelo.vo.ReservaVO;


@WebServlet("/GuardarReserva")
public class GuardarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GuardarReserva() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioReserva servicioReserva = new ServicioReserva();
		
		ReservaVO reserva = new ReservaVO();
		
		reserva.setFecha_ingreso(request.getParameter("fecha_ingreso"));
		reserva.setFecha_salida(request.getParameter("fecha_salida"));
		reserva.setPrecio_reserva(request.getParameter("precio_reserva"));
		servicioReserva.registrarReserva(reserva);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
			rd.forward(request, response);


	}

}
