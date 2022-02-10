public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(areInOrder(2, 3, 4, 5));
        System.out.println(areInOrder(61, 62, 66, 60));
        System.out.println(areInOrder(42, 51, 60, 69));

    }

    public static boolean areInOrder (int a, int b, int c, int d){
        boolean ordered = false;
        if(a < b && b < c && c < d && d > a){
            ordered = true;
        }else{
            ordered = false;
        }
        return ordered;
    }


}
