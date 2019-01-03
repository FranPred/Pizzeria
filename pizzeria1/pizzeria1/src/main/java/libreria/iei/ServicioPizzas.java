package libreria.iei;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pizzeria1.Conexion;

public class ServicioPizzas {
	public double obtenerPrecio(String nombrePizza)
	{
	 double importe = 0.0;
	 Connection conn = Conexion.abrirConexion();
	 if(conn !=null) {
		 String SQL = "SELECT precio FROM pizzas.pizza where nombre =?";
		 try {
			 PreparedStatement statement = conn.prepareStatement(SQL);
			 statement.setString(1, nombrePizza);
			 ResultSet result = statement.executeQuery();
			 if (result.next()) {
			 importe = result.getDouble("precio");
			 }

			 Conexion.cerrarConexion();
			 return (importe);
		 } catch (SQLException e) {
			 e.printStackTrace();
		}
	 }
	 Conexion.cerrarConexion();
	 return importe;
	}
	
	
	public boolean buscarPizza(String nombrePizza) {
	boolean encontrado = false;

	 Connection conn = Conexion.abrirConexion();
	 if(conn !=null) {
		 String SQL = "SELECT idpizza FROM pizzas.pizza where nombre =?";
	 try {
		 PreparedStatement statement = conn.prepareStatement(SQL);
		 statement.setString(1, nombrePizza);
		 ResultSet result = statement.executeQuery();
	 if (result.next()) encontrado= true;
	 else encontrado = false;
	 Conexion.cerrarConexion();
	 return (encontrado);
	 } catch (SQLException e) {
		 e.printStackTrace();
	 }
	 }
	 Conexion.cerrarConexion();
	 return false;
	 }
	
	
	public int insertarPedido(String NombreCliente, String
			 DireccionEntrega, double Total, java.util.Date fecha)
			{
			int clave = 0;
			 Connection conn = Conexion.abrirConexion();
			 if(conn !=null) {
			 String SQL = "INSERT INTO pizzas.pedido (fecha,total,nom_cliente,direccion) VALUES (?,?,?,?)"; 
			 // 4 parámetros
			 try {
			 PreparedStatement statement = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);

			 // convertir java.util.Date a java.sql.Date
			 java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
			 statement.setDate(1,sqlDate);
			 statement.setDouble(2, Total);
			 statement.setString(3,NombreCliente);
			 statement.setString(4,DireccionEntrega);
			 statement.executeUpdate();
			 ResultSet claves = statement.getGeneratedKeys();
			 claves.next();
			 clave = claves.getInt(1);
			 return clave;
			 } catch (SQLException e) {
			 e.printStackTrace();
			 } finally { Conexion.cerrarConexion();}
			 } return clave;
}
	public int insertarCabezeraPedido(Integer idped,String NombrePizza,int cantidad ,double importe) {
		int clave = 0;
		 Connection conn = Conexion.abrirConexion();
		 if(conn !=null) {
		 String SQL = "INSERT INTO pizzas.lineapedido (idpedido,nombrepizza,cantidad,importe_linea)  VALUES (?,?,?,?);"; 
		 
		 try {
		 PreparedStatement statement = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);

		 // convertir java.util.Date a java.sql.Date
		 statement.setInt(1,idped);
		 statement.setString(2,NombrePizza);
		 statement.setInt(3,cantidad);
		 statement.setDouble(4, importe);
		 statement.executeUpdate();
		 ResultSet claves = statement.getGeneratedKeys();
		 claves.next();
		 clave = claves.getInt(1);
		 return clave;
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } finally { Conexion.cerrarConexion();}
		 } return clave;
		
	}
}
