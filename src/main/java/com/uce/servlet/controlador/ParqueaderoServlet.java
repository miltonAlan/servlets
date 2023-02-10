package com.uce.servlet.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.uce.servlet.dao.ParqueaderoDAO;
import com.uce.servlet.modelo.Parqueadero;

@WebServlet("/ParqueaderoNameServlet")
public class ParqueaderoServlet extends HttpServlet {
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
			parqueaderoDAO.registroParqueadero(parqueadero);
			// probar si vale este mensaje
			request.setAttribute("msg", "Usuario registrado con ecsito");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ingresoParqueaderos.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1>LISTA DE PARQUEADEROS REGISTRADOS EN LA TABLA 'lugar_parqueadero' sis hetero patriarcal</h1>");
		out.println("<table border=1 width=50% height=50%>");
		out.println("<tr><th>Nombre Usuario</th><th>Tipo Vehiculo</th><th>Tiempo</th><tr>");
		List<Parqueadero> listaParqueaderos = new ParqueaderoDAO().consultaParqueaderos();
		for (Parqueadero parqueadero : listaParqueaderos) {
			out.println("<tr><td>" + parqueadero.getNombre_usuario() + "</td><td>" + parqueadero.getTipo_vehiculo()
					+ "</td><td>" + parqueadero.getTiempo() + "</td></tr>");
		}
		out.println("</table>");
		out.println("<button onclick=\"history.back()\">Volver</button>");
		out.println("</html></body>");
	}
}
