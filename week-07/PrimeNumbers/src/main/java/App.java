public class App {

    public static void main(String[] args) {
        isPrime();
    }

    public static void isPrime() {

        int count = 0;
        for(int num = 2; num < 105000; num++) {
            int m = num / 2;
            boolean isPrime = true;
                for (int i = 2; i <= m; i++) {

                int temp = num % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                count++;
                System.out.printf("%s: %s", count, num);
                System.out.println();
            }
        }
    }
}
