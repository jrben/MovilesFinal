package Hotel.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.modelo.servicio.ServicioTipo;
import Hotel.modelo.servicio.ServicioTipoServicio;
import Hotel.modelo.vo.TipoHabitacionVO;
import Hotel.modelo.vo.TipoServicioVO;

@WebServlet("/NuevaReserva")
public class NuevaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NuevaReserva() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicioTipo servicio = new ServicioTipo();
		List<TipoHabitacionVO> listaTipos=servicio.listarTipos();
		request.setAttribute("tipos", listaTipos);
		
		ServicioTipoServicio servic= new ServicioTipoServicio();
		List<TipoServicioVO> listaTipoServicio=servic.listarTipoServicio();
		request.setAttribute("tiposervicio", listaTipoServicio);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevaReserva.jsp");
		rd.forward(request, response);

	}

}
