import java.util.Scanner;
public class rna {


    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter RNA sequence: ");
//        String rnaSequence = scn.nextLine();
//        pairing(rnaSequence);
//        System.out.println(rnaSequence);

        rnaComparer();
        rnaEncoder();

    }

    private static String rnaEncoder() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter RNA sequence: ");
        String rnaSequence = scn.nextLine();
        String rnaInput = "";
        for (int i = 0; i < rnaSequence.length(); i++) {
            if (rnaSequence.charAt(i) == 'A') {
                rnaInput += 'U';
            } else if (rnaSequence.charAt(i) == 'U') {
                rnaInput += 'A';
            } else if (rnaSequence.charAt(i) == 'G') {
                rnaInput += 'C';
            } else if (rnaSequence.charAt(i) == 'C') {
                rnaInput += 'G';
            }
        }
return rnaInput;
    }


    private static void rnaComparer() {
            String input1 = rnaEncoder();
            String input2 = rnaEncoder();
        System.out.println(input1.equals(input2) ? "These two strands are equal" : "These two strands are not equal.");
        }
    }

//    static void pairing(String rnaSequence){
//        for(int i = 0; i < rnaSequence.length(); i++){
//            if (rnaSequence.charAt(i) == 'A') {
//                rnaSequence.replace('A', 'U');
//            } else if (rnaSequence.charAt(i) == 'U') {
//                rnaSequence.replace('U', 'A');
//            } else if (rnaSequence.charAt(i) == 'G') {
//                rnaSequence.replace('G', 'C');
//            } else if (rnaSequence.charAt(i) == 'C') {
//                rnaSequence.replace('C', 'G');
//            }
//        }

  //  }

