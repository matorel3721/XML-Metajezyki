

import javax.swing.*;
import javax.xml.bind.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Writer extends JFrame {

    Cars cars, unCars;
    Dealers dealers, unDealers;
    JAXBContext context;
    Marshaller marsh;
    Unmarshaller unmarsh;

    private JTextField id, idD;
    private JTextField nameD;
    private JTextField cityD;
    private JTextField brand;
    private JTextField model;
    private JTextField typee;
    private JTextField capacity;
    private JTextField engine;
    private JTextField transmission;
    private JTextField date;
    private JTextField price;
    private JCheckBox damaged;
    private JTextField color;
    private JLabel idL, idDL;
    private JLabel brandL, nameDL;
    private JLabel cityDL;
    private JLabel modelL;
    private JLabel typeeL;
    private JLabel capacityL;
    private JLabel engineL;
    private JLabel transmissionL;
    private JLabel dateL;
    private JLabel priceL;
    private JLabel damagedL;
    private JLabel colorL;
    private JTabbedPane tab;
    private JButton add, modify, delete, addD, modifyD, deleteD;


    public Writer() {

        setTitle("Komis");
        setSize(190, 620);

        // DEKLARACJE ELEMENTOW
        JPanel panel = new JPanel(new FlowLayout());
        add = new JButton("Dodaj");
        modify = new JButton("Modyfikuj");
        delete = new JButton("Usuń");
        addD = new JButton("Dodaj");
        modifyD = new JButton("Modyfikuj");
        deleteD = new JButton("Usuń");
        idD = new JTextField(10);
        nameD = new JTextField(10);
        cityD = new JTextField(10);
        id = new JTextField(10);
        brand = new JTextField(10);
        model = new JTextField(10);
        typee = new JTextField(10);
        capacity = new JTextField(10);
        engine = new JTextField(10);
        transmission = new JTextField(10);
        date = new JTextField(10);
        price = new JTextField(10);
        damaged = new JCheckBox();
        color = new JTextField(10);
        idL = new JLabel("Podaj id: ");
        idDL = new JLabel("Podaj id: ");
        nameDL = new JLabel("Podaj nazwe: ");
        cityDL = new JLabel("Podaj miasto: ");
        brandL = new JLabel("Podaj markę: ");
        modelL = new JLabel("Podaj model: ");
        typeeL = new JLabel("Podaj typ: ");
        capacityL = new JLabel("Podaj pojemność: ");
        engineL = new JLabel("Podaj silnik: ");
        transmissionL = new JLabel("Podaj skrzynię: ");
        dateL = new JLabel("Podaj datę produkcji: ");
        priceL = new JLabel("Podaj cenę: ");
        damagedL = new JLabel("Uszkodzony?");
        colorL = new JLabel("Podaj kolor: ");

        tab = new JTabbedPane();
        JPanel panel1 = new JPanel();

        tab.addTab("Komisy", null, panel1, null);
        tab.addTab("Samochody", null, panel, null);

        //DODAWANIE ELEMENTOW
        add(tab);
        panel1.add(idDL);
        panel1.add(idD);
        panel1.add(nameDL);
        panel1.add(nameD);
        panel1.add(cityDL);
        panel1.add(cityD);
        panel1.add(addD);
        panel1.add(modifyD);
        panel1.add(deleteD);
        panel.add(idL);
        panel.add(id);
        panel.add(brandL);
        panel.add(brand);
        panel.add(modelL);
        panel.add(model);
        panel.add(typeeL);
        panel.add(typee);
        panel.add(capacityL);
        panel.add(capacity);
        panel.add(engineL);
        panel.add(engine);
        panel.add(transmissionL);
        panel.add(transmission);
        panel.add(dateL);
        panel.add(date);
        panel.add(priceL);
        panel.add(price);
        panel.add(damagedL);
        panel.add(damaged);
        panel.add(colorL);
        panel.add(color);
        panel.add(add);
        panel.add(modify);
        panel.add(delete);

        //LISTENERY DO PRZYCISKOW
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                File file = new File("xml\\cars.xml");
                try {
                    context = JAXBContext.newInstance(Cars.class);
                    unmarsh = context.createUnmarshaller();
                    unCars = (Cars) unmarsh.unmarshal(file);

                    int car_id = Integer.parseInt(id.getText());

                    unCars.remove(car_id);

                    marsh = context.createMarshaller();
                    marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='cars.xsl'?>");
                    marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marsh.marshal(unCars, file);
                    marsh.marshal(unCars, System.out);
                } catch (PropertyException e) {
                    e.printStackTrace();

                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
        });

        modify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                File file = new File("xml\\cars.xml");
                try {

                    context = JAXBContext.newInstance(Cars.class);
                    unmarsh = context.createUnmarshaller();
                    unCars = (Cars) unmarsh.unmarshal(file);


                    int car_id = Integer.parseInt(id.getText());
                    String car_brand = brand.getText();
                    String car_model = model.getText();
                    String car_type = typee.getText();
                    double car_cap = Double.parseDouble(capacity.getText());
                    String car_engine = engine.getText();
                    String car_transmission = transmission.getText();
                    int car_date = Integer.parseInt(date.getText());
                    int car_price = Integer.parseInt(price.getText());
                    String car_damage = "";
                    if (damaged.isSelected() == true) {
                        car_damage = "Tak";
                    } else if (damaged.isSelected() == false) {
                        car_damage = "Nie";
                    }
                    String car_color = color.getText();

                    Car newCar = new Car(car_id, car_brand, car_model, car_type, car_cap, car_engine, car_transmission, car_date, car_price, car_damage, car_color);

                    unCars.update(car_id, newCar);

                    marsh = context.createMarshaller();
                    marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='cars.xsl'?>");
                    marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marsh.marshal(unCars, file);
                    marsh.marshal(unCars, System.out);

                } catch (PropertyException e) {
                    e.printStackTrace();

                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }

        });

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                File file = new File("xml\\cars.xml");

                if (!file.exists() || file.length() == 0) {
                    try {
                        cars = new Cars();

                        int car_id = Integer.parseInt(id.getText());
                        String car_brand = brand.getText();
                        String car_model = model.getText();
                        String car_type = typee.getText();
                        double car_cap = Double.parseDouble(capacity.getText());
                        String car_engine = engine.getText();
                        String car_transmission = transmission.getText();
                        int car_date = Integer.parseInt(date.getText());
                        int car_price = Integer.parseInt(price.getText());
                        String car_damage = "";
                        if (damaged.isSelected() == true) {
                            car_damage = "Tak";
                        } else if (damaged.isSelected() == false) {
                            car_damage = "Nie";
                        }
                        String car_color = color.getText();

                        Car newCar = new Car(car_id, car_brand, car_model, car_type, car_cap, car_engine, car_transmission, car_date, car_price, car_damage, car_color);

                        cars.add(newCar);

                        context = JAXBContext.newInstance(Cars.class);
                        marsh = context.createMarshaller();

                        marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='cars.xsl'?>");
                        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marsh.marshal(cars, file);
                        marsh.marshal(cars, System.out);


                    } catch (PropertyException e) {
                        e.printStackTrace();

                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {

                        context = JAXBContext.newInstance(Cars.class);
                        unmarsh = context.createUnmarshaller();
                        unCars = (Cars) unmarsh.unmarshal(file);

                        int car_id = Integer.parseInt(id.getText());
                        String car_brand = brand.getText();
                        String car_model = model.getText();
                        String car_type = typee.getText();
                        double car_cap = Double.parseDouble(capacity.getText());
                        String car_engine = engine.getText();
                        String car_transmission = transmission.getText();
                        int car_date = Integer.parseInt(date.getText());
                        int car_price = Integer.parseInt(price.getText());
                        String car_damage = "";
                        if (damaged.isSelected() == true) {
                            car_damage = "Tak";
                        } else if (damaged.isSelected() == false) {
                            car_damage = "Nie";
                        }
                        String car_color = color.getText();

                        Car newCar = new Car(car_id, car_brand, car_model, car_type, car_cap, car_engine, car_transmission, car_date, car_price, car_damage, car_color);

                        unCars.add(newCar);

                        marsh = context.createMarshaller();
                        marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='cars.xsl'?>");
                        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marsh.marshal(unCars, file);
                        marsh.marshal(unCars, System.out);


                    } catch (PropertyException e) {
                        e.printStackTrace();

                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        deleteD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                File file = new File("xml\\dealers.xml");
                try {

                    context = JAXBContext.newInstance(Dealers.class);
                    unmarsh = context.createUnmarshaller();
                    unDealers = (Dealers) unmarsh.unmarshal(file);

                    int deal_id = Integer.parseInt(idD.getText());

                    unDealers.remove(deal_id);

                    marsh = context.createMarshaller();
                    marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='dealers.xsl'?>");
                    marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marsh.marshal(unDealers, file);
                    marsh.marshal(unDealers, System.out);

                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }

        });

        modifyD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                File file = new File("xml\\dealers.xml");

                try {

                    context = JAXBContext.newInstance(Dealers.class);
                    unmarsh = context.createUnmarshaller();
                    unDealers = (Dealers) unmarsh.unmarshal(file);

                    int deal_id = Integer.parseInt(idD.getText());
                    String deal_name = nameD.getText();
                    String deal_city = cityD.getText();

                    Dealer newDealer = new Dealer(deal_id, deal_name, deal_city);

                    unDealers.update(deal_id, newDealer);

                    marsh = context.createMarshaller();
                    marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='dealers.xsl'?>");
                    marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marsh.marshal(unDealers, file);
                    marsh.marshal(unDealers, System.out);

                } catch (JAXBException e) {
                    e.printStackTrace();
                }

            }
        });

        addD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                File file = new File("xml\\dealers.xml");

                if (!file.exists() || file.length() == 0) {
                    try {

                        dealers = new Dealers();

                        int deal_id = Integer.parseInt(idD.getText());
                        String deal_name = nameD.getText();
                        String deal_city = cityD.getText();

                        Dealer newDealer = new Dealer(deal_id, deal_name, deal_city);

                        dealers.add(newDealer);

                        context = JAXBContext.newInstance(Dealers.class);
                        marsh = context.createMarshaller();

                        marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='dealers.xsl'?>");
                        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marsh.marshal(dealers, file);
                        marsh.marshal(dealers, System.out);


                    } catch (PropertyException e) {
                        e.printStackTrace();

                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {

                        context = JAXBContext.newInstance(Dealers.class);
                        unmarsh = context.createUnmarshaller();
                        unDealers = (Dealers) unmarsh.unmarshal(file);

                        int deal_id = Integer.parseInt(idD.getText());
                        String deal_name = nameD.getText();
                        String deal_city = cityD.getText();

                        Dealer newDealer = new Dealer(deal_id, deal_name, deal_city);
                        unDealers.add(newDealer);

                        marsh = context.createMarshaller();
                        marsh.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml-stylesheet type='text/xsl' href='dealers.xsl'?>");
                        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marsh.marshal(unDealers, file);
                        marsh.marshal(unDealers, System.out);


                    } catch (PropertyException e) {
                        e.printStackTrace();

                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    public static void main(String[] args) throws JAXBException {

        Writer writer = new Writer();
        writer.setVisible(true);

    }


}
