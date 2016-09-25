public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        result.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        
        result.append(n / d);
        n %= d;
        
         if (n == 0) {
            return result.toString();
        }
        result.append(".");
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(n, result.length());
        
        while (n != 0) {
            n *= 10;
            result.append(n / d);
            n = n % d;
            
            if (map.containsKey(n)) {
                int index = map.get(n);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            else {
                map.put(n, result.length());
            }
        }
        return result.toString();
        
        
        
        
        
        
    }
}