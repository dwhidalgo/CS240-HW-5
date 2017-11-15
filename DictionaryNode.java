import java.util.Iterator;
import java.util.ArrayList;

/**
   An ADT Dictonary using a Double Linked Node.
   
   @author Drue Hidalgo
   @version 1.0
*/

public class DictionaryNode<K extends Comparable<? super K>,V> implements DictionaryInterface<K,V>
{
    private Node<K,V> top;
    private int size;
    
    public DictionaryNode()
    {
        top = null;
        size = 0;
    }
    
    public V add(K key, V value)
    {
        V data = null;
        
        Node<K,V> temp = top;
        Node<K,V> previous = null; 
        
        while( (temp != null) && ( ( key.compareTo( temp.getKey() ) > 0 ) ) )
        {
            previous = temp;
            temp = temp.getNext();
        }
    
    
        if( ( temp!=null ) && ( key.equals( temp.getKey() ) ) )
        {
            data = temp.getValue();
            temp.setValue(value);
        }
        
        else
        {
            Node<K,V> newNode = new Node<K,V>(key, value, null);
            
            if(previous == null)
            {
                newNode.setNext(top);
                top = newNode;
            }
            
            else
            {
                newNode.setNext(temp);
                previous.setNext(newNode);
            }
            
            size++;
        }
        
        return data;
    }
   
    public V remove(K key)
    {
        Node<K,V> temp = top;
        Node<K,V> previous = null;
    
        V data = null;
    
        while( (temp.getKey() != key ) && ( temp != null ) )
        {
            previous = temp;
            temp = temp.getNext();
        }
    
        if(temp != null)
        {
            data = temp.getValue();
            temp.setValue(null);
        
            previous.setNext(temp.getNext());
            
            size--;
        }
        
        return data;
    }

    public V getValue(K key)
    {
        Node<K, V> temp = top;
    
        while( ( temp.getKey() != key ) && ( temp != null) )
        {
            temp = temp.getNext();
        }
    
        if(temp != null)
        {
            return temp.getValue();
        }
    
        return null;
    }
   
    public boolean contains(K key)
    {
        Node<K, V> temp = top;
    
        while( ( temp.getKey() != key ) && ( temp != null) )
        {
            temp = temp.getNext();
        }
    
        return (temp != null);
    }
   
    public Iterator<K> getKeyIterator()
    {
        ArrayList<K> array = new ArrayList<K>();
        Node<K, V> temp = top;
        
        while(temp != null)
        {
            array.add(temp.getKey());
            temp = temp.getNext();
        }
        
        Iterator<K> keyIterator = array.iterator();
        
        return keyIterator;
    }
    public Iterator<V> getValueIterator()
    {
        ArrayList<V> array = new ArrayList<V>();
        Node<K, V> temp = top;
        
        while(temp != null)
        {
            array.add(temp.getValue());
            temp = temp.getNext();
        }
        
        Iterator<V> valueIterator = array.iterator();
        
        return valueIterator;
    }
   
    public boolean isEmpty()
    {
        return (size == 0);
    }
   
    public int getSize()
    {
        return size;
    }
  
    public void clear()
    {
        Node<K, V> temp = top;
        Node<K, V> previous = null;
    
        while(top != null)
        {
            previous = temp;
            temp = temp.getNext();
            previous.setValue(null);
            previous.setKey(null);
            previous.setNext(null);
        }
    }
    
    class Node<K,V>
    {
        private K key;
        private V value;
        private Node<K,V> next;
    
        public Node(K k, V v, Node<K,V> n)
        {
            key = k;
            value = v;
            next = n;
        }
    
        public void setKey(K k)
        {
            key = k;
        }
    
        public void setValue(V v)
        {
            value = v;
        }
    
        public void setNext(Node<K,V> n)
        {
            next = n;
        }
    
        public K getKey()
        {
            return key;
        }
    
        public V getValue()
        {
            return value;
        }
    
        public Node<K,V> getNext()
        {
            return next;
        }
    }
}