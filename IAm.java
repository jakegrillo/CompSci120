import java.util.Objects;
import java.util.Scanner;
public class IAm {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String iAm = "";
        String[] weAre = new String [99];
        int l = 0;
        System.out.println("Please enter sentences, . to end. ");
        while(true) {
            iAm = keyboard.nextLine();
            if (iAm.equals(".")) {
                break;
            }
            if (iAm.startsWith("I am")) {
                weAre[l] = iAm.substring(5) + ", ";
                l++;
            }
        }
        int i;
        System.out.print("The qualities are ");
        for(i=0;i<l;i++){
            System.out.print(weAre[i]);
        }
    }
    }