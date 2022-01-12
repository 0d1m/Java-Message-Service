import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) throws JMSException {

		ConnectionFactory connectionFactory= new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection;
		connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination= session.createTopic("DTopic");
		//Destination destination = session.createQueue("DQueue");
		 
		MessageConsumer consumer = session.createConsumer(destination);
		connection.start();
		
		consumer.setMessageListener(new MessageListener() {
			 
			 public void onMessage(Message message) {
				 try {
					 if(message instanceof TextMessage) {
						 TextMessage textMessage= (TextMessage) message;
						 String text= textMessage.getText();
						 System.out.println("Message received: "+text);
					 }
					 else {
						 System.out.println("Received: "+message);
					 }
				 }catch(JMSException e) {
					 e.printStackTrace();
				 }
			 }
		 });
	}	
}
