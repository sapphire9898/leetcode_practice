public class BigInt {
    
    String presentation;
    public BigInt(String str) {
        presentation = str;
    }
    public BigInt substract(BigInt first, BigInt second) {
        // we take that a is bigger than b;
        if (first == null && second == null) return null;
        if (second == null) return first;
        if (first == null) {
            second.presentation = "-" + second.presentation;
            return second;
        }
        if (Integer.valueOf(first.presentation) < Integer.valueOf(second.presentation)) {
            return new BigInt('-' + substract(second, first).presentation);
        }
        
        
        // subtract from the last digit. 
        int m = first.presentation.length();
        int n = second.presentation.length();
        
        int i = m - 1, j = n - 1;
        boolean sub = false;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int a = Integer.valueOf(first.presentation.substring(i, i + 1));
            if (sub) a--;
            int b = Integer.valueOf(second.presentation.substring(j, j + 1));
            
            if (a < b) {
                a += 10;
                sub = true;
            }
            else sub = false;
            sb.insert(0, a - b);
            i--;
            j--;
        }
        if (sub) {
            int a = Integer.valueOf(first.presentation.substring(i, i + 1)) - 1;
            sb.insert(0, a);
            i--;
        }
        sb.insert(0, first.presentation.substring(0, i + 1));
        int k = 0;
        for (; k < sb.length(); ) {
            if (sb.charAt(k) == '0') k++;
            else break;
        }
    
        return new BigInt(sb.toString().substring(k));
        
    }
    
    public static void main(String[] args) {
        BigInt a = new BigInt("999");
        BigInt b = new BigInt("1000");
        System.out.println(a.substract(a, b).presentation);
    }
    
}