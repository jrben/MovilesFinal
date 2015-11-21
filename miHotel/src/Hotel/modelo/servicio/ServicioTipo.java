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
		List<TipoHabitacionVO> tipos = new ArrayList<TipoHabitacionVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			// System.out.println("Conexión exitosa");
			PreparedStatement st = conexion.prepareStatement("SELECT t FROM tipohabitacion t");
			st.execute();
			ResultSet rs = st.getResultSet();
			

		//List<TipoHabitacionVO> tipos = new ArrayList<TipoHabitacionVO>();
		List<TipoHabitacionVO> lista=(List<TipoHabitacionVO>) st.getResultSet();
	    for( TipoHabitacionVO t:lista )
	    {   
	    	TipoHabitacionVO tip = new TipoHabitacionVO();
	    	tip.setId_tipo(t.getId_tipo());
	    	tip.setPrecio_tipo(t.getPrecio_tipo());
	    	tip.setTipo(t.getTipo());
	    	tipos.add(tip);
	    }
	    //return tipos;		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return tipos;

}
}