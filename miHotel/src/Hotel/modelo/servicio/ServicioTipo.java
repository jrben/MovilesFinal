package Hotel.modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hotel.modelo.vo.TipoHabitacionVO;


public class ServicioTipo {
	public List<TipoHabitacionVO> listarTipos() {
		
		ArrayList<TipoHabitacionVO> tipos = new ArrayList<TipoHabitacionVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			// System.out.println("Conexión exitosa");
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM tipohabitacion t");
			st.execute();
			ResultSet rs = st.getResultSet();
			while(rs.next()){
				TipoHabitacionVO tipo = new TipoHabitacionVO();
				tipo.setId_tipo(rs.getInt("id_tipo"));
				tipo.setPrecio_tipo(rs.getFloat("precio_tipo"));
				tipo.setTipo(rs.getString("tipo"));
				tipo.setCapacidad(rs.getInt("capacidad"));
				tipo.setDisponibilidad(rs.getInt("disponibilidad"));
				tipos.add(tipo);
			}
			st.close();
			conexion.close();
	    }catch (Exception e) {
		e.printStackTrace();
	}
		return tipos;

}
	
	public int obtenerId(int precio){
		int id=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			PreparedStatement st = conexion.prepareStatement("SELECT * FROM tipohabitacion where precio_tipo=?");
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
	
	

}