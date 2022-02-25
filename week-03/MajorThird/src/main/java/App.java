import java.util.Scanner;

public class App {

    public static void main(String[] args) {

    }

    private static String majorThirdEncoder(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter sequence: ");
        String sequence = scn.nextLine();
        String input = "";
        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == 'C') {
                input += 'E';
            }else if(sequence.substring(i, i + 1) == "C#") {
                    input += 'F';
            }else if(sequence.charAt(i) == 'D') {
                    input += "F#";
            }else 
                case "D#":
                    input += 'G';
                    break;
                case 'E':
                    input += "G#";
                    break;
                case 'F':
                    input += 'A';
                    break;
                case "F#":
                    input += "A#";
                    break;
                case 'G':
                    input += 'B';
                    break;
                case "G#":
                    input += 'C';
                    break;
                case 'A':
                    input += "C#";
                    break;
                case "A#":
                    input += 'D';
                    break;
                case 'B':
                    input += "D#";
                    break;

            }
        }
        return input;
    }


    private static void majorThirdComparer(){
        String input1 = majorThirdEncoder();
        String input2 = majorThirdEncoder();
        System.out.println(input1.equals(input2) ? "These two are equal" : "These two are NOT equal");
    }
}
