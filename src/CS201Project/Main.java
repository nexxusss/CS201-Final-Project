package CS201Project;


import java.io.IOException;
import java.util.Scanner;

import CS201Project.DatabaseProcessing.ShortLengthException;


public class Main {
    public static void main(String args[]) throws IOException, NoSuchFieldException, SecurityException, ShortLengthException
    {
        run();
    } 
    
    public static void run() throws IOException, ShortLengthException {
        MyHeap<Integer> intHeap=new MyHeap<Integer>();
        BSTGen<PeopleRecord>peopleRecordBSTGen=new BSTGen<PeopleRecord>();
        
        // creating object of DatabaseProcessing
        DatabaseProcessing dp = new DatabaseProcessing();
        dp.loadData("people.txt", peopleRecordBSTGen);
    	boolean quit = false;
    	System.out.println("Choose action(1/2/3/4/):\n1.Print Elements of BST.\n2.Search for element."
				+ "\n3.Find top N most frequent words.\n4.Print MaxHeap sorted elements.\n5.Quit.");
    	while(!quit) {
    		System.out.print("Your choice --> ");
    		Scanner in = new Scanner(System.in);
    		int input = in.nextInt();
    		switch(input) {
    			case 5:
    				quit = true;
    				break;
    			case 1:
    				peopleRecordBSTGen.inorder();
    				break;
    			case 2:
    				try {
	    				System.out.print("Enter given name to search: ");
	    				String given = in.next();
	    				System.out.print("Enter family name to search: ");
	    				String family = in.next();
	    				
	    				dp.search(given, family, peopleRecordBSTGen);
	    				break;

    				} catch(Exception e) {
    					System.out.println(e);
    					System.out.println("Try again!");
    					break;
    				}
    				
    			case 3:
    				try {
	    				System.out.print("Enter N for Top N most frequent words: ");
	    				int count = in.nextInt();
	    				System.out.print("Enter minimum length of words: ");
	    				int len = in.nextInt();
	    				dp.getMostFrequentWords(count, len);
	    				break;
    				} catch(Exception e) {
    					System.out.println(e);
    					break;
    				}
    			case 4:
    				dp.sort(peopleRecordBSTGen);
    				System.out.println(dp.sorted);
    				break;
    		}
    	}
    	
    }
}