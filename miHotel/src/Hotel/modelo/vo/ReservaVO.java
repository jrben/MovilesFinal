package Hotel.modelo.vo;

import java.util.Date;

public class ReservaVO {
	private int id_reserva;
	private int id_cliente;
	private String fecha_ingreso;
	private String fecha_salida;
	private String precio_reserva;
	
	public ReservaVO(){
		fecha_ingreso="";
		fecha_salida="";
		precio_reserva="";
		
	}

	public final int getId_reserva() {
		return id_reserva;
	}

	public final void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public final int getId_cliente() {
		return id_cliente;
	}

	public final void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public final String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public final void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public final String getFecha_salida() {
		return fecha_salida;
	}

	public final void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public final String getPrecio_reserva() {
		return precio_reserva;
	}

	public final void setPrecio_reserva(String precio_reserva) {
		this.precio_reserva = precio_reserva;
	}



}
