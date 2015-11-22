 <%@ page import="Hotel.modelo.vo.*, java.util.*" %>
 <link href="CSS/estilos.css" media="all" rel="stylesheet" type="text/css" />
 <center>
    <h1 class="title">HOTEL</h1>
    <img src="./Imagenes/Hotel.bmp" alt="Hotel" />
 </center>
<%
						if (session.getAttribute("username") != null)
						{
							%>
							Bienvenido <%=session.getAttribute("username")%>
							Id <%=session.getAttribute("id_cliente")%>							
							<%
						}
					%> 
<div class="wrapper">
  <nav class="vertical">
    <ul>
      <li>
        <label for="home">Home</label>
        <input type="radio" name="verticalMenu" id="home" />
        <div>
          <ul>
            <li><a href="Home">Index</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </div>
      </li>
      <li>
        <label for="res">Reservas Habitacion</label>
        <input type="radio" name="verticalMenu" id="res" />
        <div>
          <ul>
            <li><a href="NuevaReserva">Nueva Reserva</a></li>
            <li><a href="#">Modificar Referva</a></li>
            <li><a href="#">Eliminar Reserva</a></li>
            <li><a href="#">Ver mis Reservas</a></li>
          </ul>
        </div>
      </li>
      <%if(session.getAttribute("mod")!=null){%>
      <li>
        <label for="blog">Servicios</label>
        <input type="radio" name="verticalMenu" id="blog" />
        <div>
          <ul>
          
            <li><a href="#">Nuevo Servicio</a></li>
            <li><a href="#">Eliminar Servicio</a></li>
          </ul>
        </div>
      </li>
      <%
      }
      %>
      <li>
        <label for="work">Cuenta</label>
        <input type="radio" name="verticalMenu" id="work" />
        
        <div>
          <ul>
          <%if(session.getAttribute("id_cliente")!=null){%>
    			<li><a href="CerrarSesion">Cerrar sesion</a></li>
    	<% } 
    	else{
    	%>    	
            <li><a href="registro.jsp">Registrarse</a></li>
	   		<li><a href="login.jsp">Iniciar Sesion</a></li>
	   		  	<% } %> 
          </ul>
        </div>
      </li>
    </ul>
  </nav>
</div>
