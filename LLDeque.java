//Stacked Deque: James Smith, Queenie Xiang, Herman Lin
//APCS2 pd3
//Lab02: All Hands on Deque
//2017-04-01

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LLDeque<T> implements Deque{
    DLLNode<T> _front, _end;
    int _size;

    public LLDeque(){
	_end = new DLLNode<T>(null, _front, null);
	_front = new DLLNode<T>(null, null, _end);
	_size = 0;
    }
    /**
      *Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
      *@param value Desired value to be inserted at the end
      *@return boolean stating the success of the operation
     */
    //public boolean add(t value);

    /**
     *Inserts the specified element at the front of this deque
     *@param value Desired value to be inserted in the front
     */
    // public void addFirst(t value);

    /**
     *Returns true if this deque contains the specified element
     *@param Object Target object
     *@return boolean
     */
    public boolean contains(Object o){
	Iterator it = new AscendingIterator();
	while(it.hasNext()){
	    DLLNode currentNode = new DLLNode<T>(((T)(it.next())), null, null);
	    
	    if(currentNode.getValue().equals(o)){
		return true;
	    }
	}
	
	return false;
    }

    /**
     *Returns an iterator over the elements in this deque in proper sequence.
     *@return Iterator
     */
    public Iterator<T> iterator(){
	return (new AscendingIterator());
    }

    /**
     *Returns an iterator over the elements in this deque in reverse sequential order.
     *@return Iterator
     */
    public Iterator<T> descendingIterator(){
	return (new DescendingIterator());
    }

    /**
     *Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     *@return T
     */
    public T peek(){
	if (isEmpty()){
	    return null;
	}
	return ((T)(_front));
    }

    /**
     *Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     *@return T
     */
    public T peekLast(){
	if(isEmpty()){
	    return null;
	}
	
	return ((T)(_end));
    }
    
    /**
     *Retrieves, but does not remove, the first element of this deque.
     *@return T
     */
    // public T getFirst();

    /**
     *Retrieves, but does not remove, the last element of this deque.
     *@return T
     */
    // public T getLast();

    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
     *@return T The removed element
     */
    public T remove() {
	T retVal = _front.getValue(); 

	_front = _front.getPrev();
	
	return retVal; 

    }
	    

    /**
     *Removes the first occurrence of the specified element from this deque.
     *@param Object Desired Object to be removed
     *@return boolean
     */
    public boolean remove(Object o) {
	DLLNode temp = _front;
	int counter = 0; 

	while (! temp.getValue().equals(o) ) {
	    if (counter > _size) {
		return false;
	    }
	    
	    counter++;
	    temp = temp.getPrev();
	}

	while (counter != 0 ) {
	    temp = temp.getNext();
	    temp.setPrev(temp.getPrev()); 
	    counter--;
	}

	return true;
    } 

    /**
     *Retrieves and removes the last element of this deque.
     *@return T Removed element
     */
    public T removeLast() {
	T retVal = _end.getValue(); 

	_end = _end.getNext();

	return retVal;
    } 
	

    /**
     *Returns the number of elements in this deque.
     *@return int
     */
    public int size() {	
	return _size;
    }
	
    /**
     *Returns if the deque is empty.
     *@return boolean
     */
    public boolean isEmpty() {
	return (_size == 0);
    } 


    /******************************************************
    -------------------ITERATORS---------------------------
    ******************************************************/
    private class AscendingIterator implements Iterator<T>{

	private DLLNode<T> _dummy;
	private boolean _okToRemove;

	public AscendingIterator(){
	    _dummy = new DLLNode(null, null, _front);
	    _okToRemove = false;
	}
	
	public boolean hasNext(){
	    return (_dummy.getNext() != null);
	}

	public T next(){
	    _dummy = _dummy.getNext();
	    if(_dummy == null){
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;
	    return ((T)(_dummy)); 
	}

	public void remove(){
	    if(! _okToRemove ){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		remove(_dummy.getValue());
	    }
	}
    }

    private class DescendingIterator implements Iterator<T>{
	private DLLNode<T> _dummy;
	private boolean _okToRemove;

	public DescendingIterator(){
	    _dummy = new DLLNode(null, _end, null);
	    _okToRemove = false;
	}
	
	public boolean hasNext(){
	    return (_dummy.getPrev() != null);
	}

	public T next(){
	    _dummy = _dummy.getPrev();
	    if(_dummy == null){
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;
	    return ((T)(_dummy));
	}

	public void remove(){
	    if(! _okToRemove ){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		remove(_dummy.getValue());
	    }
	}
    }
}
