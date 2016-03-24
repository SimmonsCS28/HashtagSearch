package TweetSearch;

import java.util.*;

public class MainTweetSearch {

	public static void main(String[] args) {
		
		// Create the Hashtag Tree
		BinarySearchTree<String> hashTagTree = new BinarySearchTree<String>();

		FileIn fileInput = new FileIn();
		fileInput
				.openFile("C:\\Users\\SimmonsCS28\\workspace\\CompSci223\\src\\TweetSearch\\100hashtags.txt");
		String delimiter = " ";
		String line = fileInput.readLine();
		String[] initialTag = line.split(delimiter);
		
		// set value for the first hashtag
		String hashtag = initialTag[1];

		// Insert hashtags into the tree
		while (line != null) {
			hashTagTree.insertNode(hashtag);
			line = fileInput.readLine();
			if (line != null) {
				String[] nextHashTag = line.split(delimiter);
				hashtag = nextHashTag[1];
			}
		}// end of while loop

		// Ask for a tweet to search for
		System.out.println("Please enter a hashtag to search for.");
		@SuppressWarnings("resource")
		Scanner tweetInput = new Scanner(System.in);
		String key = tweetInput.next();

		// Search the tree and print out result of found or not
		System.out.println(hashTagTree.findHashtag(hashTagTree, key)+" was found.");
		

	}// end of main method

}// end of class
