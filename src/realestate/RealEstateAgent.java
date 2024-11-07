package realestate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.*;
import java.util.logging.*;

public class RealEstateAgent {
    private static final Logger LOGGER = Logger.getLogger(RealEstateAgent.class.getName());
    static TreeSet<RealEstate> stock = new TreeSet<>();

    RealEstateAgent() {

       // read("realestates.txt");
        read("boss.txt");

    }

    /**
     * addEstate - adds an estate to the stock
     * @param pieces
     */
        public void addEstate (String[]pieces){
            Genre newGenre = parse(pieces[5]);

            RealEstate estate1 = new RealEstate(pieces[1], Double.parseDouble(pieces[2]), Integer.parseInt(pieces[3]),
                    Double.parseDouble(pieces[4]), newGenre);

            stock.add(estate1);
        }

    /**
     * addPanel - adds a Panel to the stock
     * @param pieces
     */
        public void addPanel (String[]pieces){
            Genre newGenre = parse(pieces[5]);
            boolean Ins = true;
                Ins = parse_bool(pieces[6]);

            Panel panel1 = new Panel(pieces[1], Double.parseDouble(pieces[2]), Integer.parseInt(pieces[3]),
                    Double.parseDouble(pieces[4]), newGenre, Integer.parseInt(pieces[6]), Ins);
            LOGGER.log(Level.INFO,"Panel added to the stock");
            stock.add(panel1);
        }

    /**
     * parse_bool - checks for true or false
     * @param insulated
     * @return true if yes and false if no
     */
        public boolean parse_bool (String insulated){
            LOGGER.log(Level.INFO, "Changing 'yes' to 'true'");
            if (String.valueOf(insulated).equals("yes")) {
                return true;
            }
            return false;
        }

    /**
     * parse- parses the string value of genre to an actual genre value
     * @param genre
     * @return Genre type, Farm by default
     */
    public Genre parse (String genre){

            try {

                LOGGER.log(Level.INFO,"Read genre type to console");
                return Genre.valueOf(genre.toUpperCase());

            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.SEVERE,"Invalid genre type");
                return Genre.FARM;
            }
        }

    /**
     * read - reads contents in a text file and adds it to the stock
     * @param filename
     */
    public void read(String filename) {

        LOGGER.log(Level.INFO, "Reading contents of " + filename+" to add to stock");
        File myObj = new File(filename);
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] pieces = data.split("#");

                if (pieces.length != 6 && pieces.length != 8) {
                    LOGGER.log(Level.SEVERE,"Invalid String length: {0} \n Should be either 6 or 8",pieces.length);
                    throw new IllegalArgumentException("Invalid input format: expected 6 or 8 parts but found " + pieces.length);
                }

                if (pieces.length == 6) {
                    if (!"REALESTATE".equals(pieces[0])) {
                        LOGGER.log(Level.SEVERE,"Expected REALESTATE but found: " + pieces[0]);
                        throw new IllegalArgumentException("Expected REALESTATE but found: " + pieces[0]);
                    }
                    addEstate(pieces);
                } else if (pieces.length == 8) {
                    if (!"PANEL".equals(pieces[0])) {
                        LOGGER.log(Level.SEVERE,"Expected PANEL but found: " + pieces[0]);
                        throw new IllegalArgumentException("Expected PANEL but found: " + pieces[0]);
                    }
                    addPanel(pieces);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            LOGGER.log(Level.SEVERE,"File not found: " + filename);
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }



        }






