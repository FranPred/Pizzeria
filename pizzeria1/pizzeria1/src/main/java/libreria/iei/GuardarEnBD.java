package libreria.iei;

import org.camunda.bpm.engine.delegate.JavaDelegate;

import pizzeria1.Conexion;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;

public class GuardarEnBD implements JavaDelegate{
	public void execute(DelegateExecution execution) throws Exception {
		
	String nombreCliente = (String) execution.getVariable("IDNombre");
	String pizza = (String) execution.getVariable("IDNombrePizza");
	double precio = (Double) execution.getVariable("IDPrecio");
	String direccion = (String) execution.getVariable("IDDireccion");
	Date fecha = new Date(2018,12,23);
	/*Connection connection = Conexion.abrirConexion();
	String insertarPedido = "INSERT INTO pedido (fecha , total , nom_cliente , direccion ) VALUES (?,?,?,?,?);";
	PreparedStatement preparedStatement = connection.prepareStatement(insertarPedido, Statement.RETURN_GENERATED_KEYS);
	preparedStatement.setDate(1, fecha);
	preparedStatement.setDouble(2, precio);
	preparedStatement.setString(3, nombreCliente);
	preparedStatement.setString(4,direccion);
	preparedStatement.executeUpdate();*/
	
	//Conexion.cerrarConexion();
	   ServicioPizzas sp = new ServicioPizzas();
	   sp.insertarPedido(nombreCliente, direccion, precio, fecha);
	   System.out.println("Guardado con exito");
	}
}
