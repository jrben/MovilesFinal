<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Hotel.modelo.vo.*, java.util.*"%>
<%@ page import="Hotel.controlador.*"%>
<%@ page import="Hotel.modelo.servicio.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<center>
		<h3>NUEVA RESERVA</h3>
		<br> <br>
		<h6>Complete su reservacion:</h6>
		<br> <br>
		<form action="GuardarReserva" method="post">

			<table>
				<tr>

					<div class="left">
						<p>
							Fecha de Ingreso: <input type="date" class="text"
								id="fechaingreso">
						</p>
					</div>
				</tr>
				<tr>

					<div class="left">
						<p>
							Fecha de Salida: <input type="date" class="text" id="fechasalida">
						</p>
					</div>
				</tr>

				<tr>
					<td><h6>Precio de su reservacion:</h6><input type="text" name="precio"> </textarea>
					</td>
				</tr>
				<tr>
					<th><h6>Tipo de Habitacion</h6></th>
					<td><select name="comboTipo" size="1" id="comboTipo">
							<%
								List<TipoHabitacionVO> tip = (ArrayList<TipoHabitacionVO>) request.getAttribute("tipos");
								for (int i = 0; i < tip.size(); i++) {
							%>
							<option value="<%=tip.get(i).getId_tipo()%>"><%=tip.get(i).getTipo()%></option>
							<%
								}
							%>
					</select>
					<th><h6>Servicios Disponibles:</h6></th>
					<td><select name="comboServicio" size="1" id="comboServicio">
							<%
								List<TipoServicioVO> serv = (ArrayList<TipoServicioVO>) request.getAttribute("servicios");
								for (int i = 0; i < tip.size(); i++) {
							%>
							<option value="<%=serv.get(i).g%>"><%=serv.get(i).getTipo()%></option>
							<%
								}
							%>
					</select>
				</tr>
			</table>

			<button type="submit" name="botonGuardarReserva	">Guardar</button>

		</form>
	</center>
	<jsp:include page="footer.jsp" />
</body>
</html>