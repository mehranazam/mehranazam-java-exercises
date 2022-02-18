public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        Musician sinatra = new Musician("Frank Sinatra", 10);
        Musician eminem = new Musician("Eminem", 10);
        System.out.println(ocean.getName() +  " " + ocean.getRating());
        System.out.println(sinatra.getName() + " " + sinatra.getRating());
        System.out.println(eminem.getName() + " " + eminem.getRating());
        // 2. Uncomment the line below and insure that it compiles and runs.
        // 3. Instantiate two musicians and assign them to new variables.
        // 4. Print each musicians' name and rating on a single line.
    }
}
