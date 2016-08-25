public class NumArray {
     private SegmentTreeNode root;
     
    class SegmentTreeNode {
        int leftindex;
        int rightindex;
        int sum;
        SegmentTreeNode left, right; 
        
        public SegmentTreeNode(int leftindex, int rightindex, int sum) {
            this.leftindex = leftindex;
            this.rightindex = rightindex;
            this.sum = sum;
            left = null;
            right = null;
        } 
    }
    
    //create a Segment Tree. 
    private SegmentTreeNode createSegmentTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        else {
            return helperCreate(nums, 0, nums.length - 1);
        }
    }
    
    private SegmentTreeNode helperCreate(int[] nums, int start, int end) {
        if (start > end) return null;
        else if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        root.left = helperCreate(nums, start, mid);
        root.right = helperCreate(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    // query a segment Tree with indexes. 
    private int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (root == null) return 0;
        else if (start == root.leftindex && end == root.rightindex) {
            return root.sum;
        }
        // query the left part, if end <= mid
        int mid = (root.leftindex + root.rightindex) / 2;
        if (end <= mid) {
            return querySegmentTree(root.left, start, end);
        } 
        //query the right part, if start > mid
        else if (start > mid) {
            return querySegmentTree(root.right, start, end);
        }
        // start <= mid < end, we need to divide it into two parts, [start, mid] left, [mid + 1, end] right
        else {
            return querySegmentTree(root.left, start, mid) + querySegmentTree(root.right, mid + 1, end);
        }
    }
    
    
    //update a segment tree with index i;
    private void updateSegmentTree(SegmentTreeNode root, int index, int newval) {
        if (root == null || index < root.leftindex || index > root.rightindex) {
            return;
        }
        if (index == root.rightindex && index == root.leftindex) {
            root.sum = newval;
            return;
        }
        
        int mid = (root.leftindex + root.rightindex) / 2;
        
        if (index <= mid) {
            updateSegmentTree(root.left, index, newval);
        }
        else {
            updateSegmentTree(root.right, index, newval);
        }
        
        root.sum = root.left.sum + root.right.sum;
        
    }

    public NumArray(int[] nums) {
        root = createSegmentTree(nums);
        
    }

    void update(int i, int val) {
        updateSegmentTree(root, i, val);
        
    }

    public int sumRange(int i, int j) {
        return querySegmentTree(root, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);