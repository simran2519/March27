//2.Problem statement
//        Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.
//
//        Note:
//        1. The sizes will range from 1 to ‘N’ and will be integers.
//
//        2. The sum of the pieces cut should be equal to ‘N’.
//
//        3. Consider 1-based indexing.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Constraints:
//        1 <= T <= 50
//        1 <= N <= 100
//        1 <= A[i] <= 100
//
//        Where ‘T’ is the total number of test cases, ‘N’ denotes the length of the rod, and A[i] is the cost of sub-length.
//
//        Time limit: 1 sec.
//        Sample Input 1:
//        2
//        5
//        2 5 7 8 10
//        8
//        3 5 8 9 10 17 17 20
//        Sample Output 1:
//        12
//        24
//        Explanation of sample input 1:
//        Test case 1:
//
//        All possible partitions are:
//        1,1,1,1,1           max_cost=(2+2+2+2+2)=10
//        1,1,1,2             max_cost=(2+2+2+5)=11
//        1,1,3               max_cost=(2+2+7)=11
//        1,4                 max_cost=(2+8)=10
//        5                   max_cost=(10)=10
//        2,3                 max_cost=(5+7)=12
//        1,2,2               max _cost=(1+5+5)=12
//
//        Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.
//
//
//        Test case 2:
//
//        Possible partitions are:
//        1,1,1,1,1,1,1,1         max_cost=(3+3+3+3+3+3+3+3)=24
//        1,1,1,1,1,1,2           max_cost=(3+3+3+3+3+3+5)=23
//        1,1,1,1,2,2             max_cost=(3+3+3+3+5+5)=22
//        and so on….
//
//        If we cut the rod into 8 pieces of length 1, for each piece 3 adds up to the cost. Hence for 8 pieces, we get 8*3 = 24.
//        Sample Input 2:
//        1
//        6
//        3 5 6 7 10 12
//        Sample Output 2:
//        18

package March27;
public class Q2 {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 2, 5, 7, 8, 10},
                {8, 3, 5, 8, 9, 10, 17, 17, 20},
                {6, 3, 5, 6, 7, 10, 12}
        };
        int[] lengths = {5, 8, 6};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(maximumCost(arr[i], lengths[i]));
        }
    }

    public static int maximumCost(int[] A, int N) {
        int[] dp = new int[N + 1];

        // Loop through each possible length
        for (int i = 1; i <= N; i++) {
            int maxCost = Integer.MIN_VALUE;
            // Loop through each possible cut
            for (int j = 1; j <= i; j++) {
                // Calculate the cost for the current cut and add it to the maximum cost of the remaining length
                maxCost = Math.max(maxCost, A[j - 1] + dp[i - j]);
            }
            // Update dp[i] with the maximum value obtained from all possible cuts
            dp[i] = maxCost;
        }

        return dp[N];
    }
}



