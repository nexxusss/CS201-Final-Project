package CS201Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import CS201Project.BSTGen.Node;

public class DatabaseProcessing {
	
	public ArrayList<PeopleRecord> sorted = new ArrayList<>();
	
	public void loadData(String fileName, BSTGen bst) throws IOException {
		int count = 0;
		ArrayList<PeopleRecord> arr = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String currLine;
			while((currLine = reader.readLine()) != null) {
				currLine = currLine.trim();
				if(!currLine.isEmpty()) {
					String[] entry = currLine.split(";");
					
					// create an object of PeopleRecord using the entry for constructor
					PeopleRecord record = new PeopleRecord(entry[0], entry[1], entry[2], entry[3],
							                               entry[4], entry[5], entry[6], entry[7],
							                               entry[8], entry[9], entry[10], entry[1],
							                               entry[12]);
					
					bst.insert(record);
					//System.out.print("Given name: "+entry[0]+", Family name: "+entry[1]+", Company name: "+entry[2]+", Adress: "+entry[3]+", City: "+entry[4]+", County: "+entry[5]+", State: "+entry[6]+", Zip: "+entry[7]+", Phone1: "+entry[8]+", Phone2: "+entry[9]+", Email: "+entry[10]+", Web: "+entry[11]+", Birthday: "+entry[12]+"\n");
					//arr.add(record);
					//count++;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		/*
		for(PeopleRecord record:arr) {
			System.out.print(record);
		}*/
	}
	//TODO still need to make it search for given and family name
	public void search(String givenName, String familyName, BSTGen bst) throws NoSuchFieldException, SecurityException {
		ArrayList<PeopleRecord>found=new ArrayList<PeopleRecord>();
	    found = bst.search(bst.root.record.getClass().getDeclaredField("givenName"), givenName);
	    
	    for(PeopleRecord record: found) {
	    	System.out.println(record);
	    }
	}
	
	public void sort(BSTGen bst) {
		// create an instance of the MyHeap class
		MyHeap<PeopleRecord> heap = new MyHeap<>();
		
		insertInHeap(bst.root, heap);
		// Use the idea of heap sort to order (sort) all records in the heap
		ArrayList<PeopleRecord> sortedRecords = new ArrayList<>();
		  while (!heap.isEmpty()) {
		    sortedRecords.add(heap.delete());
		  }
		
		  // Store the sorted records in a proper data structure
		  // (e.g. List, Array, etc.)
		  this.sorted = sortedRecords;
			
	}
	
	public void insertInHeap(Node node, MyHeap<PeopleRecord> heap) {
	  if (node == null) {
		    return;
		  }
	  heap.add((PeopleRecord) node.record);
	  insertInHeap(node.left, heap);
	  insertInHeap(node.right, heap);
    }
}
