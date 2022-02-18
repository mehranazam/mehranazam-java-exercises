import java.util.ArrayList;

// Any symbol can be used inside the <>.
// Here, the T stands for "type" -- the dependent type.
public class GenericType<T> {
    // The field's type varies between instance.
    // Each instance can have its own type.
    public T value;


    public static void main(String[] args) {


    GenericType<String> one = new GenericType<String>();
    one.value = "one's value is a String";

//    GenericType<NationalForest> two = new GenericType<NationalForest>();
//// two's value is a NationalForest
//    two.value = new NationalForest("Angelina", "Texas", 154140);

    GenericType<int[]> three = new GenericType<int[]>();
// Generic types are truly generic. They can use any type.
// Here, value is an int[].
    three.value = new int[] { 1, 3, 5, 7, 9 };





}
  }