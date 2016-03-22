package TweetSearch;

import java.util.*;

public class MainTweetSearch {

	public static void main(String[] args) {

		BinarySearchTree<String> tweetsTree = new BinarySearchTree<String>();

		FileIn fileInput = new FileIn();
		fileInput
				.openFile("C:\\Users\\SimmonsCS28\\workspace\\CompSci223\\src\\TweetSearch\\100hashtags.txt");
		String delimiter = " ";
		String line = fileInput.readLine();
		String[] initialTweet = line.split(delimiter);
		String tweet = initialTweet[1];

		// Create the binary tree
		while (line != null) {
			tweetsTree.insertNode(tweet);
			line = fileInput.readLine();
			if (line != null) {
				String[] nextTweet = line.split(delimiter);
				tweet = nextTweet[1];
			}
		}// end of while loop

		// Ask for a tweet to search for
		System.out.println("Please enter a hashtag to search for.");
		@SuppressWarnings("resource")
		Scanner tweetInput = new Scanner(System.in);
		String key = tweetInput.next();

		
		System.out.println(tweetsTree.findHashtag(tweetsTree, key)+" was found.");
		

	}// end of main method

}// end of class
