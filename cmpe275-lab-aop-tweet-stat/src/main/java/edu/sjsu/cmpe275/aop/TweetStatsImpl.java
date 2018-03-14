package edu.sjsu.cmpe275.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetStatsImpl implements TweetStats {
    /***
     * Following is a dummy implementation.
     * You are expected to provide an actual implementation based on the requirements.
     */

    private Map <String,List<String>> followers          = new HashMap<String, List<String>>();
	private Map <String,Integer>      totalTweetLength   = new HashMap<String, Integer>();
	private Map <String,List<String>> blockedBy          = new HashMap<String, List<String>>();
	private int                       longestTweetLength = 0;

	public TweetStatsImpl(){
		this.followers          = new HashMap<String, List<String>>();
		this.totalTweetLength   = new HashMap<String, Integer>();
		this.blockedBy          = new HashMap<String, List<String>>();
		this.longestTweetLength = 0;
	}

	public void updateFollowers(String follower, String followee){
		if(this.followers.get(followee) != null){
			this.followers.get(followee).add(follower);
		}
		else{
			List<String> follower_list = new ArrayList<String>();
			follower_list.add(follower);
			this.followers.put(followee, follower_list);
		}
	}

	public void updateTweetLength(String user, String tweet){
		if(this.totalTweetLength.get(user) != null){
			this.totalTweetLength.put(user, this.totalTweetLength.get(user)+tweet.length());
		}
		else{
			this.totalTweetLength.put(user, tweet.length());
		}
	}

	public void updateBlockedBy(String blocked, String blocker){
		if(this.blockedBy.get(blocked) != null){
			this.blockedBy.get(blocked).add(blocker);
		}
		else{
			List<String> blocker_list = new ArrayList<String>();
			blocker_list.add(blocker);
			this.blockedBy.put(blocked, blocker_list);
		}
	}

	public void updateLongestTweet(String tweet){
		int length = tweet.length();
		if (length > longestTweetLength){
			this.longestTweetLength = length;
		}
	}

	@Override
	public void resetStatsAndSystem() {
		this.followers.clear();
		this.totalTweetLength.clear();
		this.blockedBy.clear();
		this.longestTweetLength = 0;
	}
    
	@Override
	public int getLengthOfLongestTweetAttempted() {
		return this.longestTweetLength;
	}

	@Override
	public String getMostFollowedUser() {
		int maxcount = 0;
		String user = null;
		for (Map.Entry<String, List<String>> entry : this.followers.entrySet()){
			if(!this.blockedBy.containsKey(entry.getKey())) {
				int size = entry.getValue().size();
				if (size == maxcount) {
					if (user.compareTo(entry.getKey()) > 0)
						user = entry.getKey();
				}
				if (size > maxcount) {
					maxcount = size;
					user = entry.getKey();
				}
			}
		}
		return user;
	}

	@Override
	public String getMostProductiveUser() {
		int maxcount = 0;
		String user = null;
		for (Map.Entry<String, Integer> entry : this.totalTweetLength.entrySet()){
			int size = entry.getValue();
			if (size == maxcount){
				if (user.compareTo(entry.getKey()) > 0)
					user = entry.getKey();
			}
			if (size > maxcount){
				maxcount = size;
				user = entry.getKey();
			}
		}
		return user;
	}

	@Override
	public String getMostBlockedFollower() {
		int maxcount = 0;
		String user = null;
		for (Map.Entry<String, List<String>> entry : this.blockedBy.entrySet()){
			int size = entry.getValue().size();
			if (size == maxcount){
				if (user.compareTo(entry.getKey()) > 0)
					user = entry.getKey();
			}
			if (size > maxcount){
				maxcount = size;
				user = entry.getKey();
			}
		}
		return user;
	}
}



