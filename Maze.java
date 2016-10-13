package com.example.java;

/**
 * Created by yueyangzou on 16/10/10.
 */
public class Maze {

    public boolean isValid(int[][] rooms) {
        if (rooms == null || rooms.length < 1 || rooms[0] == null || rooms[0].length < 1) return false;
        if (rooms.length == 1 && rooms[0].length == 1) return true;

        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];


        visited[m - 1][n - 1] = true;


        helper(rooms, m - 2, n - 1,  visited);
        helper(rooms, m - 1, n - 2, visited);

        return visited[0][0];



    }
    private void helper(int[][] rooms, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || visited[i][j]) return;
        if (rooms[i][j] == 5) return;

        visited[i][j] = true;

        helper(rooms, i + 1, j, visited);
        helper(rooms, i - 1, j, visited);
        helper(rooms, i, j + 1, visited);
        helper(rooms, i, j - 1, visited);


    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        System.out.println(maze.isValid(new int[][]{{1,5,5,5,5,0}, {0,5,0,5,5,5}, {0,5,0,0,0,5}, {0,5,0,0,5,0}, {0,0,0,5,0,9}}));
    }
}
