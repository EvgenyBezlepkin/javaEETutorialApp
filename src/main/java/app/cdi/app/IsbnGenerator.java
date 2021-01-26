package app.cdi.app;

import javax.inject.Inject;
import java.util.logging.Logger;

@ThirteenDigits
public class IsbnGenerator  implements NumberGenerator{

    @Inject
    private Logger logger;

    public String generateNumber() {
        return null;
    }
}
