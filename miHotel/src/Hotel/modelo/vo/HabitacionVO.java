package Hotel.modelo.vo;

public class HabitacionVO {
	private int id_habitacion;
	private int id_tipo;
	private int id_reserva;
	private String numero_personas;

public HabitacionVO(){
	//Constructor vacio
}

public final int getId_habitacion() {
	return id_habitacion;
}
public final void setId_habitacion(int id_habitacion) {
	this.id_habitacion = id_habitacion;
}
public final int getId_tipo() {
	return id_tipo;
}
public final void setId_tipo(int id_tipo) {
	this.id_tipo = id_tipo;
}
public final int getId_reserva() {
	return id_reserva;
}
public final void setId_reserva(int id_reserva) {
	this.id_reserva = id_reserva;
}
public final String getNumero_personas() {
	return numero_personas;
}
public final void setNumero_personas(String numero_personas) {
	this.numero_personas = numero_personas;
}

}
