class Twitter {
    // Pair, key: tweetId, value: int, 代表发表时间
    private Map<Integer, Tweet> tweetIdByUserId;
    // 越大表示时间越近
    private int time;

    private Map<Integer, Set<Integer>> followeesMap;

    private Queue<Tweet> recentTweets;

    public Twitter() {
        tweetIdByUserId = new HashMap<>();
        followeesMap = new HashMap<>();
        time = 0;
        recentTweets = new PriorityQueue<>((t1, t2) -> t1.time > t2.time ? -1 : 1);
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetIdByUserId.containsKey(userId)) {
            tweetIdByUserId.put(userId, new Tweet(time++, tweetId, null));
        } else {
            Tweet tweets = tweetIdByUserId.get(userId);
            Tweet newTweet = new Tweet(time++, tweetId, tweets);
            tweetIdByUserId.put(userId, newTweet);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        recentTweets.clear();
        List<Integer> userIds = new ArrayList<>();
        userIds.add(userId);
        Set<Integer> followees = followeesMap.get(userId);
        if (followees != null && !followees.isEmpty()) {
            userIds.addAll(followees);
        }
        for (int uId : userIds) {
            if (tweetIdByUserId.containsKey(uId)) {
                recentTweets.add(tweetIdByUserId.get(uId));
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!recentTweets.isEmpty()) {
            Tweet tweet = recentTweets.peek();
            recentTweets.poll();
            if (ans.size() == 10) {
                break;
            }
            ans.add(tweet.tweetId);
            Tweet nextTweet = tweet.next;
            if (nextTweet != null) {
                recentTweets.add(nextTweet);
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followeesMap.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        followeesMap.put(followerId, followees);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeesMap.containsKey(followerId)) {
            Set<Integer> followees = followeesMap.get(followerId);
            followees.remove(Integer.valueOf(followeeId));
            followeesMap.put(followerId, followees);
        }
    }

    class Tweet {
        // time 用以比较
        int time;

        int tweetId;

        Tweet next;

        Tweet() {}

        Tweet(int time, int tweetId, Tweet next) {
            this.time = time;
            this.tweetId = tweetId;
            this.next = next;
        }
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
