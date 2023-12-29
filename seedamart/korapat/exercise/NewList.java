package seedamart.korapat.exercise;
import java.util.*;
public class NewList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("BMW");
        cars.add("BENZ");
        cars.add(0,"bb");
        cars.remove("bb");
        System.err.println(cars);

    }
}
