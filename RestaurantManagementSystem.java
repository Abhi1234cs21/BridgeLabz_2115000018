interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getPersonDetails() {
        return "Name: " + name + ", ID: " + id;
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("The Chef is preparing the food, specializing in " + specialty + ".");
    }

    public String getDetails() {
        return getPersonDetails() + ", Specialty: " + specialty;
    }
}

class Waiter extends Person implements Worker {
    String section;

    Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("The Waiter is serving food to customers in the " + section + " section.");
    }

    public String getDetails() {
        return getPersonDetails() + ", Section: " + section;
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("John Doe", 1, "Italian Cuisine");
        Waiter waiter = new Waiter("Jane Smith", 2, "North Wing");

        System.out.println(chef.getDetails());
        chef.performDuties();

        System.out.println(waiter.getDetails());
        waiter.performDuties();
    }
}
