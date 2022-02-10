public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(isBetween(22, 21, 23));
        System.out.println(isBetween(2, 3, 4));
        System.out.println(isBetween(56, 52, 54));

    }

    public static boolean isBetween (int a, int b, int c){

        boolean betweenTwoAndThree = false;
        if(a > b && a < c){
            betweenTwoAndThree = true;
        }else{
            betweenTwoAndThree = false;
        }
        return betweenTwoAndThree;
    }
}
