// this is a generic class for any type of record
// used in BSTPR as super class

package CS201Project;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ListIterator;


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
		if (root==null)
		{
			root= new Node<T>(record);
			return;
		}
		insert(root, record);
		countNodes++;
	}
	
	void insert(Node node, T record) {
        if (node == null) {
            node = new Node<T>(record);
            return ;
        }
        if (record.compareTo((T) node.record) < 0) {
        	if (node.left==null)
			{
				node.left=new Node<T>(record);
				return;
			}
            insert(node.left, record);
        } else {
			if (node.right==null)
			{
				node.right=new Node<T>(record);
				return;
			}
            insert(node.right, record);
        }

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
    public void search(Field attribute, Object valueOfAttribute,Node<T>node,ArrayList<T> result)
	{
		if (node == null) {
			return;
		}
		try
		{
			if (attribute.get(node.record).equals(valueOfAttribute)) {
				result.add(node.record);
			}
		}
		catch (Exception e)
		{

		}

		search(attribute,valueOfAttribute,node.left, result);
		search(attribute,valueOfAttribute,node.right, result);

	}
	public ArrayList<T> search (Field attribute,Object valueToFind)
	{
		ArrayList<T> result=new ArrayList<T>();
		search(attribute,valueToFind,root,result);
		return result;
	}
	public ArrayList<T> search(ArrayList<Field>attributes,ArrayList<Object>valuesToFind)
	{
		ArrayList<T> result=new ArrayList<T>();
		if (attributes.size()!=valuesToFind.size())
		{
			System.out.println("Invalid search function parameters. The number of attributes must be equal to their value ");
		}
		search(attributes,valuesToFind,root,result);
		return result;
	}
	public void search(ArrayList<Field>attributes,ArrayList<Object>valuesToFind,Node<T> node,ArrayList<T>result)
	{
		if (node == null) {
			return;
		}
		try
		{
			for (int i =0 ; i < attributes.size(); i ++)
			{
				if (!attributes.get(i).get(node.record).equals(valuesToFind.get(i)))
				{
					break;
				}
				if (i==attributes.size()-1)
				{
					result.add(node.record);
				}
			}
		}
		catch (Exception e)
		{

		}

		search(attributes,valuesToFind,node.left, result);
		search(attributes,valuesToFind,node.right, result);
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
    public void inorder()
	{
		inorder(root);
	}
	public void inorder(Node<T>node)
	{
		if (node==null)
		{
			return;
		}
		inorder(node.left);
		System.out.println(node.record+" ");
		inorder(node.right);
	}


}
