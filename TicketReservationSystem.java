class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private TicketNode head;
    private TicketNode tail;
    private int ticketCount;

    public TicketReservationSystem() {
        head = null;
        tail = null;
        ticketCount = 0;
    }

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        ticketCount++;
    }

    public void removeTicket(int ticketID) {
        if (head == null) return;

        TicketNode current = head;
        TicketNode previous = null;

        do {
            if (current.ticketID == ticketID) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    head = current.next;
                    tail.next = head;
                }
                if (current == tail) {
                    tail = previous;
                }
                ticketCount--;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public TicketNode searchTicketByCustomerName(String customerName) {
        if (head == null) return null;
        TicketNode current = head;
        do {
            if (current.customerName.equals(customerName)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public TicketNode searchTicketByMovieName(String movieName) {
        if (head == null) return null;
        TicketNode current = head;
        do {
            if (current.movieName.equals(movieName)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    public int totalBookedTickets() {
        return ticketCount;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Alice", "Avatar", "A1", "2025-02-12 14:00");
        system.addTicket(2, "Bob", "Titanic", "B2", "2025-02-12 16:00");
        system.addTicket(3, "Charlie", "Avatar", "A3", "2025-02-12 18:00");

        system.displayTickets();

        system.removeTicket(2);
        system.displayTickets();

        TicketNode ticket = system.searchTicketByCustomerName("Charlie");
        if (ticket != null) {
            System.out.println("Found ticket for Charlie: " + ticket.ticketID);
        }

        ticket = system.searchTicketByMovieName("Avatar");
        if (ticket != null) {
            System.out.println("Found ticket for movie Avatar: " + ticket.ticketID);
        }

        System.out.println("Total booked tickets: " + system.totalBookedTickets());
    }
}
