/* BST class designed for PeopleRecord*/

package CS201Project;

import java.util.ArrayList;

class MyBST {
	private class Node{
		PeopleRecord record;
		Node left;
		Node right;
		
		public Node(PeopleRecord record) {
			this.record = record;
			this.right = null;
			this.left = null;
		}
	}
	
	private Node root;
	private int countNodes;
	
	MyBST(){
		this.root = null;
		this.countNodes = 0;
	}
	
	public void insert(PeopleRecord record) {
		root = insert(root, record);
		countNodes++;
	}
	
	public Node insert(Node node, PeopleRecord record) {
		if(root == null) {
			root = new Node(record);
		}
		if(record.compareTo(node.record) < 0) {
			insert(node.left, record);
		} else {
			insert(node.right, record);
		}
		return node;
		
	}
	
	public ArrayList<Node> search(String givenName, String familyName) {
		ArrayList<Node> result = new ArrayList<>();
		search(root, givenName, familyName, result);
		return result;
	}
	public void search(Node node, String givenName, String familyName, ArrayList<Node> result) {
		if(node == null) {
			return;
		}
		if(givenName.equals(node.record.getGivenName()) && familyName.equals(node.record.getFamilyName())) {
			result.add(node);
		}
		
		search(node.left, givenName, familyName, result);
		search(node.right, givenName, familyName, result);
		
	}
	
	// get height of the BST
	// used in @getInfo
	private int getHeight(Node node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	
	// return info about the BST
	// result[0]: Number of nodes
	// result[1]: height of the BST
	public int[] getInfo() {
		int[] result = {countNodes, getHeight(root)};
		return result;
	}
	
	
}
