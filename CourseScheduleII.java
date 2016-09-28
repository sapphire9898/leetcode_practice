public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        int index = numCourses - 1;
        
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();// as arraylist of objects. 
        }
        
        // graph and indegree
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        // queue
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                count++;
                queue.offer(i);
                res[index--] = i;
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (Object i : graph[curr]) {
                
                if (--indegree[(int)i] == 0) {
                    count++;
                    queue.offer((int)i);
                    res[index--] = (int)i;
                }
            }
        }
        
        if (count != numCourses) return new int[0];
        else return res;
        
    }
}