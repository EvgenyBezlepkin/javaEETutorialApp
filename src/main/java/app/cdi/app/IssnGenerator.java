package app.cdi.app;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator{

    @Inject
    private Logger logger;

    @LoggableForApp
    public String generateNumber() {
        String isbn = "8-" + Math.abs(new Random().nextInt());
        //logger.info("Issn was generated " + isbn);
        return isbn;
    }
}
