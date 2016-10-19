/**
 * Created by yueyangzou on 16/10/17.
 */
import java.util.*;
class SumCount {
    int sum;
    int count;
    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

class Node {
    int val;
    ArrayList<Node> children;
    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
public class CompanyTree {
    private static Node result;
    private static double resAve = Double.MIN_VALUE;
    public static Node getHighAve(Node root) {
        if (root == null) return null;
        helper(root);
        return result;
    }
    private static SumCount helper(Node root) {
        if (root == null) {
            return new SumCount(Integer.MIN_VALUE, 0);
        }
        if (root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }
        int curSum = root.val;
        int curCnt = 1;
        for (Node node : root.children) {
            SumCount sumCount = helper(node);
            curSum += sumCount.sum;
            curCnt += sumCount.count;
        }
        double curAve = (double) curSum / curCnt;
        if (resAve < curAve) {
            resAve = curAve;
            result = root;
        }
        return new SumCount(curSum, curCnt);
    }
    private static void addNodes(Node root, int count) {
        root.children = new ArrayList<Node>();
        for (int i = 1; i < count; i++) {
            Random random = new Random();
            int x = random.nextInt(i * i);
            root.children.add(new Node(x));
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);

        System.out.println(res.val + " " + resAve);
    }
}
