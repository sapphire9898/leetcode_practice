public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length() == 0) return res;
        HashSet<Character> set = new HashSet<Character>();
        set.addAll(Arrays.asList('-','+','*'));

        for (int i = 0; i < input.length(); i++) {
            if (i != 0 && i != input.length() - 1 && set.contains(input.charAt(i))) {
                for (int num1 : diffWaysToCompute(input.substring(0, i))) {
                    for (int num2 : diffWaysToCompute(input.substring(i + 1))) {

                        switch (input.charAt(i)) {
                            case '+' : res.add(num1 + num2);
                                break;
                            case '-' : res.add(num1 - num2);
                                break;
                            case '*' : res.add(num1 * num2);
                                break;
                            default:break;
                        }
                    }
                }

            }
        }

        if (res == null || res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        Collections.sort(res);
        return res;
    }
}