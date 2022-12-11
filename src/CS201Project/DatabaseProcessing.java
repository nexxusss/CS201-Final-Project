package CS201Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Field;

import CS201Project.BSTGen.Node;

public class DatabaseProcessing {

	public ArrayList<PeopleRecord> sorted = new ArrayList<>();

	public void loadData(String fileName, BSTGen bst) throws IOException {
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
	public void search(String givenName, String familyName, BSTGen bst) throws NoSuchFieldException, SecurityException {
		ArrayList<PeopleRecord>found=new ArrayList<PeopleRecord>();
		ArrayList<String>target=new ArrayList<>();
		target.add(givenName);
		target.add(familyName);

		ArrayList<Field>target2=new ArrayList<>();
		target2.add(bst.root.record.getClass().getDeclaredField("givenName"));
		target2.add(bst.root.record.getClass().getDeclaredField("familyName"));

		found = bst.search(target2, target);
		//System.out.println(found);
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
			//sortedRecords.add(heap.delete());
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

	public MyHashMap<String, Integer> getMostFrequentWords(int count, int len, String fileName) throws ShortLengthException, FileNotFoundException, IOException{

		if(len < 3) {
			// Throw a ShortLengthException
			throw new ShortLengthException("Error: The minimum length of a word must be at least 3 characters.");
		}

		ArrayList<String> mostFrequentWords = new ArrayList<>();
		MyHashMap<String, Integer> map = new MyHashMap<>();

		ArrayList<String> arr = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String currLine;
			while((currLine = reader.readLine()) != null) {
				String[] phrase = currLine.split(";");
				for(String ph:phrase) {
					arr.add(ph);
				}
			}

			// loading all words that match requirements to an array
			ArrayList<String> arr2 = new ArrayList<>();
			for(String ph: arr) {
				if(ph.contains(" ")) {
					String[] singleWord = ph.split("\\W+");
					for(String word: singleWord) {
						if(word.matches("[a-zA-Z]+") && word.length() >= len)
							arr2.add(word);
					}
				} else if(!ph.contains(" ") && ph.matches("[a-zA-Z]+") && ph.length() >= len) {
					arr2.add(ph);
				}
			}
			// load all element in a Hash Map
			for (String word: arr2)
			{

				Integer value = map.getValue(word);
				if(value == null) {
					map.put(word, 1);
				} else {
					System.out.println(value);
					map.set(word, value + 1);
				}
			}


		}
		return map;
	}

	public class ShortLengthException extends Exception {
		public ShortLengthException() {
			super();
		}
		public ShortLengthException(String message) {
			super(message);
		}
	}
}
