package app.cdi.examples.eventApi;

import app.cdi.app.Book;
import javax.enterprise.event.Observes;

/**
 * Наблюдатель события аннотирован как @Observers
 */

public class EventObserver {

    public void addBook(@Observes @SomeQualifier Book book) {
        System.out.println(book.getTitle());
    }

    public void addBook2(@Observes @OtherQualifier Book book) {
        System.out.println(book.getTitle());
    }
}
