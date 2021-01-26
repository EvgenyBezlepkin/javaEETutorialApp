import app.jms.Messages;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MessagesTest {

    //Messages EJB is injected.
    @EJB
    private Messages messages;

    @Before
    public void setUp() throws Exception {
        Properties p = new Properties();
        //Embedded OpenEJB container is started.
        //And current test added inside created container
        //So we can use javaee annotations inside
        EJBContainer.createEJBContainer(p).getContext().bind("inject", this);
    }

    @Test
    public void shouldSendAndReceiveMessages() throws Exception {

        //Three messages are sent.
        messages.sendMessage("Hello World!");
        messages.sendMessage("How are you?");
        messages.sendMessage("Still spinning?");

        //Three messages are received.
        assertThat(messages.receiveMessage(), is("Hello World!"));
        assertThat(messages.receiveMessage(), is("How are you?"));
        assertThat(messages.receiveMessage(), is("Still spinning?"));
    }

}
