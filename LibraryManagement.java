class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookID;
    boolean availability;
    BookNode next;
    BookNode prev;

    public BookNode(String bookTitle, String author, String genre, int bookID, boolean availability) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagement {
    private BookNode head;
    private BookNode tail;

    public LibraryManagement() {
        this.head = null;
        this.tail = null;
    }

    public void addAtBeginning(String bookTitle, String author, String genre, int bookID, boolean availability) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookID, availability);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String bookTitle, String author, String genre, int bookID, boolean availability) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookID, availability);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(String bookTitle, String author, String genre, int bookID, boolean availability, int position) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookID, availability);
        if (position == 0) {
            addAtBeginning(bookTitle, author, genre, bookID, availability);
        } else {
            BookNode current = head;
            int currentPos = 0;
            while (current != null && currentPos < position - 1) {
                current = current.next;
                currentPos++;
            }
            if (current != null) {
                newBook.next = current.next;
                if (current.next != null) {
                    current.next.prev = newBook;
                }
                current.next = newBook;
                newBook.prev = current;
                if (newBook.next == null) {
                    tail = newBook;
                }
            }
        }
    }

    public void removeByBookID(int bookID) {
        if (head == null) {
            return;
        }
        if (head.bookID == bookID) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        BookNode current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current == tail) {
                tail = current.prev;
            }
        }
    }

    public BookNode searchByBookTitle(String bookTitle) {
        BookNode current = head;
        while (current != null) {
            if (current.bookTitle.equals(bookTitle)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public BookNode searchByAuthor(String author) {
        BookNode current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateAvailabilityStatus(int bookID, boolean availability) {
        BookNode current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.availability = availability;
                return;
            }
            current = current.next;
        }
    }

    public void displayBooksForward() {
        BookNode current = head;
        while (current != null) {
            System.out.println("Book Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Book ID: " + current.bookID + ", Availability: " + (current.availability ? "Available" : "Not Available"));
            current = current.next;
        }
    }

    public void displayBooksReverse() {
        BookNode current = tail;
        while (current != null) {
            System.out.println("Book Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Book ID: " + current.bookID + ", Availability: " + (current.availability ? "Available" : "Not Available"));
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtEnd("Moby Dick", "Herman Melville", "Fiction", 102, false);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 103, true);
        library.addAtPosition("To Kill a Mockingbird", "Harper Lee", "Fiction", 104, true, 2);

        library.displayBooksForward();

        library.removeByBookID(102);

        library.displayBooksForward();

        library.updateAvailabilityStatus(101, false);

        library.displayBooksForward();

        System.out.println("Total Number of Books: " + library.countBooks());

        library.displayBooksReverse();

        BookNode book = library.searchByBookTitle("1984");
        if (book != null) {
            System.out.println("Found book: " + book.bookTitle + " by " + book.author);
        }
    }
}
