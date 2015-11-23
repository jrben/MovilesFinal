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
			PreparedStatement st2 = conexion.prepareStatement("insert into reservahabitacion (id_cliente, id_tipo, id_tipo_serv, fecha_ingreso,fecha_salida,precio_reserva) values (?,?,?,?,?,?)");
			
			st2.setInt(1, reserva.getId_cliente());
			st2.setInt(2, reserva.getId_tipo());
			st2.setInt(3, reserva.getId_tipo_serv());
			
			st2.setString(4, reserva.getFecha_ingreso());
			st2.setString(5, reserva.getFecha_salida());
			st2.setString(6, reserva.getPrecio_reserva());
//			System.out.println(reserva.getId_cliente());
			
			st2.executeUpdate();
			st2.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
