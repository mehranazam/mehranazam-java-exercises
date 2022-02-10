public class App {
    public static void main(String[] args) {
        int a = 15;
        int b = 3;

        int quotient = a / b;
        int remainder = a - (quotient * b);

        int ezRemainder = a % b;

        if(remainder == 0){
            System.out.println("a is divisible by b");
        }

        if(ezRemainder == 0){
            System.out.println("a is divisible by b");
        }
    }
}
