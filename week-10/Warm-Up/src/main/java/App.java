import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        scoreArr();
    }



    public static void scoreArr(){
        try(BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))){
            String[] names = null;

            int value = 0;
            int sum = 0;

            String line = reader.readLine();
            String nameLine = line.replaceAll("\"", "");
                names = nameLine.split(",");

            Arrays.sort(names);

//            for(String name : names){
//                System.out.println(name);
//            }

            for(int i = 0; i < names.length; i++){
                value = sumString(names[i]) * (i + 1);
                sum += value;
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFilePath() {
        return Paths.get("./data/names.txt").toString();
    }

    public static int sumString(final String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') { // <-- validate input
                sum += 1 + ch - 'A';      // <-- 'A' - 'A' == 0, 'B' - 'A' == 1, etc.
            }
        }
        return sum;
    }
}
