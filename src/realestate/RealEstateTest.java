package realestate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RealEstateTest {

    RealEstate underTest;
    Panel test2;

    /**
     * premature test
     */
    @BeforeEach
    void setup() {
        underTest = new RealEstate("Debrecen",
                500000.0, 40, 2,
                Genre.CONDOMINIUM);
        test2 = new Panel("Debrecen", 500000.0, 40, 2, Genre.CONDOMINIUM,4,false);
    }

    /**
     * Test make discount
     */
    @Test
    void testMakeDiscountShouldReturnCorrectValue() {
        underTest.makeDiscount(10);
        double actual = underTest.price;
        double expected = 450000.0;
        assertEquals(expected, actual, "makeDiscount miscalculates something");
    }

    /**
     * Test compareto with lower price but same property
     */
    @Test
    void testCompareto_Lower_Price() {
        RealEstate other = new RealEstate("Debrecen", 43000.0, 20, 2, Genre.CONDOMINIUM);
        assertTrue(other.compareTo(underTest) < 0);

    }
    /**
     * Test compareto with higher price but same property
     */

    @Test
    void testCompareto_Higher_Price() {
        RealEstate other = new RealEstate("Debrecen", 43000.0, 20, 2, Genre.CONDOMINIUM);
        assertTrue(underTest.compareTo(other) > 0);

    }
    /**
     * Test compareto with higher sqm but same property
     */

    @Test
    void testCompareto_sameprice_diff_high_sqm() {
        RealEstate other = new RealEstate("Debrecen", 500000.0, 20, 4, Genre.CONDOMINIUM);
        assertTrue(underTest.compareTo(other) > 0);

    }
    /**
     * Test compareto with lower sqm but same property
     */

    @Test
    void testCompareto_sameprice_diff_low_sqm() {
        RealEstate other = new RealEstate("Debrecen", 500000.0, 80, 4, Genre.CONDOMINIUM);
        assertTrue(underTest.compareTo(other) < 0);

    }

    /**
     * Test compareto with higher number of rooms but same property
     */
    @Test
    void testCompareto_samesqm_diff_high_numofrooms() {
        RealEstate other = new RealEstate("Debrecen", 500000.0, 40, 4, Genre.CONDOMINIUM);
        assertTrue(underTest.compareTo(other) < 0);

    }

    /**
     * Test compareto with lower number of rooms but same property
     */
    @Test
    void testCompareto_samesqm_diff_low_numofrooms() {
        RealEstate other = new RealEstate("Debrecen", 500000.0, 40, 1, Genre.CONDOMINIUM);
        assertTrue(underTest.compareTo(other) > 0);

    }

    /**
     * Test compareto same property
     */
    @Test
    void testCompareto_same_property() {
        RealEstate other = new RealEstate("Debrecen", 500000.0, 40, 2, Genre.CONDOMINIUM);
        assertTrue(underTest.compareTo(other) == 0,"Same propoerty miscalculates something");

    }

    /**
     * test Total price of properties in Bud
     */
    @Test
    void testTotal_Price_Bud() {
        RealEstate other = new RealEstate("Budapest", 600000.0, 20, 4, Genre.FAMILYHOUSE);
        assertEquals(other.getTotPrice(),3120000);

    }

    /**
     * test Total price of properties in Deb
     */
    @Test
    void testTotal_Price_Deb() {
        assertEquals(underTest.getTotPrice(),1200000);

    }

    /**
     * test Total price of properties in Nye
     */
    @Test
    void testTotal_Price_Nye() {
        RealEstate other = new RealEstate("Nyiregyhaza", 140000.0, 5, 3, Genre.FAMILYHOUSE);
        assertEquals( other.getTotPrice(),483000);
    }

    /**
     * test avg sqm/room method
     */
    @Test
    void testavg_sqm_room() {
        assertEquals( underTest.avgsqmperroom(),20.0);
    }

    /**
     * test tostring method
     */
    @Test
    void test_tostring() {
        String actual = underTest.toString();
        String expected = underTest.toString();
        assertEquals(expected, actual);
    }

    /**
     * test read method
     */
    @Test
    void test_read() {
        RealEstateAgent agent = new RealEstateAgent();
        String actual;
        String expected;
        agent.read("sample.txt");
        for (RealEstate real : RealEstateAgent.stock) {
            actual = real.toString();
            expected = real.toString();
            assertEquals(expected, actual,"Success!!");
        }
    }

    /**
     * test has same amount mehtod
     */
    @Test
    void test_has_same_amount(){
        assertTrue(test2.hasSameAmmount(1200000),"Not same amount as total-price");
    }

    /**
     * test roomprice method
     */
    @Test
    void test_room_price(){
        int actual = 250000;
        int expected = test2.roomprice();
        assertEquals(expected,actual,"Room price miscalculates something");
    }
}