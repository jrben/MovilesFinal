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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);	
		
		ServicioCliente servicio = new ServicioCliente();
		ClienteVO cliente = new ClienteVO();		

		cliente.setUsername(request.getParameter("username"));		
		
		
		int id_cliente=1;//servicio.permitirIngreso(request.getParameter("username"),request.getParameter("password"));
		//si los datos ingresados son correctos
		if(id_cliente>0){
			session.setAttribute("username", cliente.getUsername());
			session.setAttribute("id_cliente", id_cliente);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home");
			rd.forward(request, response);
		}
		//si los datos ingresados son incorrectos
		else
		{
			request.setAttribute("error","ERROR<br>Los datos ingresados son incorrectos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
		}

}
