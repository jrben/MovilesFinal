package Hotel.modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Hotel.modelo.vo.ReservaVO;

public class ServicioReserva {
	public void registrarReserva(ReservaVO reserva) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			PreparedStatement st2 = conexion
					.prepareStatement("insert into cliente (fecha_ingreso,fecha_salida,precio_reserva) values (?,?,?)");
			st2.setString(1, reserva.getFecha_ingreso());
			st2.setString(2, reserva.getFecha_salida());
			st2.setString(3, reserva.getPrecio_reserva());
			
			st2.executeUpdate();
			st2.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
