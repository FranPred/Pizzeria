package pizzeria1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	private static Connection conexion = null;

	public static Connection abrirConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Entrega" ,"root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return conexion;
	}

	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				// cerrar la BD
				conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexi�n con la BD");
			}
		}
	}
}
