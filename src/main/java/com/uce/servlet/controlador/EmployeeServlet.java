package com.uce.servlet.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.uce.servlet.dao.ParqueaderoDAO;
import com.uce.servlet.modelo.Parqueadero;

@WebServlet("/EmployeeServletUsed")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParqueaderoDAO parqueaderoDAO;

	public void init() {
		parqueaderoDAO = new ParqueaderoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setNombre_usuario(request.getParameter("nombre_usuario"));
		parqueadero.setTipo_vehiculo(request.getParameter("tipo_vehiculo"));
		parqueadero.setTiempo(request.getParameter("tiempo"));
		parqueadero.setPlaca(request.getParameter("placa"));
		parqueadero.setColor(request.getParameter("color"));
		parqueadero.setMarca(request.getParameter("marca"));
		parqueadero.setDescripcion_adicional(request.getParameter("descripcion_adicional"));

		try {
			parqueaderoDAO.registerEmployee(parqueadero);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listaParqueaderos.jsp");
	}
}