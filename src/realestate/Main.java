package realestate;
import java.util.*;
import java.io.*;


public class Main {
    List<RealEstate> stock = new ArrayList<>();

    public static void main(String[] args) {

        logConfig.setupLogging();

        RealEstate real = new RealEstate("Nyiregyhaza",140000,40,5,Genre.CONDOMINIUM);
        
        real.makeDiscount(1);

        real.getTotPrice();

        real.toString();

          }
    }





