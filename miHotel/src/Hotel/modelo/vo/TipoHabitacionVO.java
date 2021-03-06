package Hotel.modelo.vo;

public class TipoHabitacionVO {
	private int id_tipo;
	private String tipo;
	private float precio_tipo;
	private int capacidad;
	private int disponibilidad;
	
	public TipoHabitacionVO(){
		tipo="";
	}

	public final int getId_tipo() {
		return id_tipo;
	}

	public final void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public final String getTipo() {
		return tipo;
	}

	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public final float getPrecio_tipo() {
		return precio_tipo;
	}

	public final void setPrecio_tipo(float precio_tipo) {
		this.precio_tipo = precio_tipo;
	}

	public final int getCapacidad() {
		return capacidad;
	}

	public final void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public final int getDisponibilidad() {
		return disponibilidad;
	}

	public final void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

}
