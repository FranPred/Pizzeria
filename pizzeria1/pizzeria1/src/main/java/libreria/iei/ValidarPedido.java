package libreria.iei;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import java.util.List;

import org.apache.ibatis.logging.Log;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import pizzeria1.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ValidarPedido implements JavaDelegate {

	@Override
	public void execute(DelegateExecution ejecucion) {
		String valido = "false";
		
		ServicioPizzas serviciopizzas = new ServicioPizzas();
		Connection conn = Conexion.abrirConexion();
		if(conn !=null) {
		
		try {
		                
		                String nombrepizza;
		                
		                	nombrepizza = (String)ejecucion.getVariable("IDNombrePizza");
		                	if(serviciopizzas.buscarPizza(nombrepizza)) {
		                		serviciopizzas.obtenerPrecio(nombrepizza);
		                		valido = "true";
		                		
		                	}
		                	else{
		                		//hacer delete de pedido(recordatorio)
			                	String SQLBorrarPedido = "DELETE FROM pizzas.lineapedido WHERE nombrepizza =?;";
		                        PreparedStatement statementBorrar = conn.prepareStatement(SQLBorrarPedido);
		                        statementBorrar.setString(1,nombrepizza );
		                        statementBorrar.executeUpdate();
		                	}
		                		                
		}
		catch (SQLException e) {System.out.println(e);}
		}
		ejecucion.setVariable("PedidoValido", valido);
	}
}