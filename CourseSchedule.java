public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        
        for (int i = 0; i < prerequisites.length; i++) {
            //indegree[p[i][1]]++;
            indegree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        // 从indegree的0开始。
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();// curr is already visited, and we now want to check if the node point to curr can be indegree 0 after minus 1. 
            
            for (int k = 0; k < graph[curr].size(); k++) {
                int i = (int)graph[curr].get(k);
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                    count++;
                }
            }
        }
        
        return count == numCourses;
        
        
    }
}