package Hotel.modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import Hotel.modelo.vo.ReservaVO;
import Hotel.modelo.vo.TipoServicioVO;

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
	
public List<ReservaVO> consultarReserva(int id_cliente) {
		
		ArrayList<ReservaVO> servicios = new ArrayList<ReservaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			// System.out.println("Conexión exitosa");
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM reservahabitacion rh");
			st.execute();
			ResultSet rs = st.getResultSet();
			while(rs.next()){
				ReservaVO serv = new ReservaVO();
				serv.setId_reserva(rs.getInt("id_reserva"));
				serv.setFecha_ingreso(rs.getString("fecha_ingreso"));
				serv.setFecha_salida(rs.getString("fecha_salida"));
				serv.setPrecio_reserva(rs.getString("precio_reserva"));
				servicios.add(serv);
			}
			st.close();
			conexion.close();
	    }catch (Exception e) {
		e.printStackTrace();
	}
		return servicios;

}
	
	public void eliminarReserva(int id){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			PreparedStatement st2 = conexion
					.prepareStatement("delete from reservahabitacion where id_reserva = ?");
			st2.setInt(1, id);
			st2.executeUpdate();
			st2.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
