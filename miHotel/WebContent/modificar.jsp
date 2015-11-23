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
		<h3>MODIFICAR RESERVA</h3>
		<br> <br>
		<h6>Modifique su reservacion:</h6>
		<br> <br>
		<form action="ModificarReserva" method="post">

			<table>
				<tr>

					<div class="left">
						<p>
							Fecha de Ingreso: <input type="date" class="text"
								name="fechaingreso">
							<input type="hidden" name="iddd" value="<%=session.getAttribute("id_cliente")%>">
								
						</p>
					</div>
				</tr>
				<tr>

					<div class="left">
						<p>
							Fecha de Salida: <input type="date" class="text" name="fechasalida">
						</p>
					</div>
				</tr>

				<tr>
					<p>
					<th><h6>Tipo de Habitacion:</h6></th>
					</p>
					<td><select name="comboTipo" size="1" id="comboTipo"
						onchange="funcionHabitacion()">
							<%
								List<TipoHabitacionVO> tip = (ArrayList<TipoHabitacionVO>) request.getAttribute("tipos");
								for (int i = 0; i < tip.size(); i++) {
							%>
							
							<option value="<%=tip.get(i).getPrecio_tipo()%>"><%=tip.get(i).getTipo()%></option>
							
							<%
								}
							%>
					</select>
				<tr>
					<p>
					<th><h6>Servicios Disponibles:</h6></th>
					</p>
					<td><select name="comboServicio" size="1" name="comboServicio" id="comboServicio"
						onchange="funcionTipoServicio()">
							<%
								List<TipoServicioVO> serv = (ArrayList<TipoServicioVO>) request.getAttribute("tiposervicio");
								for (int j = 0; j < serv.size(); j++) {
							%>
							<option value="<%=serv.get(j).getPrecio_serv()%>"><%=serv.get(j).getTipo_serv()%></option>
					
					<%} %>
					</select>
				<tr>
					
					<p id="demo"></p>
					<script>
						function funcionTipoServicio() {
							var x = document.getElementById("comboServicio").value;
							document.getElementById("demo").innerHTML = "Precio Servicio: "
									+ x;
						}
					</script>
				<tr>
					<p id="demo1"></p>
					<script>
						function funcionHabitacion() {
							var y = document.getElementById("comboTipo").value;
							document.getElementById("demo1").innerHTML = "Precio Habitacion: "
									+ y;
						}
					</script>

				</tr>
				
			</table>

			<tr>
				
			</tr>
			<p>
				<button type="submit" name="botonGuardarReserva	">Guardar Cambios</button>
			</p>
		</form>
	</center>
	<jsp:include page="footer.jsp" />
</body>
</html>