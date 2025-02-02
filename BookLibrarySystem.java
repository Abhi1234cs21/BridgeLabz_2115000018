class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {

    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayEBookInfo() {
        System.out.println("EBook Info:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("978-1234567890", "Java Programming", "John Smith");
        book1.displayBookInfo();

        book1.setAuthor("Alice Johnson");
        System.out.println("Updated Author: " + book1.getAuthor());

        EBook eBook1 = new EBook("978-9876543210", "Advanced Java", "Mark Lee");
        eBook1.displayEBookInfo();
    }
}
