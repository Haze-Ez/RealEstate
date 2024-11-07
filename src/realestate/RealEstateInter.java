package realestate;

public interface RealEstateInter {

    double makeDiscount(int percent);

     int getTotPrice();

    double avgsqmperroom();


    default String tostring(){
        return "";
    }


}
