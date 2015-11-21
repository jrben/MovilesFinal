package Hotel.modelo.vo;

import java.util.Date;

public class ReservaVO {
	private int id_reserva;
	private int id_cliente;
	private Date fecha_ingreso;
	private Date fecha_salida;
	private float precio_reserva;
	
	public ReservaVO(){
		//constructor vacio
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

	public final Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public final void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public final Date getFecha_salida() {
		return fecha_salida;
	}

	public final void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public final float getPrecio_reserva() {
		return precio_reserva;
	}

	public final void setPrecio_reserva(float precio_reserva) {
		this.precio_reserva = precio_reserva;
	}

}
