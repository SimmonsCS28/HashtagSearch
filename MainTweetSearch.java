package TweetSearch;

import java.util.*;

public class MainTweetSearch {

	public static void main(String[] args) {

		// Create a tree from master hashtag list
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

		boolean askAgain = true;
		while (askAgain != false) {
			System.out
					.println("Please enter a tweet and I will see if your hashtags are in my table.");
			@SuppressWarnings("resource")
			Scanner tweetInput = new Scanner(System.in);

			// Create a new list to store words from tweet in
			LinkedList<String> tweetHashTags = new LinkedList<String>();
			String tweet = tweetInput.nextLine();

			// Split words from tweet into an array and then search the array
			// for
			// hashtags to add to the hashtag list

			String[] tweetWords = tweet.split(delimiter);
			for (int i = 0; i < tweetWords.length; i++) {
				if (tweetWords[i].contains("#"))
					tweetHashTags.addFirst(tweetWords[i]);
			}// end of for loop

			// While the hashtag list still has hashtags, search the tree and
			// print
			// out whether they were found in the master list or not.

			while (!tweetHashTags.isEmpty()) {
				System.out.println(hashTagTree.findHashtag(hashTagTree,
						tweetHashTags.getLast()));
				tweetHashTags.removeLast();
			}// end of while loop

			// ask if the user would like to enter another tweet
			System.out
					.println("\nWould you like to enter another tweet? Yes or no.");
			if (tweetInput.nextLine().equalsIgnoreCase("no"))
				askAgain = false;

		}// end of main while loop

	}// end of main method

}// end of class
