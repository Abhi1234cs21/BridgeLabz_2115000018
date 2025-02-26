package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (required for Jackson serialization)
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        // Creating a Car object
        Car car = new Car("Tesla", "Model S", 2023);

        // Creating ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert Car object to JSON string
            String jsonString = objectMapper.writeValueAsString(car);

            // Print JSON output
            System.out.println("Car Object in JSON format: " + jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

