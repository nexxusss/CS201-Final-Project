package CS201Project;

import java.util.ArrayList;
import java.io.IOException;
import java.lang.reflect.Field;

import java.util.HashMap;

import CS201Project.DatabaseProcessing.ShortLengthException;


public class Main {
    public static void main(String args[]) throws IOException, NoSuchFieldException, SecurityException, ShortLengthException
    {
        MyHeap<Integer> intHeap=new MyHeap<Integer>();
        BSTGen<PeopleRecord>peopleRecordBSTGen=new BSTGen<PeopleRecord>();
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
       /*BSTGen<PeopleRecord>peopleRecordBSTGen=new BSTGen<PeopleRecord>();

        intHeap.printAsArray();
        
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

        MyHashMap<String,Integer> myMap= new MyHashMap<>();
        myMap.put("a",1);
        myMap.put("b",2);
        myMap.put("c",3);
        myMap.put("d",4);
        myMap.put("e",5);
        System.out.println(myMap);*/

        //System.out.println(new java.io.File("").getAbsolutePath());
        DatabaseProcessing dp = new DatabaseProcessing();
        dp.loadData("people.txt", peopleRecordBSTGen);
        
        //System.out.println(peopleRecordBSTGen.getInfo()[0]);
        //peopleRecordBSTGen.inorder();
        dp.search("Marcia", "France", peopleRecordBSTGen);
        
        System.out.println(dp.getMostFrequentWords(3, 3, "people.txt"));

    }
}