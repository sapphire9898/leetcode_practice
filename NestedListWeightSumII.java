/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    class sumLevel {
        int level;
        int sum;
        public sumLevel(int level, int sum) {
            this.level = level;
            this.sum = sum;
        }
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        
        sumLevel sumlevel = helper(nestedList);
        return sumlevel.sum;
    }
    
    private sumLevel helper(List<NestedInteger> list) {
        // return sumLevel; 
        int sum = 0;
        int level = 1;
        for (NestedInteger nestInteger : list) {
            if (!nestInteger.isInteger()) {
                // it is a list. we need find out its' sum and return its level for this list to use. 
                sumLevel sumlevel= helper(nestInteger.getList());
                level = Math.max(sumlevel.level + 1, level);
                sum += sumlevel.sum;
            }
        }
        
        for (NestedInteger nestInteger : list) {
            if (nestInteger.isInteger()) {
                sum += (int) nestInteger.getInteger() * level;
            }
        }
        return new sumLevel(level, sum);
    }
}



/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weighted = 0, unweighted = 0;
        
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
            for (NestedInteger nestInteger : nestedList) {
                if (nestInteger.isInteger()) {
                    unweighted += nestInteger.getInteger();
                }
                else {
                    nextLevel.addAll(nestInteger.getList());
                }
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
        
    }
}