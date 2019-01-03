
package libreria.iei;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

	
public class CalcularPrecio implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String NombrePizza = (String) execution.getVariable("IDNombrePizza");
		// accede a la variable IDNombrePizza, el m�todo devuelve un Object, se realiza un casting
		// Si la variable no est� en el motor devolver� null
		int cantidad = ((Number) execution.getVariable("IDCantidad")).intValue();
		System.out.println("Calculando el precio de " + cantidad + " " + NombrePizza + "pizzas");
		double precio = 0.0;
		if("margarita".equalsIgnoreCase(NombrePizza)) { precio = cantidad * 20.0; }
		if("barbacoa".equalsIgnoreCase(NombrePizza)) { precio = cantidad * 7.0; }
		if("carbonara".equalsIgnoreCase(NombrePizza)) { precio = cantidad * 6.0; }
		System.out.println("El precio ser� " + precio);
		execution.setVariable("IDPrecio", precio); // Pone un valor double en el motor
		}
	}
	
	

