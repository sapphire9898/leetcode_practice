public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i + 1, j, 0);
                    helper(rooms, i - 1, j, 0);
                    helper(rooms, i, j + 1, 0);
                    helper(rooms, i, j - 1, 0);
                }
            }
        }
    }
    

    private void helper(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1) return;
        if (rooms[i][j] == 0 || rooms[i][j] == -1 || rooms[i][j] <= distance) return;

        rooms[i][j] = Math.min(distance + 1, rooms[i][j]);

        helper(rooms, i + 1, j, distance + 1);
        helper(rooms, i - 1, j, distance + 1);
        helper(rooms, i, j + 1, distance + 1);
        helper(rooms, i, j - 1, distance + 1);
    }
}