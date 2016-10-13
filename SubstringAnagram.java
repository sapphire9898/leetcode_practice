package com.example.java;

/**
 * Created by yueyangzou on 16/10/10.
 */
public class SubStringAnagram {
    public boolean isValid(String astr, String bstr) {
        if (astr == null || astr.length() == 0 || bstr == null || bstr.length() == 0 || astr.length() < bstr.length()) return false;
        int n = bstr.length();
        int[] map = new int[256];
        for (char c : bstr.toCharArray()) {
            map[c]++;
        }
        int i = 0;
        int[] map2 = new int[256];
        for (; i < bstr.length(); i++) {
            map2[astr.charAt(i)]++;
        }
        if (checkMap(map, map2)) return true;
        
        while (i < astr.length()) {
            --map2[astr.charAt(i - n + 1)];
            ++map2[astr.charAt(i)];
            if(checkMap(map, map2)) return true;
            i++;
        }
        
        return false;
    }

    private boolean checkMap(int[] map1, int[] map2) {
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SubStringAnagram subStringAnagram = new SubStringAnagram();
        System.out.println(subStringAnagram.isValid("efdcdfae", "afe"));
    }
}
