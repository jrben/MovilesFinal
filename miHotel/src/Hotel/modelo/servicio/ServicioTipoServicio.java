package Hotel.modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Hotel.modelo.vo.TipoServicioVO;

public class ServicioTipoServicio {
public List<TipoServicioVO> listarTipoServicio() {
		
		ArrayList<TipoServicioVO> servicios = new ArrayList<TipoServicioVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			// System.out.println("Conexión exitosa");
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM tiposervicio ts");
			st.execute();
			ResultSet rs = st.getResultSet();
			while(rs.next()){
				TipoServicioVO serv = new TipoServicioVO();
				serv.setId_tipo_serv(rs.getInt("id_tipo_serv"));
				serv.setTipo_serv(rs.getString("tipo_serv"));
				serv.setPrecio_serv(rs.getFloat("precio_serv"));
				servicios.add(serv);
			}
			st.close();
			conexion.close();
	    }catch (Exception e) {
		e.printStackTrace();
	}
		return servicios;

}


public int obtenerId(int precio){
	int id=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
		PreparedStatement st = conexion.prepareStatement("SELECT * FROM tiposervicio where precio_serv=?");
		st.setInt(1, precio);
		st.execute();
		ResultSet rs = st.getResultSet();
		while(rs.next()){
			id=rs.getInt("id_tipo");
		}
		st.close();
		conexion.close();
    }catch (Exception e) {
	e.printStackTrace();
}
	return id;		
}

public void ingresarServicio(String nombre, String precio){
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
		PreparedStatement st2 = conexion
				.prepareStatement("insert into tiposervicio (tipo_serv,precio_serv) values (?,?)");
		st2.setString(1, nombre);
		st2.setString(2, precio);

		st2.executeUpdate();
		st2.close();
		conexion.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public void eliminarServicio(int id){
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
		PreparedStatement st2 = conexion
				.prepareStatement("delete from tiposervicio where id_tipo_serv = ?");
		st2.setInt(1, id);
		st2.executeUpdate();
		st2.close();
		conexion.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

}
