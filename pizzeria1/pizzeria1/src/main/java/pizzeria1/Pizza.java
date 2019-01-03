package pizzeria1;

public class Pizza {
	private int idLinea;
	private int idpedido;
	private String nombrePizza;
	private int cantidad;
	private double importeLinea;

	
	public Pizza() {}
	
	public Pizza(String nombrePizza1, int cantidad) {
		this.nombrePizza = nombrePizza1;
		this.cantidad = cantidad;
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getNombrePizza() {
		return nombrePizza;
	}

	public void setNombrePizza(String nombrePizza) {
		this.nombrePizza = nombrePizza;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getImporteLinea() {
		return importeLinea;
	}

	public void setImporteLinea(double importeLinea) {
		this.importeLinea = importeLinea;
	}

}
