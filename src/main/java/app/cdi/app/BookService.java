package app.cdi.app;

import javax.inject.Inject;

@Loggable
public class BookService {

    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Integer price, String desc) {
        Book book = new Book(title, price, desc);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
