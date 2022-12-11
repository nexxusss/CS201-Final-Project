package CS201Project;

import java.util.ArrayList;

class MyHashMap <K,V>{
    //private ArrayList<Element<K,V>> ArrayListOfElements;
    private final int SIZE=5021;
    private Element<K,V> [] ArrayOfElements;
    private int numberOfElements;
    MyHashMap()
    {
        //ArrayListOfElements=new ArrayList<Element<K,V>>(SIZE);
        ArrayOfElements= new Element[SIZE];
        numberOfElements=0;
    }
    
    MyHashMap<K, V>.Element<K, V>[] getArrayOfElements(){
    	return ArrayOfElements;
    }
    //put, get, search and delete.
    void set (K key, V value)
    {
    	int index= findPosition(key);
    	if (index==-1)
    	{
    		System.out.println("Element not found");
    		return;
    	}
    	ArrayOfElements[index].setValue(value);
    }
    void put(K key, V value)
    {
        if (numberOfElements==SIZE)
        {
            System.out.println("New element can't be added.Hashmap is full");
            return;
        }
        Element<K,V> newElement= new Element<K,V>(key,value);
        int index= (key.hashCode()&0x7fffffff)%SIZE;
        /*if (ArrayListOfElements.get(index)!=null)
        {
            quadriaticProbing(key.hashCode(),1,newElement);
        }*/
        if (ArrayOfElements[index]!=null)
        {
            quadriaticProbing(index,1,newElement);
            return;
        }
        //ArrayListOfElements.set(newElement.hashCode()%SIZE,newElement);
        ArrayOfElements[index]=newElement;
        numberOfElements+=1;
    }
    void quadriaticProbing(int hashCode,int iteration, Element<K,V> newElement)
    {
        /*if (ArrayListOfElements.get((hashCode+iteration*iteration)%SIZE)==null)
        {
            ArrayListOfElements.set((hashCode+iteration*iteration)%SIZE,newElement);
            numberOfElements+=1;
            return;
        }*/
        if (iteration>=SIZE/2)
        {
            System.out.println("This hashmap is too full and the element can't be added");
            return;
        }
        if (ArrayOfElements[(hashCode+iteration*iteration)%SIZE]==null)
        {
            ArrayOfElements[(hashCode+iteration*iteration)%SIZE]=newElement;
            numberOfElements+=1;
            return;
        }
        quadriaticProbing(hashCode,iteration+1,newElement);
    }
    V getValue (K key)
    {
        int i = 0;
       /* while(ArrayListOfElements.get((key.hashCode()+i*i)%SIZE)!=null)
        {
            if (ArrayListOfElements.get((key.hashCode()+i*i)%SIZE).getKey()==key)
            {
                return  ArrayListOfElements.get((key.hashCode()+i*i)%SIZE).getValue();
            }
            i+=1;
        }*/
        while(ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE]!=null)
        {
            if (ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE].getKey().equals(key))
            {
                return  ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE].getValue();
            }
            i+=1;
        }
        //System.out.println("Element not found");
        return null;

    }
    Element<K,V> getElement (K key)
    {
        int i = 0;
       /* while(ArrayListOfElements.get((key.hashCode()+i*i)%SIZE)!=null)
        {
            if (ArrayListOfElements.get((key.hashCode()+i*i)%SIZE).getKey()==key)
            {
                return  ArrayListOfElements.get((key.hashCode()+i*i)%SIZE);
            }
            i+=1;
        }*/
        while(ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE]!=null)
        {
            if (ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE].getKey().equals(key))
            {
                return  ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE];
            }
            i+=1;
        }
        System.out.println("Element not found");
        return null;

    }
    int findPosition(K key)
    {
        int i = 0;
        /*while(ArrayListOfElements.get((key.hashCode()+i*i)%SIZE)!=null)
        {
            if (ArrayListOfElements.get((key.hashCode()+i*i)%SIZE).getKey()==key)
            {
                return (key.hashCode()+i*i)%SIZE;
            }
            i+=1;
        }*/
        while(ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE]!=null)
        {
            if (ArrayOfElements[((key.hashCode()&0x7fffffff)+i*i)%SIZE].getKey().equals(key))
            {
                return  ((key.hashCode()&0x7fffffff)+i*i)%SIZE;
            }
            i+=1;
        }
        System.out.println("Element not found");
        return -1;
    }
    K search(V value)
    {
        /*for (int i =0  ; i < SIZE; i ++)
        {
            if (ArrayListOfElements.get(i).getValue()==value)
            {
                return ArrayListOfElements.get(i).getKey();
            }
        }*/
        for (int i =0  ; i < SIZE; i ++)
        {
            if (ArrayOfElements[i].getValue().equals(value))
            {
                return ArrayOfElements[i].getKey();
            }
        }
        return null;
    }
    void delete (K key)
    {
        int index=findPosition(key);
        if (index!=-1)
        {
           // ArrayListOfElements.set(index,null);
            ArrayOfElements[index]=null;
            numberOfElements-=1;
        }
    }
    class Element<K,V> implements Comparable
    {
        private K key;
        private V value;
        Element()
        {
            key=null;
            value=null;
        }
        Element(K key, V value)
        {
            this.key=key;
            this.value=value;
        }
        K getKey(){return key;}
        V getValue(){return value;}
        void setKey(K key){this.key=key;}
        void setValue(V value){this.value=value;}
        
        //public int compareTo(Element e) {
        	//return ((Integer)this.getValue()).compareTo((Integer) e.getValue());
        //}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return ((Integer)this.getValue()).compareTo((Integer) ((MyHashMap<K, V>.Element<K, V>) o).getValue());
		}
    }
    
    
    @Override public String toString()
    {
        String result="";
        for (int i =0 ; i < SIZE; i ++)
        {
            //System.out.println(i);
            //System.out.println(ArrayOfElements[i]);
            if (ArrayOfElements[i]==null)
            {
                continue;
            }
            result+=ArrayOfElements[i].getKey()+" | "+ArrayOfElements[i].getValue();
            result+="\n";
        }
        return result;
    }

}
