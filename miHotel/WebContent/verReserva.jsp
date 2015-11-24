<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<center>
		<h3>RESERVAS</h3>


		<h6>Mis Reservas:</h6>
		<br>
		<%
			    List<ReservaVO> reserva = (ArrayList<ReservaVO>) request.getAttribute("reserva");
		for (int i=0;i<reserva.size();i++)
		{	%>
			<div style="background-color:#F0F8FF"><br>						
<%-- 			<a href="VerReserva?id_reserva=<%=reserva.get(i).getId_reserva()%>">	
<table>													 --%>
			SU NUMERO DE RESERVA ES: <%=reserva.get(i).getId_reserva() %><br>
			DE: <%=reserva.get(i).getFecha_ingreso()%>
			HASTA: <%=reserva.get(i).getFecha_salida()%>
		</br>	
			</div>				
</table>			
		<%	}
	 %>
		</br>


		<form action="VerReserva" method="post"></form>

	</center>
</body>
</html>