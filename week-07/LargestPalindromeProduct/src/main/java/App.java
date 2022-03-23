public class App {
    public static void main(String[] args) {
        int highestProduct = 0;
        int highestI = 0;
        int highestJ = 0;

        int product = 0;
        for(int i = 999; i >= 100; i--){
            for(int j = 999; j >= 100; j--){
                product = i * j;
                if(isPalindrome(product) && product > highestProduct){
                   highestProduct = product;
                   highestI = i;
                   highestJ = j;
                }

            }
        }
        System.out.printf("%s * %s = %s", highestI, highestJ, highestProduct);
    }


//    public static boolean toString(int product){
//        String product1 = Integer.toString(product);
//        boolean result = false;
//        for(int i = 0; i < product1.length(); i++) {
//            for (int j = product1.length() - 1; i >= 0; i--) {
//                if (product1.substring(i, i + 1).equals(product1.substring(j -1, j))) {
//                    product = Integer.parseInt(product1);
//                    result = true;
//                }
//
//            }
//        }
//        return result;
//    }

    public static boolean isPalindrome(int x){
        return x == reverseDigits(x);
    }

    private static int reverseDigits(int toReverse) {

        int reversed = 0;
        while(toReverse != 0){
            reversed *= 10;
            reversed += toReverse % 10;
            toReverse /= 10;
        }
        return reversed;
    }
}
