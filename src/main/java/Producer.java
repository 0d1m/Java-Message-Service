import java.util.Scanner;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			ConnectionFactory connectionFactory= new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection connection= connectionFactory.createConnection();
			connection.start();
			Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createTopic("DTopic");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			System.out.print("Enter text to be sent: ");
			String text= sc.nextLine();
			TextMessage message= session.createTextMessage(text);
			producer.send(message);
			
			session.close();
			connection.close();
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
