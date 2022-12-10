// this is a generic class for any type of record
// used in BSTPR as super class

package CS201Project;

import java.util.ArrayList;


public class BSTGen<T extends Comparable<T>> {
	public class Node<T>{
		T record;
		Node left;
		Node right;
		
		public Node(T record) {
			this.record = record;
			this.right = null;
			this.left = null;
		}
	}
	
	protected Node root;
	private int countNodes;
	
	BSTGen(){
		this.root = null;
		this.countNodes = 0;
	}
	
	public void insert(T record) {
		root = insert(root, record);
		countNodes++;
	}
	
	public Node insert(Node node, T record) {
        if (root == null) {
            root = new Node<T>(record);
        }
        if (record.compareTo((T) node.record) < 0) {
            insert(node.left, record);
        } else {
            insert(node.right, record);
        }
        return node;
    }
	public ArrayList<Node> search(T record) {
        ArrayList<Node> result = new ArrayList<>();
        search(root, record, result);
        return result;
    }

    public void search(Node node, T record, ArrayList<Node> result) {
        if (node == null) {
            return;
        }
        if (record.equals(node.record)) {
            result.add(node);
        }

        search(node.left, record, result);
        search(node.right, record, result);
    }
    
 // get height of the BST
 	// used in @getInfo
 	private int getHeight(Node<T> node) {
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
