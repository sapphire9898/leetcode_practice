public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return Math.abs((C - A) * (D - B)) + Math.abs((G - E) * (F - H)) - helper(A, B, C, D, E, F ,G ,H);
    }


    private int helper(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int up = Math.min(D, H);
        int bottom = Math.max(B, F);

        return ((right <= left) || (up <= bottom)) ? 0 : (right - left) * (up - bottom);

    }
}
