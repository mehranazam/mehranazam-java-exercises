public class Exercise10 {
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.

    public static void main(String[] args) {
        System.out.println(removeWhitespace("Who am I? I'm Spider-Man."));
        System.out.println(removeWhitespace("My favorite car is the BMW M3."));
        System.out.println(removeWhitespace("My sister's weird."));
        System.out.println(removeWhitespace("Hello \t\t\t World!"));
    }

    public static String removeWhitespace(String phrase){
        String withoutWhitespace = "";
        for(int i = 0; i < phrase.length(); i++){
            if(phrase.charAt(i) != ' ' && phrase.charAt(i) != '\t'){
                withoutWhitespace += phrase.charAt(i);
            }
        }
        return withoutWhitespace;
    }
}
