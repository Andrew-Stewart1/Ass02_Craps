import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps {
    public static int roll (int d1, int d2) {
        Random randomGenerator = new Random();
        int dice1 = randomGenerator.nextInt(6) + 1;
        int dice2 = randomGenerator.nextInt(6) + 1;

        System.out.println("Roll 1 = " + dice1 + " Roll 2 = " + dice2);

        int score = dice1 + dice2;
        return score;
    }
    public static void main(String[] args) {
        int dice1 = 0;
        int dice2 = 0;
        int newScore = 0;
        int point = 0;
        boolean done = false;
        String userResp = "";
        Scanner scanner = new Scanner(System.in);

do {
    System.out.println("Do you want to play again [Y/N]");
    userResp = scanner.nextLine(); //receive a string input from the user
    if(userResp.equalsIgnoreCase("N"))
        done = true;


        for (int i = 0; i < 2; i++)
        {
            System.out.println ("Roll the Dices!!");
            int score = roll (dice1, dice2);
            System.out.println ("Score " + score);

            if (score == 11 || score == 7)
            {
                System.out.println ("Score = " + score);
                System.out.println ("You won with a natural!");
            }
            if (score == 2 || score == 3 || score == 12)
            {
                System.out.println ("Score = " + score);
                System.out.println ("You crapped out :(");
            }
            else if (score == 4 || score == 5 || score == 6 || score == 8 || score == 9 || score == 10) {
                point = point + score;
                System.out.println("Points = " + point);

                do {
                    newScore = roll(dice1, dice2);
                    System.out.println("Your new score is = " + newScore);
                    if (newScore == point) {
                        System.out.println("You made point and won!");
                        point = 0;
                        break;
                    }
                    if (newScore == 7) {
                        System.out.println("You got a 7 lost");
                        point = 0;
                        break;
                    }
                } while (newScore != point || newScore != 7);
            }

            }
        }while(!done);
    }
}
