public class Ass02_Craps {
    public static void main(String[] args) {
        int dice1 = 0;
        int dice2 = 0;
        int scorenew = 0;
        int point = 0;
        int wins = 0;
        int loss = 0;

        for (int i = 0; i < 10000; i++)
        {
            System.out.println ("roll the dices");
            int score = roll (dice1, dice2);
            System.out.println ("\n score " + score);

            if (score == 11 || score == 7)
            {
                System.out.println ("\n Score = " + score);
                System.out.println ("you win");
                wins = wins + 1;
            }
            if (score == 2 || score == 3 || score == 12)
            {
                System.out.println ("\n Score = " + score);
                System.out.println ("you lose");
                loss = loss + 1;
            }
            else if (score == 4 || score == 5 || score == 6 || score == 8 || score == 9 || score == 10)
            {
                point = point + score;
                System.out.println ("\n Point = " + point);

                do
                {
                    scorenew = roll (dice1, dice2);
                    System.out.println ("\n Score new = " + scorenew);
                    if (scorenew == point)
                    {
                        System.out.println ("\n you win");
                        wins = wins + 1;
                        point = 0;
                        break;
                    }
                    if (scorenew == 7)
                    {
                        System.out.println ("\n you lose");
                        point = 0;
                        loss = loss + 1;
                        break;
                    }
                } while (scorenew != point || scorenew != 7);

            }
        }

        System.out.println ("\n number of wins = " + wins
                + " and number of loss = " + loss +
                " and the probability for winning a game = " + (double) wins / (wins + loss));
    }

    public static int roll (int d1, int d2)
    {
        Random randomGenerator = new Random ();
        int dice1 = randomGenerator.nextInt (6) + 1;
        int dice2 = randomGenerator.nextInt (6) + 1;

        System.out.println ("\n dice1 = " + dice1 + " dice2 = " + dice2);

        int score = dice1 + dice2;
        return score;
    }
    }
}
