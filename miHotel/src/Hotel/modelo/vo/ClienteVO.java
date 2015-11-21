package Hotel.modelo.vo;

public class ClienteVO {
	private int id_cliente;
	private String nombre;
	private String username;
	private String password;
	private int admin;

public ClienteVO(){
	nombre="";
	username="";
	password="";
}

public final int getId_cliente() {
	return id_cliente;
}

public final void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
}

public final String getNombre() {
	return nombre;
}

public final void setNombre(String nombre) {
	this.nombre = nombre;
}

public final String getUsername() {
	return username;
}

public final void setUsername(String username) {
	this.username = username;
}

public final String getPassword() {
	return password;
}

public final void setPassword(String password) {
	this.password = password;
}

public final int getAdmin() {
	return admin;
}

public final void setAdmin(int admin) {
	this.admin = admin;
}

}
