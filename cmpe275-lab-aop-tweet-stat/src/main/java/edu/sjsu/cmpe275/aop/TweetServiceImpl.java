package edu.sjsu.cmpe275.aop;

import java.io.IOException;

public class TweetServiceImpl implements TweetService {

    /***
     * Following is a dummy implementation.
     * You can tweak the implementation to suit your need, but this file is NOT part of the submission.
     */

	@Override
    public void tweet(String user, String message) throws IllegalArgumentException, IOException {
    	System.out.printf("User %s tweeted message: %s\n", user, message);
//    	throw new IOException();
//		throw new IllegalArgumentException();
//		int i = 10/0;
    }

	@Override
    public void follow(String follower, String followee) throws IOException {
       	System.out.printf("User %s followed user %s \n", follower, followee);
    }

	@Override
	public void block(String user, String follower) throws IOException {
       	System.out.printf("User %s blocked user %s \n", user, follower);
	}

}
