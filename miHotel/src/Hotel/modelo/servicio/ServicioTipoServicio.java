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
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM tiposervicio t");
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
}
