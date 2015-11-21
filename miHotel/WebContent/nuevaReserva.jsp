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
		<h3>NUEVA RESERVA</h3>
		<br> <br>
		<h6>Ingrese los datos del Post:</h6>
		<br> <br>
		<form action="GuardarReserva" method="post">

<table>
			<tr>

				<div class="left">
					<p>
						Fecha de Ingreso: <input type="date" class="text" id="fechaingreso">
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
					<th>Descripción:</th>
					<td><textarea name="descripcion" rows="20" cols="60"></textarea>
					</td>
				</tr>
				<tr>
					<th>Categoria:</th>
					<td><select name="comboTipo">
							<%
								List<TipoHabitacionVO> tip = (ArrayList<TipoHabitacionVO>) request.getAttribute("tipos");
								for (int i = 0; i < tip.size(); i++) {
							%>
							<option value="<%=tip.get(i).getId_tipo()%>"><%=tip.get(i).getTipo()%></option>
							<%
								}
							%>
					</select></td>
				</tr>
			</table>

			<button type="submit" name="botonGuardarPost">Guardar</button>

		</form>
	</center>
	<jsp:include page="footer.jsp" />
</body>
</html>