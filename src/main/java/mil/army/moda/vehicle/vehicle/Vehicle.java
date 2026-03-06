package mil.army.moda.vehicle.vehicle;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private long id;

    private String make;
    private String model;
    private int year;
    private int mileage;

}
