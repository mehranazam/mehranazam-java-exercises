import java.io.*;

public class App {

    public static void main(String[] args) {
        File file = new File("colors.txt");
        boolean canRead = file.canRead();
        try {
            if (file.createNewFile()) {
                System.out.println("File created!");
            } else {

                System.out.println("File already exists.");
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }catch(IOException exception){
            System.out.println(exception);
        }

        writeToFile();

        readFromFile("colors.txt");

      if(deleteFile(file)){
          System.out.println("File has been deleted");
      }else{
          System.out.println("File was not deleted");
      }
    }

    private static boolean deleteFile(File file) {
        boolean result = file.delete();
        return result;
    }

    private static void readFromFile(String fileName) {
        System.out.println("File " + fileName + " Contents:");

        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
                System.out.println(line);
            }
        }catch(IOException exception){
            System.out.println("Exception: " + exception);
        }
    }

    private static void writeToFile() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("colors.txt");
            printWriter.println("Red");
            printWriter.println("Blue");
            printWriter.println("Yellow");

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }finally{
            if(printWriter != null){
                printWriter.close();
            }
        }
    }
}
