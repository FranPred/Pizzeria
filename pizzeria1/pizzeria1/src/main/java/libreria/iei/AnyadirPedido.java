package libreria.iei;



import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import libreria.iei.ServicioPizzas;
import pizzeria1.Pedido;
import pizzeria1.Pizza;
public class AnyadirPedido implements TaskListener {
@Override
public void notify(DelegateTask arg0) {
	
	String NombreCliente = (String)arg0.getVariable("IDNombre");
	String direccion = (String)arg0.getVariable("IDDireccion");
	String NombrePizza1 = (String)arg0.getVariable("IDNombrePizza");
	int cantidad =((Long)arg0.getVariable("IDCantidad")).intValue();

	Pedido pedido = new Pedido();
	pedido.setNombreCliente(NombreCliente);
	pedido.setDireccion(direccion);
	pedido.AddLinea(new Pizza(NombrePizza1,cantidad));
	// salvar el pedido en el motor para luego recuperarlo
	
	arg0.setVariable("miPedido", pedido);
	ServicioPizzas sp = new ServicioPizzas();
	Date fecha = new Date(2018,12,23);
	int idped = sp.insertarPedido(NombreCliente,direccion, 0.0, fecha);
	sp.insertarCabezeraPedido(idped,NombrePizza1, cantidad, 0.0);
	
	
}
}
