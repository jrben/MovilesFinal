package Hotel.modelo.servicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hotel.modelo.vo.*;

public class ServicioCliente {
	public static void main(String[] args) {

		ServicioCliente servicioCliente = new ServicioCliente();
		ArrayList<ClienteVO> clientes = servicioCliente.consultarClientes();
		
		for (int i=0; i<clientes.size();i++){
			System.out.println(clientes.get(i).getNombre()+clientes.get(i).getId_cliente());
		}

	}

	/*
	 * public int datosUsuario(String username, String password) {
	 * 
	 * try{ Class.forName("com.mysql.jdbc.Driver"); Connection
	 * conexion=DriverManager
	 * .getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
	 * PreparedStatement st3 =
	 * conexion.prepareStatement("select * from cliente"); st3.execute();
	 * ResultSet rs=st3.getResultSet(); while (rs.next()) { ClienteVO
	 * cliente=new ClienteVO(); cliente.setUsername(rs.getString("username"));
	 * cliente.setPassword(rs.getString("password")); id_cliente(cliente); }
	 * st.close(); conexion.close(); } catch (Exception e) {
	 * e.printStackTrace(); } return id_cliente;
	 * 
	 * }
	 */

	public boolean comprobarCliente(ClienteVO cliente) {
		boolean existe = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			// System.out.println("Conexión exitosa");
			PreparedStatement st = conexion.prepareStatement("select * from cliente where username=?");
			st.setString(1, cliente.getUsername());
			st.execute();
			ResultSet rs = st.getResultSet();
			if (rs.next()) {
				existe = true;
			}
			st.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	public ClienteVO inicioSesion(String a, String b) {
		ClienteVO cliente=new ClienteVO();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			PreparedStatement st = conexion.prepareStatement("select * from cliente where username=? and password =?");
			st.setString(1, a);
			st.setString(2, b);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setUsername(rs.getString("username"));
				cliente.setPassword(rs.getString("password"));
				cliente.setAdmin(rs.getInt("admin"));
			}
			System.out.println("tttt"+cliente.getNombre()+cliente.getId_cliente());
			st.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	
	
	public void registrarCliente(ClienteVO cliente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			PreparedStatement st2 = conexion
					.prepareStatement("insert into cliente (nombre,username,password) values (?,?,?)");
			st2.setString(1, cliente.getNombre());
			st2.setString(2, cliente.getUsername());
			st2.setString(3, cliente.getPassword());
			st2.executeUpdate();
			st2.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ClienteVO permitirIngreso(ClienteVO cliente) {
		ArrayList<ClienteVO> clientes = consultarClientes();
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getUsername().equals(cliente.getUsername())
					&& clientes.get(i).getPassword().equals(cliente.getPassword())) {
				cliente.setId_cliente(clientes.get(i).getId_cliente());
			}
		}
		return cliente;
	}

	private ArrayList<ClienteVO> consultarClientes() {
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "root");
			PreparedStatement st = conexion.prepareStatement("select * from cliente");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setUsername(rs.getString("username"));
				cliente.setPassword(rs.getString("password"));
				clientes.add(cliente);
			}
			st.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

}