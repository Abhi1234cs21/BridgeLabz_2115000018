public class Library_Booking {
    private String title;
    private String author;
    private double price;
    private int availability;

    public Library_Booking(String title, String author, double price, int availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public void borrow() {
        if (availability > 0) {
            availability--;
            System.out.println("You have borrowed '" + title + "'.");
        } else {
            System.out.println("'" + title + "' is currently unavailable.");
        }
    }

    public static void main(String[] args) {
        Library_Booking book1 = new Library_Booking("To Kill a Mockingbird", "Harper Lee", 10.99, 5);
        Library_Booking book2 = new Library_Booking("1984", "George Orwell", 8.99, 0);
        
        book1.borrow();
        book2.borrow();
    }
}
