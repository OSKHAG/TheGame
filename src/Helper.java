import java.util.Random;
import java.util.Scanner;

public class Helper {

    public static void clearConsole(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static int integerInput(int caseNum){
        Scanner sc = new Scanner(System.in);
        int val;
        while (true) {
            if (sc.hasNextInt()) {
                val = sc.nextInt();
                if (val >= 1 && val <= caseNum) {
                    break;
                } else {
                    System.out.println("Please input a valid value");
                }
            } else {
                System.out.println("Please input a valid value");
                sc.next();
            }
        }
        clearConsole();
        return val;
    }
    public static boolean diceRoll(){
        Random r = new Random();
        int num = r.nextInt(1, 6);
        return num >= 2;
    }

    public static int tenPercentStatIncrease(int val){
        return (int) (val * 1.1);
    }
}
