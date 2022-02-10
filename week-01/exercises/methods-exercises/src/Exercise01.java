public class Exercise01 {

    public static void main(String[] args) {

        String firstCompliment = getRandomCompliment();
        System.out.println(firstCompliment);

        // Call the getRandomCompliment method two more times.
        // 1. Store the result in a new string variable.
        // 2. Print the result.
        // 3. Print the value returned directly without an intermediate variable.
    }

    public static String getRandomCompliment() {
        String result = "";



        switch ((int)(Math.random() * 10)) {
            case 0:
                result = "Your hard work is inspiring.";
                break;
            case 1:
                result =  "Your outfit is cute.";
                break;
            case 2:
                result = "You're a very nice person.";
                break;
            case 3:
                result = "Great attitude. Keep going!";
                break;
            case 4:
                result = "You always know how to put a smile on my face.";
                break;
            case 5:
                result = "Well done!";
                break;
            case 6:
                result = "Excellent job.";
                break;
            case 7:
                result = "Thank you for your kindness.";
                break;
            case 8:
                result = "Bravo.";
                break;
            case 9:
                result = "Really, really great.";
                break;
        }

        return result;
    }
}
