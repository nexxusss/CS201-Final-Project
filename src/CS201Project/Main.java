package CS201Project;

import java.util.ArrayList;
import java.lang.reflect.Field;
public class Main {
    public static void main(String args[])
    {
        MyHeap<Integer> intHeap=new MyHeap<Integer>();
       /* intHeap.add(5);
        intHeap.add(6);
        intHeap.add(1);
        intHeap.add(8);
        intHeap.add(2);
        intHeap.add(9);
        intHeap.printAsArray();
        intHeap.delete(5);
        intHeap.printAsArray();
        intHeap.delete(9);
        intHeap.printAsArray();*/
        BSTGen<PeopleRecord>peopleRecordBSTGen=new BSTGen<PeopleRecord>();
        peopleRecordBSTGen.insert(new PeopleRecord("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
        peopleRecordBSTGen.insert(new PeopleRecord("2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2"));
        peopleRecordBSTGen.insert(new PeopleRecord("3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3"));
        peopleRecordBSTGen.insert(new PeopleRecord("3", "2", "1", "2", "3", "3", "3", "2", "2", "1", "3", "3", "3"));
        peopleRecordBSTGen.insert(new PeopleRecord("1", "1", "1", "2", "3", "3", "3", "2", "2", "1", "3", "3", "3"));
        ArrayList<PeopleRecord>found=new ArrayList<PeopleRecord>();
        peopleRecordBSTGen.inorder();
        try{
            found=peopleRecordBSTGen.search(peopleRecordBSTGen.root.record.getClass().getDeclaredField("givenName"),"1");
            System.out.println(peopleRecordBSTGen.root.record.getClass().getDeclaredField("givenName").get(peopleRecordBSTGen.root.record));
            for (int i =0 ; i < found.size(); i ++)
            {
                System.out.println(found.get(i));
            }
        }
        catch(Exception e)
        {

        }



    }
}
