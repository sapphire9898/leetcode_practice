import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by yueyangzou on 16/10/17.
 */
public class OrderDependency {
    public ArrayList<Integer> findOrder(int numCourse, ArrayList<int[]> prerequisites) {
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        int[] outdegree = new int[numCourse];
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourse; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] array : prerequisites) {
            int outNode = array[1];
            int inNode = array[0];
            outdegree[outNode]++;
            graph.get(inNode).add(outNode);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourse; i++) {
            if (outdegree[i] == 0) {
                res.add(0, i);
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int num : graph.get(curr)) {
                outdegree[num]--;
                if (outdegree[num] == 0) {
                    res.add(0, num);
                    queue.offer(num);
                    count++;
                }
            }
        }

        return numCourse == count ? res : null;
    }
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {1, 0});
        list.add(new int[] {2, 0});
        list.add(new int[] {3, 1});
        list.add(new int[] {3, 2});
        for (int i : new OrderDependency().findOrder(4, list)) {
            System.out.println(i);
        }
    }
}
