import javax.xml.bind.annotation.*;

@XmlRootElement
public class Dealer {

    private int id;

    private String name;

    private String city;



    public Dealer() {
    }

    public Dealer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
