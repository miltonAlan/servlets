package com.uce.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uce.servlet.modelo.Parqueadero;

public class ParqueaderoDAO extends Conecsion {
	private Connection con = null;

	public int registroParqueadero(Parqueadero parqueadero) throws SQLException {
		String insert_parqueadero = "insert into lugar_parqueadero"
				+ "(nombre_usuario, tipo_vehiculo, tiempo, placa, color, marca, descripcion_adicional)"
				+ "values (?,?,?,?,?,?,?)";

		int result = 0;

		try {
			con = getConecsion();

			PreparedStatement preparedStatement = con.prepareStatement(insert_parqueadero);
			preparedStatement.setString(1, parqueadero.getNombre_usuario());
			preparedStatement.setString(2, parqueadero.getTipo_vehiculo());
			preparedStatement.setString(3, parqueadero.getTiempo());
			preparedStatement.setString(4, parqueadero.getPlaca());
			preparedStatement.setString(5, parqueadero.getColor());
			preparedStatement.setString(6, parqueadero.getMarca());
			preparedStatement.setString(7, parqueadero.getDescripcion_adicional());

			System.out.println("QUERY sent to DBB: " + preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			this.printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public List<Parqueadero> consultaParqueaderos() {
		Parqueadero p = null;
		String sql = "select * from lugar_parqueadero";
		List<Parqueadero> listaParqueaderos = new ArrayList<>();
		con = getConecsion();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Parqueadero();
				p.setNombre_usuario(rs.getString("nombre_usuario"));
				p.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
				p.setTiempo(rs.getString("tiempo"));

				listaParqueaderos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaParqueaderos;
	}
}