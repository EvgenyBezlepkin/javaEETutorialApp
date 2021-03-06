package app.cdi.app;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@ThirteenDigits
public class IsbnGenerator  implements NumberGenerator{

    @Inject
    private Logger logger;

    @LoggableForApp
    public String generateNumber() {
        String isbn = "12-12121-" + Math.abs(new Random().nextInt());
        //logger.info("Isbn was generated " + isbn);
        return isbn;
    }
}
