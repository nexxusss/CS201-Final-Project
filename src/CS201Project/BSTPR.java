package CS201Project;

// BST class as child class of BSTGen
import java.util.ArrayList;


class BSTPR extends BSTGen<PeopleRecord>{
    // constructor
    public BSTPR() {
        super();
    }

    // insert a PeopleRecord into the BST
    public void insert(PeopleRecord record) {
        super.insert(record);
    }

    // search for PeopleRecord objects with the given name and family name
    public ArrayList<Node> search(String givenName, String familyName) {
        return super.search(new PeopleRecord(givenName, familyName, "", "", "", "", "", "", "", "", "", "", ""));
    }
}

