package realestate;
import java.util.*;
import java.io.*;


public class Main {
    List<RealEstate> stock = new ArrayList<>();

    public static void main(String[] args) {

        logConfig.setupLogging();

        RealEstate real = new RealEstate("Nyiregyhaza",140000,40,5,Genre.CONDOMINIUM);

        real.makeDiscount(1);

        //RealEstateAgent agent = new RealEstateAgent();

//        double TotalPrice = 0.0;
//        int Totalsqm = 0;
//
//        RealEstate cheapestProperty = RealEstateAgent.stock.first(); // Assuming there is at least one property
//        RealEstate mostexpInBuda = RealEstateAgent.stock.first();
//
//        List<RealEstate> affordableCondominiums = new ArrayList<>();
//        System.out.println("Total properties in stock: " + RealEstateAgent.stock.size());
//        String path = "OutputRealEstate.txt";
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
//
//
//            for (RealEstate realEstate : RealEstateAgent.stock) {
//
//                TotalPrice += realEstate.getPrice();
//                Totalsqm +=realEstate.getSqm();
//
//                if (realEstate.getPrice() < cheapestProperty.getPrice()) {
//                    cheapestProperty = realEstate;
//                }
//
//                if (realEstate.getCity().equals("Budapest")) {
//                    if (realEstate.getPrice() > mostexpInBuda.getPrice()) {
//                        mostexpInBuda = realEstate;
//                    }
//
//
//                }
//            }
//
//
//                bw.write("Cheapest Property: " + cheapestProperty.getCity() + " with a price of " + cheapestProperty.getPrice());
//                bw.newLine();
//                bw.newLine();
//                bw.write("Average sqm/room of the most expensive property in Budapest: " +mostexpInBuda.avgsqmperroom());
//                bw.newLine();
//                bw.newLine();
//                bw.write("Price of the most expensive property in Budapest: " + mostexpInBuda.getPrice());
//                bw.newLine();
//                bw.newLine();
//                bw.write("Total Price of Properties: " + TotalPrice);
//                bw.newLine();
//                bw.newLine();
//
//
//                double Avgprice = Math.round(TotalPrice / Totalsqm);
//                bw.write("Average Sqm Price of Properties: " + Avgprice);
//                bw.newLine();
//
//            for (RealEstate realEstate : RealEstateAgent.stock) {
//                if (realEstate.getGenre().equals("CONDOMINIUM") && realEstate.getPrice() <= Avgprice) {
//                    affordableCondominiums.add(realEstate);
//                }
//            }
//
//            bw.newLine();
//
//            bw.write("Condominium properties whose price does not exceed the average price:");
//            bw.newLine();
//            bw.newLine();
//
//            if (affordableCondominiums.isEmpty()) {
//                bw.write("No affordable condominiums found.");
//                bw.newLine();
//            } else {
//                for (RealEstate realEstate : affordableCondominiums) {
//                    bw.write(realEstate.toString());
//                    bw.newLine();
//                }
//            }
//
//
//            System.out.println("Written Successfully");
//
//
//        } catch (IOException e) {
//            System.out.println("An error occurred");
//            e.printStackTrace();
//        }
//
//        RealEstateAgent adam = new RealEstateAgent();
//                adam.read("sample.txt");
//       for(RealEstate real : RealEstateAgent.stock) {
//           System.out.println(real.toString());
//       }
//
//    }
    }
}




