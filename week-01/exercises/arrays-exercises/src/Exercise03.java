public class Exercise03 {
    public static void main(String[] args) {
        String[] commonlyMisspelledWords = new String[5];

        commonlyMisspelledWords[0] = "indict";
        commonlyMisspelledWords[1] = "fiery";
        commonlyMisspelledWords[2] = "misspell";
        commonlyMisspelledWords[3] = "comparison";
        commonlyMisspelledWords[4] = "perseverance";


        for (int i = 0; i < commonlyMisspelledWords.length; i++) {
            System.out.println(commonlyMisspelledWords[i]);
        }

        // One of the commonlyMisspelledWords is misspelled.
        // (IntelliJ may help here. It highlights misspelled words.)
        // 1. Change it to the correct spelling. Don't alter the array literal declaration. Set the value by index.

        // 2. Loop a second time and confirm all five words are spelled correctly.
    }
}
