import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;


public class RedditAnalyzer {
	public static void main(String[] args) throws Exception
	{
		String[][] postsWithAuthors = new String[6500][2];
		File posts = new File("redditPosts.txt");
		Scanner inputPost = new Scanner(posts);
		File authors = new File("redditAuthors.txt");
		Scanner inputAuthor = new Scanner(authors);
		boolean nextLine = true;
		int i = 0;
		int postToView = 0;
		Scanner keyboard = new Scanner(System.in);
		String biggestPoster = null;
		int numRepeats = 0;
		String[][] authorsNumPosts = new String[6500][2];
		int w = 0;
		

		while(nextLine == true){
			postsWithAuthors[i][0] = inputPost.nextLine();
			postsWithAuthors[i][1] = inputAuthor.nextLine();

			i++;
			nextLine = inputPost.hasNextLine();
		}
		System.out.println("Which post would you like to view?");
		try{
			postToView = keyboard.nextInt();
		} catch(java.util.InputMismatchException e){
			System.out.println("Please enter numerals");
		}
		System.out.println("Post: " + postsWithAuthors[postToView][0] + " By: " + postsWithAuthors[postToView][1]);

		for(int q=6465; q>0; q--){
			numRepeats = 0;
			for(int g=q; g>0; g--)
				if(postsWithAuthors[q][1].equals(postsWithAuthors[g][1])){
					numRepeats ++;
				}
			authorsNumPosts[q][0] = postsWithAuthors[q][1];
			authorsNumPosts[q][1] = Integer.toString(numRepeats);
		}
		String[][] storage = new String[1][2];
		storage[0][0] = "";
		storage[0][1] = Integer.toString(0);
		for(int h=6465; h>0; h--){
			if(Integer.parseInt(authorsNumPosts[h][1]) > Integer.parseInt(storage[0][1])){
				storage[0][0] = authorsNumPosts[h][0];
				storage[0][1] = authorsNumPosts[h][1];
			}
		}
		System.out.println("The author with the most posts is: " + storage[0][0] + "! They have " + storage[0][1] + " posts");
		System.out.println("Here are all of their posts:");
		for(int m=6465; m>0; m--){
			if(postsWithAuthors[m][1].equals(storage[0][0])){
				System.out.println(postsWithAuthors[m][0]);
			}
		}
	}

}



