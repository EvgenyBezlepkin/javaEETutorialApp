package app.rest;

import app.jms.Messages;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class RestEx {

//    @Inject
//    Ex ex;
//
//    @EJB
//    Messages messages;
//
//    @GET
//    @Path("/hello")
//    public void it() {
//        ex.hello();
//    }
//
//    @GET
//    @Path("/message")
//    public void message() throws JMSException {
//        messages.sendMessage("hello");
//        System.out.println(messages.receiveMessage());
//    }

}
