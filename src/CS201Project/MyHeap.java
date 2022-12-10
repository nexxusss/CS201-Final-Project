package CS201Project;

import java.util.ArrayList;
import java.util.ListIterator;

class MyHeap<T extends  Comparable<T>> {
    //This is a Max Heap
    //fields
    private ArrayList<T> MaxHeap;

    //constructors
    MyHeap(){this.MaxHeap=new ArrayList<T>();}
    MyHeap(T value){this.MaxHeap=new ArrayList<T>();this.MaxHeap.add(value);}


    //setters
    void setMaxHeap(ArrayList<T> newHeap)
    {
        ListIterator<T> iterator=newHeap.listIterator();
        while(iterator!=null){
            add(iterator.next());
        }
    }


    //getters
    ArrayList<T> GetMaxHeap(){return MaxHeap;}
    T GetFirstElement(){return MaxHeap.get(0);}

    int findIndex(T value,int currentIndex)
    {
        if (MaxHeap.get(currentIndex)==value)
        {
            return currentIndex;
        }
        return  findIndex(value,currentIndex+1);
    }
    int getLargerChildIndex(int index)
    {
        if (MaxHeap.get(2*index+1).compareTo(MaxHeap.get(2*index+2))>=0)
        {
            return 2*index+1;
        }
        else
        {
            return 2*index+2;
        }
    }
    void swapForDelete(int index)
    {
        if (MaxHeap.size()<=2*index+1)
        {
            return;
        }
        if (MaxHeap.size()<=2*index+2)
        {
            if (MaxHeap.get(index).compareTo(MaxHeap.get(2*index+1))>0)
            {
                return;
            }
            swap(index,2*index+1);
            return;
        }
        if (MaxHeap.get(index).compareTo(MaxHeap.get(2*index+1))>0&&MaxHeap.get(index).compareTo(MaxHeap.get(2*index+2))>0)
        {
            return;
        }
        int largerChildIndex=getLargerChildIndex(index);
        swap(index,largerChildIndex);
        swapForDelete(largerChildIndex);
    }
    void delete(T value)
    {
        int index=findIndex(value,0);
        T lastElement=MaxHeap.get(MaxHeap.size()-1);
        MaxHeap.remove(MaxHeap.size()-1);
        if(index<MaxHeap.size())
        {
            MaxHeap.set(index,lastElement);
            swapForDelete(index);
        }

    }
    void swap(int index1,int index2)
    {
        T temp=MaxHeap.get(index1);
        MaxHeap.set(index1, MaxHeap.get(index2));
        MaxHeap.set(index2, temp);
    }

    void swapUntilAdded(int index1,int index2)
    {
        if (index2==0)
        {
            if (MaxHeap.get(index1).compareTo(MaxHeap.get(index2))>0)
            {

                swap(index1,index2);
            }
            return;
        }
        if (MaxHeap.get(index1).compareTo(MaxHeap.get(index2))<=0)
        {
            return;
        }
        swap(index1,index2);
        swapUntilAdded(index2,index2/2);
    }
    void add(T value)
    {
        MaxHeap.add(value);
        swapUntilAdded(MaxHeap.size()-1,(MaxHeap.size()-1)/2);
    }


    //TODO:@Override public String toString(){}
    void printAsArray()
    {
        for (int i =0 ; i < MaxHeap.size(); i ++)
        {
            System.out.print(MaxHeap.get(i)+" ");
        }
        System.out.println();
    }


}
