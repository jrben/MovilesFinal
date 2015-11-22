package Hotel.modelo.vo;

public class TipoServicioVO {
	private int id_tipo_serv;
	private String tipo_serv;
	private float precio_serv;
	
	public TipoServicioVO(){
		tipo_serv="";
	}

	public final int getId_tipo_serv() {
		return id_tipo_serv;
	}

	public final void setId_tipo_serv(int id_tipo_serv) {
		this.id_tipo_serv = id_tipo_serv;
	}

	public final String getTipo_serv() {
		return tipo_serv;
	}

	public final void setTipo_serv(String tipo_serv) {
		this.tipo_serv = tipo_serv;
	}

	public final float getPrecio_serv() {
		return precio_serv;
	}

	public final void setPrecio_serv(float precio_serv) {
		this.precio_serv = precio_serv;
	}

}
