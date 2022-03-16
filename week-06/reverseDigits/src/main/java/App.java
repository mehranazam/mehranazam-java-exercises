public class App {

    public static void main(String[] args) {

        System.out.println(reverseDigits(5));
        System.out.println(reverseDigits(12));
        System.out.println(reverseDigits(20));
        System.out.println(reverseDigits(120));
        System.out.println(reverseDigits(125));
    }

    public static int reverseDigits(int toReverse){
        int reversedDigit = 0;
        while(toReverse != 0){
            int digit = toReverse % 10;
            reversedDigit = reversedDigit * 10 + digit;
            toReverse /= 10;
        }
//            if(toReverse < 10){
//                return toReverse;
//            }else if(toReverse % 10 == 0 && toReverse < 101){
//                return toReverse / 10;
//            }else if(toReverse % 3 == 0){
//                return ;
//            }else if(toReverse % 5 == 0 && toReverse % 10 == 5){
//
//            }else if(toReverse % 11 == 0){
//                return toReverse;
//            }
        return reversedDigit;
    }
}
