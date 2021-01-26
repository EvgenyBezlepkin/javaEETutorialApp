package app.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;


@Stateless
public class Messages {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource
    private Queue chatQueue;


    public void sendMessage(String text) throws JMSException {

        Connection connection = null;
        Session session = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(chatQueue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
        } finally {
            if (session != null) session.close();
            if (connection != null) connection.close();
        }
    }

    public String receiveMessage() throws JMSException {

        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(chatQueue);
            TextMessage message = (TextMessage) consumer.receive(1000);
            return message.getText();

        } finally {
            if (consumer != null) consumer.close();
            if (session != null) session.close();
            if (connection != null) connection.close();
        }
    }
}