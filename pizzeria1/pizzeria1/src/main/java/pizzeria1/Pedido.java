package pizzeria1;

import java.sql.Date;

public class Pedido {

	private int id_pedido;
	private Date fecha;
	private double total;
	private String NombreCliente;
	private String direccion;
	
	public Pedido() {}
	
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public void AddLinea(Pizza pizza) {
		
		
	}
	
	
	
	
	
}
