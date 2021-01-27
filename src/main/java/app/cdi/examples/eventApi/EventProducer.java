package app.cdi.examples.eventApi;

import app.cdi.app.Book;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Производитель события внедряет интерфейс Event
 * и вызывает у него метод .fire()
 * работает синхронно
 * Чтобы событие выбрасывалось более точечно используется какая-либо квалифицированная аннотация на продюсере и обсервере
 */

public class EventProducer {

    @Inject @SomeQualifier
    Event<Book> event;
    @Inject @OtherQualifier
    Event<Book> otherEvent;

    public void createBook() {
        Book b = new Book();
        b.setTitle("event with SomeQualifier");
        event.fire(b);
    }
    public void createBook2() {
        Book b = new Book();
        b.setTitle("otherEvent");
        otherEvent.fire(b);
    }

}
