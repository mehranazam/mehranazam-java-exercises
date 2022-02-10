public class Exercise08 {

    // 1. Create a method.
    // Name: getRandomFruit
    // Inputs: none
    // Output: String
    // Description: returns a random fruit name as a string.
    // See Exercise01.
    // Choose from at least 5 fruit.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.

        String randFruit = getRandomFruit();
        System.out.println(randFruit);

    }

    public static String getRandomFruit(){
        String fruit = "";
        switch((int) (Math.random() * 9 + 1)){
            case 1:
                fruit = "orange";
                break;
            case 2:
                fruit = "apple";
                break;
            case 3:
                fruit = "banana";
                break;
            case 4:
                fruit = "grapefruit";
                break;
            case 5:
                fruit = "blueberry";
                break;
            case 6:
                fruit = "raspberry";
                break;
            case 7:
                fruit = "mango";
                break;
            case 8:
                fruit = "guava";
                break;
            case 9:
                fruit = "watermelon";
                break;


        }
        return fruit;

    }

}
