public class Twitter {
    class Tweet {
        private int time;
        private int tweetId;
        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    
    int currTime = 0;
    Map<Integer, HashSet<Integer>> followMap; 
    Map<Integer, List<Tweet>> tweetMap;
    /** Initialize your data structure here. */
    
    public Twitter() {
         followMap = new HashMap<Integer, HashSet<Integer>>();
         tweetMap = new HashMap<Integer, List<Tweet>>();
         currTime = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
          if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<Tweet>());
        }
        tweetMap.get(userId).add(new Tweet(currTime++, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
         List<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(10, new Comparator<Tweet>() {
            public int compare(Tweet a, Tweet b) {
                return b.time - a.time;
            }
        });
        if (tweetMap.containsKey(userId)) {
            // add its own to the queue. 
            for (Tweet tweet : tweetMap.get(userId)) {
                queue.offer(tweet);
            }
        }
        
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    for (Tweet tweet : tweetMap.get(followeeId)) {
                        queue.offer(tweet);
                    }
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            Tweet curr = queue.poll();
            res.add(curr.tweetId);
            count++;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */