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

    //Method that finds the index of an element with the given value that is used in a delete method
    int findIndex(T value,int currentIndex)
    {
        if (currentIndex==MaxHeap.size())
        {
            //in this case there is no such element in this heap therefore the index that is returned is -1
            return -1;
        }
        if (MaxHeap.get(currentIndex)==value)
        {
            return currentIndex;
        }
        return  findIndex(value,currentIndex+1);
    }
    //Returns the index of a child that is larger
    int getLargerChildIndex(int index)
    {
        if (MaxHeap.get(2*index+1).compareTo(MaxHeap.get(2*index+2))>=0)
        {
            //As this heap is represented by an ArrayList children are located at indexes 2*index+1 and 2*index+2
            return 2*index+1;
        }
        else
        {
            return 2*index+2;
        }
    }
    void swapForDelete(int index)
    {
        //in this case the given index doesn't have any children. Therefore we need to exit the method
        if (MaxHeap.size()<=2*index+1)
        {
            return;
        }
        //in this case the given index has only one child.
        // Therefore, we need to swap it with its child  if its child is greater.
        //If the child is smaller we can just end the traversal.
        if (MaxHeap.size()<=2*index+2)
        {
            if (MaxHeap.get(index).compareTo(MaxHeap.get(2*index+1))>0)
            {
                return;
            }
            swap(index,2*index+1);
            return;
        }
        //if the value of the current index is larger than its children we can end the traversal as we found the right place for the element
        if (MaxHeap.get(index).compareTo(MaxHeap.get(2*index+1))>0&&MaxHeap.get(index).compareTo(MaxHeap.get(2*index+2))>0)
        {
            return;
        }
        //in other cases we need to swap it with the larger child
        int largerChildIndex=getLargerChildIndex(index);
        swap(index,largerChildIndex);
        swapForDelete(largerChildIndex);
    }

    void removeFirstElement()
    {
        delete(MaxHeap.get(0));
    }
    void delete(T value)
    {
        //When we want to delete an element we first have to remove the last element
        int index=findIndex(value,0);
        if (index==-1)
        {
            //in this case there is no element with the given value
            System.out.println("There is no element with the given value in a Heap");
            return;
        }
        T lastElement=MaxHeap.get(MaxHeap.size()-1);
        MaxHeap.remove(MaxHeap.size()-1);
        //In case the given index was the last element we don't have to do anything else

        //In all other cases we need to find a new place for value of the lastElement
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



    //at first we add the value at the end then we call a swapUntilAdded function to find a right place for the value
    void add(T value)
    {
        MaxHeap.add(value);
        //we first call this function for the last element and for its parent
        swapUntilAdded(MaxHeap.size()-1,(MaxHeap.size()-1)/2);
    }

    void swapUntilAdded(int index1,int index2)
    {
        //in this case the element doesn't have a parent. Therefore we can exit the method as it can't be swapped
        if (index1==0)
        {
            return;
        }
        //In this case the element's parent is the Root.
        // Therefore we can just swap them if the element is grater than the  root and exit.
        //After that we can exit the method as we have reached the end
        if (index2==0)
        {
            if (MaxHeap.get(index1).compareTo(MaxHeap.get(index2))>0)
            {

                swap(index1,index2);
            }
            return;
        }
        //in case the element is <= to its parent we can end the traversal as we found the right spot
        if (MaxHeap.get(index1).compareTo(MaxHeap.get(index2))<=0)
        {
            return;
        }
        //In this case the element is greater than its parent.Therefore we need to swap them and call the function for
        //the new place of an element and that places parent
        swap(index1,index2);
        swapUntilAdded(index2,index2/2);
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
    
    public boolean isEmpty() {
    	return MaxHeap.isEmpty();
    }


}
