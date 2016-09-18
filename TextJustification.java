public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // we need to search which number of the words is suitable for the padding. 
        List<String> res = new ArrayList<String>();
        
        if (words == null || words.length == 0 || maxWidth <= 0) {
            res.add("");
            return res;
        }
        
        int prevLen = 0, space = 0, extra = 0, last = 0;
        
        
        // last is the start index of the composed string. 
        // extra is the first extra ones which need one more space. 
        // space is the average space for n - 1 strings in the composed string. 
         // prevLen is the sum of string length of (last to i - 1) strings. 
        
        // the least space for last to i string (i - last + 1 strings, that is i - last spaces.);
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + prevLen + i - last > maxWidth) {
                space = 0;
                extra = 0;
                // In this place we make a composed string from last to i - 1;
                // there are i - 1 - last + 1 - 1 spaces. 
                // check if i - 1 - last == 0; if they are equal, then there is only one string in this composed string. 
                if (i - 1 - last > 0) {
                    space = (maxWidth - prevLen) / (i - 1 - last);
                    extra = (maxWidth - prevLen) % (i - 1 - last); 
                }
                
                // for example, there three spaces for two strings. the first string is followed by 2 spaces, the second is followed by 1 space. 3 / 2 = 1, extra = 3 % 2 = 1; for the last to last + extra - 1, the one more space should be added. 
                
                StringBuilder sb = new StringBuilder();

                for (int k = last; k <= i - 1; k++) {
                    sb.append(words[k]);
                    if (k < i - 1) {
                        for (int m = 0; m < space; m++) {
                            sb.append(' ');
                        }
                        
                        if (extra > 0) {
                            sb.append(' ');
                        }
                        extra--;
                    }
                }
                
                // if there is only one string, we need to append spaces till the length is maxWidth. 
                for(int j=sb.length(); j < maxWidth; j++)
                    sb.append(" ");

                res.add(sb.toString());
                // set the new 'last' as 'i', and the prevLen is i.length();
                prevLen = words[i].length();
                last = i;
                
            }
            else {
                // the ith word can be filled in the composed string. 
                prevLen += words[i].length();
            }
            
        }
        
        
        // for the last line, there should not be extra spaces between words. 
        StringBuilder sb = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            sb.append(words[i]);
            if (sb.length() < maxWidth) {
                sb.append(" ");
            }
        }
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(" ");
        }
        
        res.add(sb.toString());
        return res;

        
    }
    

}