import java.util.ArrayList;
import java.util.Arrays;


public class Exercise14<DreamCars> {
    public String value;


    public void main(String[] args) {


        ArrayList<String> cars = new ArrayList<>();


        Exercise14<String> one = new Exercise14<String>();
        one.value = "Toyota Supra";


        Exercise14<String> two = new Exercise14<String>();
        two.value = "BMW M3";


        Exercise14<String> three = new Exercise14<String>();
        three.value = "C5 Corvette";


        Exercise14<String> four = new Exercise14<String>();
        four.value = "Toyota Land Cruiser";


        Exercise14<String> five = new Exercise14<String>();
        five.value = "Lamborghini Diablo";

        cars.add(new String (String.valueOf(one)));
        cars.add(new String (String.valueOf(two)));
        cars.add(new String (String.valueOf(three)));
        cars.add(new String (String.valueOf(four)));
        cars.add(new String (String.valueOf(five)));

        System.out.println(cars);





    }
}
