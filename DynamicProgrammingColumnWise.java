import java.io.*;
import java.util.*;

public class DynamicProgrammingColumnWise {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            dp[0][j] = grid[0][j];
            for (int i = 1; i < rows; i++) {
                dp[i][j] = dp[i - 1][j] + grid[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}
