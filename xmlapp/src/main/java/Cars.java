
import javax.swing.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)


public class Cars {

    @XmlElement(name = "car")
    List<Car> cars;

    public List<Car> getCars() {

        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


    public void add(Car car) {
        if (this.cars == null) {
            this.cars = new ArrayList<Car>();
        }
        this.cars.add(car);
    }

    public void remove(int id) {
        if (this.cars == null) {
            JOptionPane.showMessageDialog(null, "Lista jest pusta!");

        } else {
            for (int i = 0; i < this.cars.size(); i++) {
                if (this.cars.get(i).getId() == id) {
                    this.cars.remove(i);
                }
            }
        }
    }

    public void update(int id, Car car) {
        for (int i = 0; i < this.cars.size(); i++) {
            if (this.cars.get(i).getId() == id) {
                this.cars.set(i, car);
            }
        }
    }


}
