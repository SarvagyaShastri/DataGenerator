public class CoinChangeOne {


    public static void main(String args[]) {
        DataGeneratorUtil dataGeneratorUtil = new DataGeneratorUtil(50, true);
        int N = dataGeneratorUtil.randomInteger(5, 15);
        int[] coins = dataGeneratorUtil.generateIntegerArrayWithUniqueElements(4, 1, N);
        System.out.println(findWays(N, coins));
    }

    private static int findWays(int n, int[] coins) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int coin: coins
             ) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[n];
    }
}
