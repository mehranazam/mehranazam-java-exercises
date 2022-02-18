public class Exercise15 {

    // 1. Create a new method in the Hero class.
    // Name: toLine
    // Inputs: none
    // Output: String
    // Description: returns the Hero's name and powers as a single line of text.

    public static void main(String[] args) {

                Power spider = new Power("Spider-Sense");
                Power healing = new Power("Healing Factor");
                Power wealth = new Power("Wealth");
                Power fight = new Power("Martial Arts");
                Power skeleton = new Power("Adamantium skeleton");
                Power webs = new Power("Web spinners");

                Hero spiderman = new Hero("Spider-Man", new Power[] {spider, webs});
                Hero wolverine = new Hero("Wolverine", new Power[]{healing, skeleton});
                Hero batman = new Hero("Batman", new Power[]{wealth, fight});

        // 2. Instantiate your three favorite super heroes with appropriate powers.
        // 3. Use the `toLine` method to print each hero's details to the console.
        Hero.toLine(spiderman);
        Hero.toLine(batman);
        Hero.toLine(wolverine);

    }
}
