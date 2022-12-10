package CS201Project;

public class Main {
    public static void main(String args[])
    {
        MyHeap<Integer> intHeap=new MyHeap<Integer>();
        intHeap.add(5);
        intHeap.add(6);
        intHeap.add(1);
        intHeap.add(8);
        intHeap.add(2);
        intHeap.add(9);
        intHeap.printAsArray();
        intHeap.delete(5);
        intHeap.printAsArray();
        intHeap.delete(9);
        intHeap.printAsArray();

    }
}
