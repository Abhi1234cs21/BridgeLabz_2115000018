abstract class Room {
    private String roomNumber;
    private String type;
    private double pricePerNight;

    public Room(String roomNumber, String type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        if(pricePerNight > 0) {
            this.pricePerNight = pricePerNight;
        }
    }

    public abstract double calculateTotalPrice(int nights);
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomNumber, String type, double pricePerNight) {
        super(roomNumber, type, pricePerNight);
    }

    @Override
    public double calculateTotalPrice(int nights) {
        return getPricePerNight() * nights;
    }
}

class StandardRoom extends Room {
    public StandardRoom(String roomNumber, String type, double pricePerNight) {
        super(roomNumber, type, pricePerNight);
    }

    @Override
    public double calculateTotalPrice(int nights) {
        return getPricePerNight() * nights;
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(String roomNumber, String type, double pricePerNight) {
        super(roomNumber, type, pricePerNight);
    }

    @Override
    public double calculateTotalPrice(int nights) {
        return getPricePerNight() * nights;
    }
}

interface Serviceable {
    void requestRoomService();
    void getServiceDetails();
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        DeluxeRoom deluxeRoom = new DeluxeRoom("101", "Deluxe", 200);
        StandardRoom standardRoom = new StandardRoom("102", "Standard", 100);
        SuiteRoom suiteRoom = new SuiteRoom("103", "Suite", 300);

        Room[] rooms = {deluxeRoom, standardRoom, suiteRoom};
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Room Type: " + room.getType());
            System.out.println("Price per Night: " + room.getPricePerNight());
            System.out.println("Total Price for 5 nights: " + room.calculateTotalPrice(5));
        }
    }
}
