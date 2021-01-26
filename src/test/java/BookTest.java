import app.cdi.app.Book;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BookTest {
    private static Weld weld;
    private static WeldContainer weldContainer;

    @BeforeClass
    public static void setupClass() {
        weld = new Weld();
        weldContainer = weld.initialize();
    }

    @AfterClass
    public static void teardownClass() {
        weld.shutdown();
    }

    @Test
    public void dummyTest() {
        Book book = weldContainer.instance().select(Book.class).get();
        book.setTitle( "foobar");
        assertEquals("foobar", book.getTitle());
    }
}