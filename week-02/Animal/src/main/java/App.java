public class App {
    public static void main(String[] args) {
        //Animal interface

        // getKingdom()
        // getPhylum()
        // getAnimalClass()
        // getOrder()
        // getFamily()
        // getGenus()
        // getSpecies()

        /*
        to get to GreyParrot we'll make base classes for
        Animal (kingdom)
        Aves (class)
        Psittaciforms (order)
        Psittacidae (family)
        Psittacus (genus)
         */

        /*
        Can't make just an anuimal
        Animals are abstract
        No such thing as just an animal
        It's always more specific
         */

       Animal parrot = new GreyParrot();
       Animal parakeet = new EmeraldParakeet();
       Animal hoopoe = new AfricanHoopoe();
       Creature totallyDifferent = new RobotDog();


//        System.out.println(a.getKingdom());
//        System.out.println(a.getPhylum());
//        System.out.println(a.getFamily());
//        System.out.println(a.getSpecies());

        /*
        casting is usually a code-smell
        this is for demonstration purposes only
         */
        AfricanHoopoe castedObject = (AfricanHoopoe)hoopoe;

        //now we have access to the getLocation() method
        System.out.println(castedObject.getLocation());


        printDetails(parrot);
        printDetails(parakeet);
        printDetails(hoopoe);
        printDetails(totallyDifferent);



    }

    public static void printDetails(Creature c){
        System.out.println("-------------------------");
        System.out.println(c.getKingdom());
        System.out.println(c.getPhylum());
        System.out.println(c.getFamily());
        System.out.println(c.getSpecies());

    }
}
