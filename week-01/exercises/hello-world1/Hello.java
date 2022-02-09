public class Hello {

  public static void main(String[] args) {


      String hello = "Hello World!";
      System.out.println(hello);

      System.out.println("What's your name?");
      Scanner scanner = new Scanner(System.in);
      String name = scanner.nextLine();

      System.out.println("What's your birth year?");
      int birthYear = scanner.nextInt();

      int age = 2022 - birthYear;

      System.out.println("Hello " + name + ". " + "You are " + age + " years old.");
  }

}