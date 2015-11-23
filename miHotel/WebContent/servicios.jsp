<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>

	<%@ include file="header.jsp"%>

	<center>
		<h3>NUEVO SERVICIO</h3>
		<br> <br> <br> <br>
		<form action="GuardarServicio" method="post">

			<table>
				<tr>

					<div class="left">
						<p>
							Tipo De Servicio: <input type="text" class="text"
								name="tipoServicio">

						</p>
					</div>
					<div class="left">
						<p>
							Precio Del Servicio: <input type="text" class="text"
								name="precioServicio">

						</p>
					</div>
					<p>
						<button type="submit" name="botonGuardarServicio">Guardar
							Servicio</button>
					</p>
				</tr>
			</table>
			<p></p>
		</form>
		<center>
</body>
</html>