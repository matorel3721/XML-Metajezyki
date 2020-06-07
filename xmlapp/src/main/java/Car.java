import javax.xml.bind.annotation.*;
import java.util.Date;


@XmlRootElement

public class Car {

    private int id;

    private String brand;

    private String model;

    private String type;

    private double capacity;

    private String engine;

    private String transmission;

    private int date;

    private int price;

    private String damaged;

    private String color;


    public Car() {
    }

    public Car(int id, String brand, String model, String type, double capacity, String engine, String transmission, int date, int price, String damaged, String color) {

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.capacity = capacity;
        this.engine = engine;
        this.transmission = transmission;
        this.date = date;
        this.price = price;
        this.damaged = damaged;
        this.color = color;

    }
    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String isDamaged() {
        return damaged;
    }

    public void setDamaged(String damaged) {
        this.damaged = damaged;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
