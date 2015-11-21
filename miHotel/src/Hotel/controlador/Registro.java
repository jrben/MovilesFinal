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

import Hotel.modelo.vo.ClienteVO;
import Hotel.modelo.servicio.*;


@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Registro() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioCliente servicioCliente = new ServicioCliente();
		
		ClienteVO cliente = new ClienteVO();
		
		cliente.setNombre(request.getParameter("nombre"));
		cliente.setUsername(request.getParameter("username"));
		cliente.setPassword(request.getParameter("password"));
		
		String password2 = request.getParameter("password2");
		
		if (!servicioCliente.comprobarCliente(cliente) && password2.equals(cliente.getPassword())){
			servicioCliente.registrarCliente(cliente);
			request.setAttribute("informacion", "Usuario registrado");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("informacion", "Error");
			request.setAttribute("cliente", cliente);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
			rd.forward(request, response);
		}
		
		/*ClienteVO cliente = new ClienteVO();
		if(request.getParameter("nombre").equals("")||request.getParameter("username").equals("") || request.getParameter("password1").equals("")){
			request.setAttribute("error","ERROR<br>Debe llenar todos los campos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
			rd.forward(request, response);
		}
		else{
			if(request.getParameter("password1").equals(request.getParameter("password2"))){ // comprueba si las contraseñas son iguales
				cliente.setUsername(request.getParameter("username"));
				cliente.setPassword(request.getParameter("password1"));
				cliente.setNombre(request.getParameter("nombre"));
				ServicioCliente s = new ServicioCliente();
				
				if(s!=null){ // si se ingreso el usuario a la bd
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}
				else{ // si no se ingreso porque ya existe el mismo username con otro usuario
					request.setAttribute("error","ERROR<br>Ya existe otro usuario con el mismo username");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
					rd.forward(request, response);
				}
			}
			else{//contraseñas 1 y 2 no coinciden
				request.setAttribute("error","ERROR<br>Las contraseñas ingresadas no coinciden");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registro.jsp");
				rd.forward(request, response);
			}
		}*/
		
		
	}

}


/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		ServicioCliente servicio = new ServicioCliente();
		ClienteVO cliente = new ClienteVO();
		
		cliente.setUsername(request.getParameter("username"));
		cliente.setPassword(request.getParameter("password"));
		cliente=servicio.permitirIngreso(cliente);
		
		
		//v
		
		if (cliente.getId_cliente() != null)
		{
			session.setAttribute("username", cliente.getUsername());
			session.setAttribute("id_cliente", cliente.getId_cliente());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request,response);
		}
		else
		{			
			request.setAttribute("error", "datos inválidos");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/registro.jsp");
			rd.forward(request, response);
		}
		
	}

}*/
