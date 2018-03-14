package edu.sjsu.cmpe275.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /***
         * Following is a dummy implementation of App to demonstrate bean creation with Application context.
         * You may make changes to suit your need, but this file is NOT part of the submission.
         */

    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        TweetService tweeter = (TweetService) ctx.getBean("tweetService");
        TweetStats stats = (TweetStats) ctx.getBean("tweetStats");

        try {
//            tweeter.tweet("Jay", "firstTweet on the twitter");
//            tweeter.tweet("Anuj", "firstTweet on the twitter");
//            tweeter.tweet("Jay", "Second");
//            tweeter.tweet("Anuj", "SecondAnuj");
//            tweeter.tweet("Cidi", "firstTweet on the twittera");
//            tweeter.tweet("Cidi", "SecondCidi");
//
//            tweeter.follow("Jay", "Anuj");
//            tweeter.follow("Tejas", "Anuj");
//            tweeter.follow("Anuj", "Jay");
//            tweeter.follow("Jay", "Tejas");
//            tweeter.follow("Anuj", "Cidi2");
//            tweeter.follow("Anuj", "Cidi");
//
//            tweeter.block("Jay", "Anuj");
//            tweeter.block("Tejas", "Anuj");
//            //tweeter.block("Tejas", "Jay");
//            tweeter.block("Nishant", "Tejas");
//            tweeter.block("Jay", "Tejas");
//            tweeter.block("Sidi" ,"Tejas");
//            tweeter.block("Sidi" ,"Anuj");
//            tweeter.tweet("Jay", "firstTweet on the twitter twitter");
//            tweeter.tweet("Anuj", "firstTweet on the twitter");
//            tweeter.tweet("Jay", "Second");
//            tweeter.tweet("Anuj", "Second");
//            tweeter.follow("Jay", "Anuj");
//            tweeter.follow("Anuj4", "Jay");
//            tweeter.follow("Jay3", "Jay");
//            tweeter.follow("Anuj2", "Anuj");
//            tweeter.follow("Anuj1", "Anuj");
//            tweeter.block("Jay", "Anuj");
//            tweeter.block("Tejas", "Jay");
//            tweeter.block("Nishant", "Tejas");
//            tweeter.block("Jay", "Tejas");
//            tweeter.block("Sidi" ,"Tejas");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Most productive user: " + stats.getMostProductiveUser());
        System.out.println("Most popular user: " + stats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + stats.getLengthOfLongestTweetAttempted());
        System.out.println("Most unpopular follower " + stats.getMostBlockedFollower());
        stats.resetStatsAndSystem();
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("Most productive user: " + stats.getMostProductiveUser());
        System.out.println("Most popular user: " + stats.getMostFollowedUser());
        System.out.println("Length of the longest tweet: " + stats.getLengthOfLongestTweetAttempted());
        System.out.println("Most unpopular follower " + stats.getMostBlockedFollower());
        ctx.close();
    }
}
