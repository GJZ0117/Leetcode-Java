package medium;

import java.util.*;

/**
 * 355. Design Twitter
 */

public class Design_Twitter {
    // https://leetcode.cn/problems/design-twitter/solution/ha-xi-biao-lian-biao-you-xian-dui-lie-java-by-liwe/

    private class Tweet {
        private int id;
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    private Map<Integer, Tweet> twitter = new HashMap<>();
    private Map<Integer, Set<Integer>> followings = new HashMap<>();
    private static int timestamp = 0;
    private static PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)) {
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (twitter.containsKey(userId)) {
            maxHeap.offer(twitter.get(userId));
        }
        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            return;
        }
        followingList.remove(followeeId);
    }
}
