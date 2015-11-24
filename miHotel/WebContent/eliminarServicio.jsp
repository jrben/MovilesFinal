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
		<h3>ELIMINAR SERVICIO</h3>
		<br> <br>
		<br> <br>
		<form action="EliminarServicio1" method="post">
					</select>
				<tr>
					<p>
					<th><h6>Servicios Disponibles:</h6></th>
					</p>
					<td><select name="comboServicio" size="1">
							<%
								List<TipoServicioVO> serv = (ArrayList<TipoServicioVO>) request.getAttribute("tiposervicio");
								for (int j = 0; j < serv.size(); j++) {
							%>
							<option value="<%=serv.get(j).getId_tipo_serv()%>"><%=serv.get(j).getTipo_serv()%></option>
					
					<%} %>
					</select>
									<button type="submit" name="botonElimiarServicio">Eliminar</button>
			</p>
		</form>
	</center>
	<jsp:include page="footer.jsp" />
</body>
</html>