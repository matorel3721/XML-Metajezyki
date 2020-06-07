
import javax.swing.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

@XmlRootElement(name = "dealers")
@XmlAccessorType(XmlAccessType.FIELD)


public class Dealers {

    @XmlElement(name = "dealer")
    List<Dealer> dealers;

    public List<Dealer> getDealers() {

        return dealers;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }


    public void add(Dealer dealer) {
        if (this.dealers == null) {
            this.dealers = new ArrayList<Dealer>();
        }
        this.dealers.add(dealer);
    }

    public void remove(int id) {
        if (this.dealers == null) {
            JOptionPane.showMessageDialog(null, "Lista jest pusta!");

        } else {
            for (int i = 0; i < this.dealers.size(); i++) {
                if (this.dealers.get(i).getId() == id) {
                    this.dealers.remove(i);
                }
            }
        }
    }

    public void update(int id, Dealer dealer) {
        for (int i = 0; i < this.dealers.size(); i++) {
            if (this.dealers.get(i).getId() == id) {
                this.dealers.set(i, dealer);
            }
        }
    }


}
