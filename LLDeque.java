//Stacked Deque: James Smith, Queenie Xiang, Herman Lin
//APCS2 pd3
//Lab02: All Hands on Deque
//2017-04-01

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LLDeque implements Deque{
    DLLNode _front, _end;
    int size;

    public LLDeque(){
	_end = new DLLNode(null, _front, null);
	_front = new DLLNode(null, null, _end);
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
	    if(_it.next().getValue().equals(o)){
		return true;
	    }
	}
	return false;
    }

    /**
     *Returns an iterator over the elements in this deque in proper sequence.
     *@return Iterator
     */
    public Iterator<t> iterator(){
	return (new AscendingIterator());
    }

    /**
     *Returns an iterator over the elements in this deque in reverse sequential order.
     *@return Iterator
     */
    public Iterator<t> descendingIterator(){
	return (new DescendingIterator());
    }

    /**
     *Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     *@return t
     */
    public t peek(){
	if (isEmpty()){
	    return null;
	}
	return _front;
    }

    /**
     *Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     *@return t
     */
    public t peekLast(){
	if(isEmpty()){
	    return null;
	}
	return _end;
    }
    
    /**
     *Retrieves, but does not remove, the first element of this deque.
     *@return t
     */
    // public t getFirst();

    /**
     *Retrieves, but does not remove, the last element of this deque.
     *@return t
     */
    // public t getLast();

    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
     *@return t The removed element
     */
    // public t remove();

    /**
     *Removes the first occurrence of the specified element from this deque.
     *@param Object Desired Object to be removed
     *@return boolean
     */
    // public boolean remove(Object o);

    /**
     *Retrieves and removes the last element of this deque.
     *@return t Removed element
     */
    // public t removeLast();

    /**
     *Returns the number of elements in this deque.
     *@return int
     */
    // public int size();

    /**
     *Returns if the deque is empty.
     *@return boolean
     */
    // public boolean isEmpty();


    /******************************************************
    -------------------ITERATORS---------------------------
    ******************************************************/
    private class AscendingIterator implements Iterator<t>{

	private DLLNode<t> _dummy;
	private boolean _okToRemove;

	public AscendingIterator(){
	    _dummy = new DLLNode(null, null, _front);
	    _okToRemove = false;
	}
	
	public boolean hasNext(){
	    return (_dummy.getNext() != null);
	}

	public t next(){
	    _dummy = _dummy.getNext();
	    if(_dummy == null){
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;
	    return _dummy
	}

	public void remove(){
	    if(!_okToRemove()){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		remove(_dummy);
	    }
	}
    }

    private class DescendingIterator implements Iterator<t>{
	private DLLNode<t> _dummy;
	private boolean _okToRemove;

	public AscendingIterator(){
	    _dummy = new DLLNode(null, _end, null);
	    _okToRemove = false;
	}
	
	public boolean hasNext(){
	    return (_dummy.getPrev() != null);
	}

	public t next(){
	    _dummy = _dummy.getPrev();
	    if(_dummy == null){
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;
	    return _dummy
		}

	public void remove(){
	    if(!_okToRemove()){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		remove(_dummy);
	    }
	}
    }
}
