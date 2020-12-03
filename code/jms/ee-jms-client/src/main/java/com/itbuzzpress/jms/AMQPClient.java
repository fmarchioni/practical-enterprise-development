package com.itbuzzpress.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.qpid.jms.JmsConnectionFactory;

public class AMQPClient {

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        ConnectionFactory connectionFactory = new JmsConnectionFactory("amqp://localhost:5672");

        try {

            // Step 1. Create an amqp qpid 1.0 connection
            connection = connectionFactory.createConnection();

            // Step 2. Create a session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Step 3. Create a sender
            Queue queue = session.createQueue("java:/queue/exampleQueue");
            MessageProducer sender = session.createProducer(queue);

            for (int ii=0;ii<10;ii++)
            sender.send(session.createTextMessage("Hello world n."+ii));

            connection.start();

            // Step 5. create a moving receiver, this means the message will be removed from the queue
          //  MessageConsumer consumer = session.createConsumer(queue);

            // Step 7. receive the simple message
          //  TextMessage m = (TextMessage) consumer.receive(5000);
          //  System.out.println("message = " + m.getText());

        } finally {
            if (connection != null) {
                // Step 9. close the connection
                connection.close();
            }
        }
    }
}