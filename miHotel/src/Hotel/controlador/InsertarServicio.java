package Hotel.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertarServicio")
public class InsertarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertarServicio() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/servicios.jsp");
		rd.forward(request, response);

	}

}
