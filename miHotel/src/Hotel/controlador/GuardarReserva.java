package Hotel.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hotel.modelo.servicio.ServicioCliente;
import Hotel.modelo.servicio.ServicioReserva;
import Hotel.modelo.servicio.ServicioTipo;
import Hotel.modelo.servicio.ServicioTipoServicio;
import Hotel.modelo.vo.ClienteVO;
import Hotel.modelo.vo.ReservaVO;



@WebServlet("/GuardarReserva")
public class GuardarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GuardarReserva() {
        super();

    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entra al Servlet");
		HttpSession session = request.getSession(true);

		ReservaVO reserva = new ReservaVO();
		
		String fechai=request.getParameter("fechaingreso");
		reserva.setFecha_ingreso(fechai);
		
		String fechas=request.getParameter("fechasalida");
		reserva.setFecha_salida(fechas);

		
		reserva.setId_cliente(Integer.parseInt(request.getParameter("iddd")));
//		reserva.set
		
		int precioHabitacion= (int)(Double.parseDouble(request.getParameter("comboTipo")));
		ServicioTipo s = new ServicioTipo();
		int idH=s.obtenerId(precioHabitacion);
		reserva.setId_tipo(idH);
		System.out.println("EL id de servico en servlet es : "+idH);	
		
		int precioServicio= (int)(Double.parseDouble(request.getParameter("comboServicio")));
		ServicioTipoServicio ss=new ServicioTipoServicio();
		int idS=ss.obtenerId(precioServicio);
		reserva.setId_tipo_serv(idS);
		System.out.println("33333");
		System.out.println("EL id de servico en servlet es : "+idS);
		
		int suma=precioHabitacion+precioServicio;
		reserva.setPrecio_reserva(String.valueOf(suma));		
		System.out.println("4444");
		System.out.println("Id de servicio es: " +reserva.getId_tipo_serv());

		ServicioReserva servicio = new ServicioReserva();
		servicio.registrarReserva(reserva);
		System.out.println("44444");
	
		request.setAttribute("mensaje", "Reserva ingresado exitosamente!");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensaje.jsp");
		rd.forward(request, response);


	}

}
