package TweetSearch;

import java.util.LinkedList;
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
		System.out
				.println("Please enter a tweet and I will see if your hashtags are in my table.");
		Scanner tweetInput = new Scanner(System.in);

		// Create a new list to store string words in
		LinkedList<String> tweetHashTags = new LinkedList<String>();
		String tweet = tweetInput.nextLine();
		tweetInput.close();
		// Split words from tweet into an array and then search the array for
		// hashtags to add to the hashtag list
		String[] tweetWords = tweet.split(delimiter);
		for (int i = 0; i < tweetWords.length; i++) {
			if (tweetWords[i].contains("#"))
				tweetHashTags.addFirst(tweetWords[i]);
		}// end of for loop

		// While the hashtag list still has hashtags, search the tree and print
		// out result of found or not
		while (!tweetHashTags.isEmpty()) {
			System.out.println(hashTagTree.findHashtag(hashTagTree,
					tweetHashTags.getLast()) + " was found.");
			tweetHashTags.removeLast();
		}// end of while loop

	}// end of main method

}// end of class
