package realestate;

import java.util.logging.*;

public class Panel extends RealEstate implements PanelInter{

    private Logger logger = Logger.getLogger("Panel");
    int floor;
    boolean isinsulated;

    public Panel(String city, double price, int sqm, double number_of_rooms, Genre genre, int floor, boolean isInsulated) {

        super(city, price, sqm, number_of_rooms, genre);

        this.floor = floor;
        this.isinsulated = isInsulated;

        int total = getTotPrice();

        if (floor <= 2 && floor >= 0)total *=1.5;
        if (floor == 10)total *=0.95;
        if (isInsulated) total *=1.5;

        logger.log(Level.INFO,"Panel created");


    }

    /**
     * override the toString method to take into account the floor and insulated
     * fields. If the panel apartment is located on floors 0 - 2, then by +5%, if on the 10th floor, then by -5%, if it is
     * insulated, then by another +5%, modify the value of the calculated total price.
     *
     */
    @Override
    public String toString() {
        return "Panel: " +
                "city = " + city +
                ", price = " + price +
                ", sqm = " + sqm +
                ", number_of_rooms = " + number_of_rooms +
                ", genre = " + genre + ", floor = " + floor +
                ", isinsulated = " + isinsulated +
                ':';
    }

    /**
     * hasSameAmount - returns true if the RealEstate class input parameter has the same value
     * returned by the totalPrice method
     * @param value
     * @return true/false
     */
    public boolean hasSameAmmount(int value) {
        System.out.println("getTotPrice: " + this.getTotPrice() + " value: " + value);

        logger.log(Level.INFO,"hasSameAmount checks if total-price of {0} equates to {1}"
                ,new Object[]{this,value});

        return this.getTotPrice() == value;


    }

    /**
     * roomprice - returns as an integer how much an average room in the given property costs on
     * average. (Neither settlement nor floor or insulation modifiers need to be taken into account.)
     * @return Price of one room in a property
     */
    public int roomprice() {
        int price =(int)Math.round( (super.price / number_of_rooms) );

        logger.log(Level.INFO,"roomprice returns price for one room");
        return price;
    }

    /**
     * compareto - Compares panels and estates
     * @param other the object to be compared.
     */
    @Override
    public int compareTo(RealEstate other) {
        logger.log(Level.INFO,"Running inherited compareTO method");

        if (price<other.price) return -1;
        else if (price>other.price) return 1;
        else if (sqm<other.sqm) return -1;
        else if (sqm>other.sqm) return 1;
        else if (number_of_rooms<other.number_of_rooms) return -1;
        else if (number_of_rooms> other.number_of_rooms) return 1;

        else return 0;

    }





        //        int comparison = super.compareTo(other);
//        if (comparison != 0) return comparison;
//        if (!(other instanceof Panel)) return 1;
//        Panel otherPanel = (Panel) other;
//        return Integer.compare(this.floor, otherPanel.floor);
    }



