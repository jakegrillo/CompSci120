
import java.util.Scanner;
//-----------------------------------------
public class dentistTest {
    //-----------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int NUMBER_OF_ROWS = 2;

    //-----------------------------------------
    public static void main(String args[]) {
        System.out.println("Welcome to the Floridian Tooth Records\n--------------------------------------\n");

        int[][][] myCube;
        int numberOfPlanes;

//--Get number of family members---------------------------
        System.out.print("How many family members? : ");
        numberOfPlanes = keyboard.nextInt();

        //--make sure family no greater than 5-
        while (numberOfPlanes > 5 || numberOfPlanes < 1) {
            System.out.println("Invalid number of people, try again: ");
            numberOfPlanes = keyboard.nextInt();
        }

//--Fill in 3D array Z and Y axis--------------------------
        String[] famMembers = new String[numberOfPlanes];
        myCube = new int[numberOfPlanes][NUMBER_OF_ROWS][];

//--family members and teeth-------------------------------
        int i, j;
        int z = 0;
        String uppers, lowers;
        char[] upperS, lowerS;
        Boolean yeet = true;

        for (i = 0; i < myCube.length; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + " ");
            famMembers[i] = keyboard.next().toUpperCase();
//--uppers-------------------------------------------------
            System.out.print("Please enter the uppers for " + famMembers[i] + " ");
            uppers = keyboard.next().toUpperCase();
            upperS = uppers.toCharArray();

//--if too many teeth-------------------------------------
            while (upperS.length > 10) {
                System.out.print("Invalid amount of teeth, try again ");
                uppers = keyboard.next().toUpperCase();
                upperS = uppers.toCharArray();
            }
            myCube[i][0] = new int[upperS.length];

//--checking uppers are correct----------------------------
            while (z < upperS.length && yeet) {
                switch (upperS[z]) {
                    case 'M':
                    case 'C':
                    case 'B':
                        z++;
                        break;
                    default:
                        z = 0;
                        yeet = false;
                        break;
                }
            }
//--if incorrect upper teeth are entered...----------------
            while (!yeet) {
                System.out.println("incorrect teeth, try again");
                System.out.print("Please enter the uppers for " + famMembers[i] + " ");
                uppers = keyboard.next().toUpperCase();
                upperS = uppers.toCharArray();

                while (upperS.length > 10) {
                    System.out.print("Invalid amount of teeth, try again ");
                    uppers = keyboard.next().toUpperCase();
                    upperS = uppers.toCharArray();
                }
                myCube[i][0] = new int[upperS.length];

//--check again--------------------------------------------
                do {
                    switch (upperS[z]) {
                        case 'M':
                        case 'C':
                        case 'B':
                            yeet = true;
                            z++;
                            break;
                        default:
                            z = 0;
                            yeet = false;
                            break;
                    }
                } while (z < upperS.length && yeet);
            }

            for (j = 0; j < upperS.length; j++) {
                myCube[i][0][j] = upperS[j];
                z = 0;
            }

//--lowers ---------------------------------
            System.out.print("Please enter the lowers for " + famMembers[i] + " ");
            lowers = keyboard.next().toUpperCase();
            lowerS = lowers.toCharArray();
            while (lowerS.length > 10) {
                System.out.print("Invalid amount of teeth, try again ");
                lowers = keyboard.next().toUpperCase();
                lowerS = lowers.toCharArray();
            }
            myCube[i][1] = new int[lowerS.length];

//--checking lowers are correct----------------------------
            while (z < lowerS.length && yeet) {
                switch (lowerS[z]) {
                    case 'M':
                    case 'C':
                    case 'B':
                        z++;
                        break;
                    default:
                        z = 0;
                        yeet = false;
                        break;
                }
            }
//--if incorrect lower teeth are entered-------------------
            while (!yeet) {
                System.out.println("Incorrect teeth, try again");
                System.out.print("Please enter the lowers for " + famMembers[i] + " ");
                lowers = keyboard.next().toUpperCase();
                lowerS = lowers.toCharArray();
                while (lowerS.length > 10) {
                    System.out.print("Invalid amount of teeth, try again ");
                    lowers = keyboard.next().toUpperCase();
                    lowerS = lowers.toCharArray();
                }
                myCube[i][1] = new int[lowerS.length];
//--check again--------------------------------------------
                do {
                    switch (lowerS[z]) {
                        case 'M':
                        case 'C':
                        case 'B':
                            yeet = true;
                            z++;
                            break;
                        default:
                            z = 0;
                            yeet = false;
                            break;
                    }
                } while (z < lowerS.length && yeet);
            }
            for (j = 0; j < lowerS.length; j++) {
                myCube[i][1][j] = lowerS[j];
                z = 0;
            }
        } //--end of for loop for populating array---------
        options(myCube, famMembers);
    }

    //--options method-----------------------------------------
    private static void options(int[][][] cubic, String[] famu) {
        String whichOption;
        Boolean beet;
        System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it: ");
        whichOption = keyboard.next().toUpperCase();

//--Make sure input is correct, and push to method-----------
        switch (whichOption.charAt(0)) {
            case 'P':
                beet = true;
                pRint(cubic, famu);
                break;
            case 'E':
                beet = true;
                extract(cubic, famu);
                break;
            case 'R':
                beet = true;
                root(cubic, famu);
                break;
            case 'X':
                beet = true;
                System.out.println("\nExiting the Floridian Tooth Records :-)");
                break;
            default:
                beet = false;
                break;
        }

//--If incorrect letter is entered-------------------------
        while (!beet) {
            System.out.print("Invalid menu option, try again: ");
            whichOption = keyboard.next().toUpperCase();

            switch (whichOption.charAt(0)) {
                case 'P':
                    beet = true;
                    pRint(cubic, famu);
                    break;
                case 'E':
                    beet = true;
                    extract(cubic, famu);
                    break;
                case 'R':
                    beet = true;
                    root(cubic, famu);
                    break;
                case 'X':
                    beet = true;
                    System.out.println("\nExiting the Floridian Tooth Records :-)");
                    break;
                default:
                    beet = false;
                    break;
            }
        }
    }

    //--Method for print---------------------------------------
    private static void pRint(int[][][] cube, String[] family) {
        int z, x, y;
        for (z = 0; z < family.length; z++) {
            System.out.println("\n\n" + family[z]);
            for (x = 0; x < cube[z][0].length; x++) {
                if (x == 0) {
                    System.out.print("Uppers: ");
                }
                System.out.print(x + 1 + ":" + (char) cube[z][0][x] + " ");
            }
            System.out.print("\n");
            for (y = 0; y < cube[z][1].length; y++) {
                if (y == 0) {
                    System.out.print("Lowers: ");
                }
                System.out.print(y + 1 + ":" + (char) cube[z][1][y] + " ");
            }
        }
        System.out.print("\n");
        options(cube, family);
    }

    //--Method for Root----------------------------------------
    private static void root(int[][][] cube, String[] family) {
        int i, d, f;
        double u, l;
        double m = 0;
        double c = 0;
        double b = 0;
        for (i = 0; i < cube.length; i++) {
            for (d = 0; d < cube[i].length; d++) {
                for (f = 0; f < cube[i][d].length; f++) {
                    switch (cube[i][d][f]) {
                        case 'M':
                            ++m;
                            break;
                        case 'B':
                            ++b;
                            break;
                        case 'C':
                            ++c;
                            break;
                        default:
                            System.out.print("something went wrong");
                            break;
                    }
                }
            }

        }
        u = (-c + Math.sqrt(Math.pow(c, 2) - (4 * b * -m))) / (2 * b);
        l = (-c - Math.sqrt(Math.pow(c, 2) - (4 * b * -m))) / (2 * b);
        System.out.printf("\nOne root canal at : %+5.2f \n", u);
        System.out.printf("Another root canal at : %5.2f \n \n", l);
        options(cube, family);
    }

    //--Method for Extract-------------------------------------
    private static void extract(int[][][] cube, String[] family) {
        String familyMem;
        char[] input, pastInput;
        Boolean leet = true;
        int i, j, k;
        int l = -1;
        System.out.print("Which family member? ");
        familyMem = keyboard.next().toUpperCase();
        input = familyMem.toCharArray();

//--check fam member exists------------------------------------
        for (i = 0; i < family.length; i++) {
            pastInput = family[i].toCharArray();
            j = pastInput.length;
            k = input.length;
            l++;
            if ((int) input[0] == (int) pastInput[0] && k == j && (int) input[k - 1] == (int) pastInput[j - 1]) {
                leet = false;
            }
        }
        while (leet) {
            System.out.print("Invalid family member, try again ");
            familyMem = keyboard.next().toUpperCase();
            input = familyMem.toCharArray();
            for (i = 0; i < family.length; i++) {
                pastInput = family[i].toCharArray();
                j = pastInput.length;
                k = input.length;
                if ((int) input[0] == (int) pastInput[0] && j == k) {
                    leet = false;
                }
            }
        }
//--choosing layer-----------------------------------------
        char toothLayer;
        String layer;
        System.out.print("Which tooth layer? (U)pper or (L)ower ");
        layer = keyboard.next().toUpperCase();
        toothLayer = layer.charAt(0);

        while (toothLayer != 85 && toothLayer != 76) {
            System.out.print("Invalid layer, try again ");
            layer = keyboard.next().toUpperCase();
            toothLayer = layer.charAt(0);
        }
//--set upper or lower-------------------------------------
        int row;
        if (toothLayer == 85) {
            row = 0;
        } else {
            row = 1;
        }
//--tooth number--------------------------------------------
        int tooth, t;
        Boolean sneet = true;
        t = cube[l][row].length;
        System.out.print("Which tooth number? ");
        tooth = keyboard.nextInt();
        int[] teeth = new int [tooth];

//--setting invalid teeth----------------------------------
       do {
           if (teeth.length > t) {
               do {
                   System.out.print("Invalid tooth, try again ");
                   tooth = keyboard.nextInt();
                   teeth = new int[tooth];
               } while (teeth.length > t);
           }
           sneet = true;
           if (77 == cube[l][row][tooth - 1]) {
               do {
                   System.out.print("Missing tooth, try again ");
                   tooth = keyboard.nextInt();
                   teeth = new int[tooth];
                   sneet = false;
                   if (teeth.length > t) {
                       do {
                           System.out.print("Invalid tooth, try again ");
                           tooth = keyboard.nextInt();
                           teeth = new int[tooth];
                       } while (teeth.length > t);
                   }
               } while (77 == cube[l][row][tooth - 1]);
           }
       }while(!sneet);

        System.out.println("Extracting...");
        options(cube, family);
    }
}


