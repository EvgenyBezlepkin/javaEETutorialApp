package app.cdi.app;

public class Book {

    String title;
    Integer price;
    String desc;
    String number;

    public Book() {
    }

    public Book(String title, Integer price, String desc, String number) {
        this.title = title;
        this.price = price;
        this.desc = desc;
        this.number = number;
    }

    public Book(String title, Integer price, String desc) {
        this.title = title;
        this.price = price;
        this.desc = desc;
    }

    public Book(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
