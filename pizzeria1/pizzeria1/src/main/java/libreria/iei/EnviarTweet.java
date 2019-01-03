package libreria.iei;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class EnviarTweet implements JavaDelegate{
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		String nombreCliente = (String) execution.getVariable("IDNombre");
		int cantidad = ((Number) execution.getVariable("IDCantidad")).intValue();
		String pizza = (String) execution.getVariable("IDNombrePizza");
		double precio = (Double) execution.getVariable("IDPrecio");
		String entrega = (String) execution.getVariable("IDEntrega");
		
		
		String consumerKey = "R3HV4NTgcjRm7f0hA2tC33uCd";
		String consumerSecret = "OQ4Ubhi4mLiY1OSDfKFB2hT5HJZO0HJhVCfQDlm9wdXbeDUlfw";
		String accessToken = "1075451990816243713-DXF0yycvuwOQHI7Knf8qbSOU9bb4rr";
		String accessTokenSecret = "tNZgrK6XkGIUTmZ7gRvAbOnbSPoETonQ411RyvPKt6vS3";
		
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret).setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(accessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		try {
		
			twitter.updateStatus("#El motor de Camunda ha creado un pedido de pizza: " +
		nombreCliente + " pedidas " + cantidad + " de " + pizza );
		
			twitter.updateStatus("La pizza es/son de " + pizza + " y el importe es: " +
		precio + " euro(s) y serán entregadas en " + entrega + " minutos");
		} catch (TwitterException e) { e.printStackTrace();}
		}
}
