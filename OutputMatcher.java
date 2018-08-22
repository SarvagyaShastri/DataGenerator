
import java.util.Random;

public class OutputMatcher {
    public static void main(String[] args) {
        DataGeneratorUtil dataGeneratorUtil = new DataGeneratorUtil(0, true);
        int numTests = 10;
        int minInputNumber = 0;
        int maxInputNumber = 32767;
        Random r = new Random();

        for (int i = 1; i < numTests; i++) {
            int n = dataGeneratorUtil.randomInteger(minInputNumber, maxInputNumber);
            long before = System.currentTimeMillis();
            int ourOutput = FriendsPairing.findWays(n);
            long timeTakenByCode = (System.currentTimeMillis() - before);

            before = System.currentTimeMillis();
            int solutionOutput = GFG.countFriendsPairings(n);
            long timeTakenBySolution = (System.currentTimeMillis() - before);

            if (timeTakenByCode > timeTakenBySolution) System.out.println(String.format("Your code took %s ms more time than solution", (timeTakenByCode - timeTakenBySolution)));
            else System.out.println(String.format("Your code took %s ms less time than solution", (timeTakenBySolution - timeTakenByCode)));

            if (ourOutput == solutionOutput) {
                System.out.println("Testcase passed");
            } else {
                System.out.println("Testcase Failed");
            }
            dataGeneratorUtil.reset(r.nextInt(), true);
        }
    }
}
