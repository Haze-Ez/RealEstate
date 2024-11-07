package realestate;

import java.util.logging.Logger;
import java.util.logging.*;

enum Genre {FAMILYHOUSE, CONDOMINIUM, FARM,FLAT}

public class RealEstate implements Comparable<RealEstate>, RealEstateInter {

    private static final Logger LOGGER = Logger.getLogger(RealEstate.class.getName());


    String city;
    double price;
    int sqm;
    double number_of_rooms;
    Genre genre;

    public RealEstate(String city, double price, int sqm, double number_of_rooms, Genre genre) {

        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.number_of_rooms = number_of_rooms;
        this.genre = genre;

        LOGGER.log(Level.INFO, "RealEstate created",this);
    }

    /**
     * compareTo - Compares Real estates
     * @param other the object to be compared.
     */
    @Override
    public int compareTo(RealEstate other) {

        LOGGER.log(Level.INFO, "compareTo called to compare this estate to other");

        if (price<other.price) return -1;
        else if (price>other.price) return 1;
        else if (sqm<other.sqm) return -1;
        else if (sqm>other.sqm) return 1;
        else if (number_of_rooms<other.number_of_rooms) return -1;
        else if (number_of_rooms> other.number_of_rooms) return 1;
        else return 0;

    }

    /**
     * makeDiscount – this method with the percentage specified as an integer in the parameter
     * reduces the price of the property per square meter
     * @param percent
     * @return discounted price
     */
    @Override
    public double makeDiscount(int percent) {
        if (percent < 0 || percent > 100) {
            LOGGER.log(Level.SEVERE, "Invalid discount percentage: {0}. Discount must be between 0 and 100.", percent);
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        double cent = percent / 100.0;
        double cent_value = price * cent;

        System.out.println("Price after discount: "+price);

        LOGGER.log(Level.INFO, "makeDiscount called with percent: {0}, resulting price: {1}",
                new Object[]{percent, price});

       return  price -= cent_value;



    }

    /**
     * getTotalPrice – this method returns an integer with the total price of the property, which it
     * calculates using the price and sqm fields. The price is influenced by which settlement the property
     * is in, so if the property is in Budapest, then 30%, if in Debrecen, then 20%, if in Nyíregyháza, then
     * 15% more than the calculated value
     * @return total-price
     */
    @Override
    public int getTotPrice() {
        double ratio = 1.0;
    double total =0.0;
        switch (city) {
            case "Budapest":
                ratio = 1.30;
                break;
            case "Debrecen":
                ratio = 1.20;
                break;
            case "Nyiregyhaza":
                ratio = 1.15;
                break;
        }
    total = ratio * price * number_of_rooms;

    LOGGER.log(Level.INFO, "Total-Price For City: {0} \n Calculates: {1}.",
            new Object[]{city,total});
    return (int) total;

        }

    /**
     * averageSqmPerRoom - calculates and returns as a real number how many square meters you
     * get on average per room for the given property
     * @return average per room for the given property
     */
    @Override
    public double avgsqmperroom() {
    LOGGER.log(Level.INFO, "avgsqmperroom returns: {0}",
            new Object[]{Math.round(sqm / number_of_rooms)});
        return Math.round(sqm / number_of_rooms);
    }

    /**
     * toString – listing the property&#39;s data together with the total price and the average number of
     * square meters per room
     * @return square meters per room
     */
    @Override
    public String toString() {
    LOGGER.log(Level.INFO, "toString overrides print pattern");
        return "RealEstate: " +
                "city = " + city +
                ", price = " + price +
                ", sqm = " + sqm +
                ", number_of_rooms = " + number_of_rooms +
                ", genre = " + genre +
                ", Total Price = " + getTotPrice() +
                ", Average Room Per Square m = " + avgsqmperroom();
    }

    /**
     * getPrice - returns the price of a property
     */
    public double getPrice() {
        LOGGER.log(Level.INFO, "Returns price");
        return price;
    }

    /**
     * getCity - returns the city name
     */
    public String getCity() {
        LOGGER.log(Level.INFO, "Returns city");
        return city;
    }

    /**
     *getGenre - returns genre type
     */
    public Genre getGenre() {
        LOGGER.log(Level.INFO, "Returns genre");
        return genre;
    }

    /**
     *getsqm - returns sqm of property
     */
    public int getSqm() {
        LOGGER.log(Level.INFO, "Returns sqm");
        return sqm;
    }
}
