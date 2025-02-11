class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public MovieLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        MovieNode newMovie = new MovieNode(title, director, yearOfRelease, rating);
        if (position == 0) {
            addAtBeginning(title, director, yearOfRelease, rating);
        } else {
            MovieNode current = head;
            int currentPos = 0;
            while (current != null && currentPos < position - 1) {
                current = current.next;
                currentPos++;
            }
            if (current == null) {
                System.out.println("Position out of range.");
            } else {
                newMovie.next = current.next;
                newMovie.prev = current;
                if (current.next != null) {
                    current.next.prev = newMovie;
                }
                current.next = newMovie;
                if (newMovie.next == null) {
                    tail = newMovie;
                }
            }
        }
    }

    public void removeByTitle(String title) {
        if (head == null) {
            return;
        }
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        MovieNode current = head;
        while (current != null && !current.title.equals(title)) {
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

    public MovieNode searchByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public MovieNode searchByRating(double rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public void updateRatingByTitle(String title, double newRating) {
        MovieNode movie = searchByTitle(title);
        if (movie != null) {
            movie.rating = newRating;
        } else {
            System.out.println("Movie with title " + title + " not found.");
        }
    }

    public MovieNode searchByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MovieLinkedList list = new MovieLinkedList();

        list.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);

        list.displayForward();

        list.addAtPosition("Dunkirk", "Christopher Nolan", 2017, 7.9, 2);

        list.displayForward();

        list.removeByTitle("Interstellar");

        list.displayForward();

        list.updateRatingByTitle("Inception", 9.0);

        list.displayForward();

        System.out.println("Search by Director:");
        MovieNode movie = list.searchByDirector("Christopher Nolan");
        if (movie != null) {
            System.out.println("Found: " + movie.title);
        }

        System.out.println("Search by Rating:");
        movie = list.searchByRating(9.0);
        if (movie != null) {
            System.out.println("Found: " + movie.title);
        }

        list.displayReverse();
    }
}
