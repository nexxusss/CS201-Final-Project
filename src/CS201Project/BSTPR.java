package CS201Project;

// BST class as child class of BSTGen
import java.util.ArrayList;


class BSTPR extends BSTGen<PeopleRecord>{
    // constructor
    public BSTPR() {
        super();
    }
    private class Node{
		PeopleRecord record;
		Node left;
		Node right;
		
		public Node(PeopleRecord record) {
			this.record = record;
			this.right = null;
			this.left = null;
		}
		
	Node root;
    /*
    // insert a PeopleRecord into the BST
    public void insert(PeopleRecord record) {
        super.insert(record);
    }

    // search for PeopleRecord objects with the given name and family name
    public ArrayList<Node> search(String givenName, String familyName) {
        return super.search(new PeopleRecord(givenName, familyName, "", "", "", "", "", "", "", "", "", "", ""));
    }
    
 	*/
	public ArrayList<Node> findByName(String givenName, String familyName) {
		ArrayList<Node> result = new ArrayList<>();
		findByNameHelper(root, givenName, familyName, result);
		return result;
	}
	public void findByNameHelper(Node root, String givenName, String familyName, ArrayList<Node> result) {
		if(root == null) {
			return;
		}
		if(givenName.equals(root.record.getGivenName()) && familyName.equals(root.record.getFamilyName())) {
			result.add(root);
		}
		
		findByNameHelper(root.left, givenName, familyName, result);
		findByNameHelper(root.right, givenName, familyName, result);
	}
    }
    
}

