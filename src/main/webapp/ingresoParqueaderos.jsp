<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PARQUEADEROS</title>
</head>
<body>
	<div align="center">
		<h1>Registro Parqueadero</h1>
		<form action="<%=request.getContextPath()%>/EmployeeServletUsed"
			method="post" onsubmit="return validateForm()">
			<table style="with: 80%">
				<tr>
					<td>Nombre Usuario</td>
					<td><input type="text" name="nombre_usuario" /></td>
				</tr>
				<tr>
					<td>Tipo Vehículo</td>
					<td><input type="text" name="tipo_vehiculo" /></td>
				</tr>
				<tr>
					<td>Tiempo</td>
					<td><input type="text" name="tiempo" /></td>
				</tr>
				<tr>
					<td>Placa</td>
					<td><input type="password" name="placa" /></td>
				</tr>
				<tr>
					<td>Color</td>
					<td><input type="text" name="color" /></td>
				</tr>
				<tr>
					<td>Marca</td>
					<td><input type="text" name="marca" /></td>
				</tr>
				<tr>
					<td>Descripcion Adicional</td>
					<td><input type="text" name="descripcion_adicional" /></td>
				</tr>
			</table>
			<input type="submit" value="Registrar Parqueadero" />
		</form>
	</div>
</body>
</html>