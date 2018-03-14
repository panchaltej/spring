package edu.sjsu.cmpe275.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import edu.sjsu.cmpe275.aop.TweetStatsImpl;

@Aspect
@Order(1)
public class StatsAspect {
    /***
     * Following is a dummy implementation of this aspect.
     * You are expected to provide an actual implementation based on the requirements, including adding/removing advices as needed.
     */

	@Autowired TweetStatsImpl stats;
	
	@AfterReturning("execution(public void edu.sjsu.cmpe275.aop.TweetService.tweet(..)) && args(user, tweet)")
	public void AfterTweetAdvice(JoinPoint joinPoint, String user, String tweet) {
		stats.updateTweetLength(user, tweet);
	}

	@AfterReturning("execution(public void edu.sjsu.cmpe275.aop.TweetService.follow(..)) && args(follower, followee)" )
	public void AfterFollowAdvice(JoinPoint joinPoint, String follower, String followee) {
		stats.updateFollowers(follower, followee);
	}

	@AfterReturning("execution(public void edu.sjsu.cmpe275.aop.TweetService.block(..)) && args(blocker, blocked)")
	public void AfterBlockAdvice(JoinPoint joinPoint, String blocker, String blocked) {
		stats.updateBlockedBy(blocked, blocker);
	}

	@Before("execution(public void edu.sjsu.cmpe275.aop.TweetService.tweet(..)) && args(user, tweet)")
	public void BeforeTweetAdvice(JoinPoint joinPoint, String user, String tweet) {
		stats.updateLongestTweet(tweet);
	}
	
}
