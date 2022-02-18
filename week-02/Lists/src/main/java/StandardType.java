public class StandardType {
    // The field's type is a String.
    // It can't change.
    public String value;

    public static void main(String[] args) {


    StandardType one = new StandardType();
    one.value = "this field is always a string";

    StandardType two = new StandardType();
    two.value = "it can only ever be a string";

    StandardType three = new StandardType();
    three.value = "yup, still a string";
}
}