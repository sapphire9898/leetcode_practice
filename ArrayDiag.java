/**
 * Created by yueyangzou on 16/10/10.
 */
public class PrintArrayDiag {
    public void printArray(int[][] arr) {
        if (arr == null || arr.length == 0) return;
        int m = arr.length, n = arr[0].length;

        for (int i = 0; i < m + n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < m && i - j >= 0 && i - j < n) System.out.print(arr[j][i - j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        new PrintArrayDiag().printArray(new int[][]{{1,2,3,4}, {5,6,7,8}, {9, 10, 11, 12}});
    }
}