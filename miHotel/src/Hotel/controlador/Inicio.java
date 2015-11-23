package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hotel.modelo.servicio.ServicioCliente;
import Hotel.modelo.vo.ClienteVO;

@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Inicio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		ClienteVO c = new ClienteVO();
		String usr=request.getParameter("username");
		String psw=request.getParameter("password");
		
		ServicioCliente servicio = new ServicioCliente();
		ClienteVO cliente = servicio.inicioSesion(usr,psw);

//		cliente.setId_cliente(request.getParameter("id_cliente"));
		// int id_cliente2 = Integer.valueOf((String)
		// (session.getAttribute("id_cliente")));
//		int id_cliente = (int) session.setAttribute("id_cliente", cliente);// servicio.permitirIngreso(request.getParameter("username"),request.getParameter("password"));
		// si los datos ingresados son correctos
		if (cliente.getId_cliente()>0) {
			session.setAttribute("username", cliente.getUsername());
			session.setAttribute("id_cliente", cliente.getId_cliente());
			session.setAttribute("admin",cliente.getAdmin());
			System.out.println("ADMIN: "+cliente.getAdmin());

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home");
			rd.forward(request, response);
		}
		// si los datos ingresados son incorrectos
		else {
			request.setAttribute("error", "ERROR<br>Los datos ingresados son incorrectos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

}
