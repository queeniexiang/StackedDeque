//Stacked Deque: James Smith, Queenie Xiang, Herman Lin
//APCS2 pd3
//Lab02: All Hands on Deque
//2017-04-01

import java.util.Iterator;
import java.util.NoSuchElementException;
//import java.util.Deque;

public class LLDeque<T> implements Deque<T>{
    DLLNode<T> _front, _end;
    int _size;

    public LLDeque(){
        _front = _end = null; 
	_size = 0;
    }
    /**
      *Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
      *@param value Desired value to be inserted at the end
      *@return boolean stating the success of the operation
     */
    public boolean add(T value) {

	if (_size == 0) { //if it is empty, add it first in the list
	    addFirst(value);
	    return true; 
	}
	
	else { //otherwise connect the current end to a new node that will then be the end
	    _end.setNext( new DLLNode (value, _end, null) ); 
	    _end = _end.getNext();
	}
	
	_size ++; //increment the size
	return true;
    }

    /**
     *Inserts the specified element at the front of this deque
     *@param value Desired value to be inserted in the front
     */
    public void addFirst(T value) {

	if (_size == 0) //if it is empty
	    _front = _end = new DLLNode<T>(value, null, _end); //make the front and end the same node that has the value
    
	else {
	    _front.setPrev( new DLLNode (value, null, _front) ); //connect the current front backwards to a new node that will be the new front
	    _front = _front.getPrev(); 
	}
	_size ++; //increment size up
    }

    /**
      *Inserts the specified element at the end of this deque if it is possible to do so immediately without violating capacity restrictions.
      *@param value Desired value to be inserted at the end
     */
    public void addLast(T value){
	add(value);
    }
    
    /**
     *Returns true if this deque contains the specified element
     *@param Object Target object
     *@return boolean
     */
    public boolean contains(Object o){
	T dummyNext; //create dummy variable to store what is returned by it.next()
	Iterator it = new AscendingIterator(); //create an iterator for ease of iteration through nodes
	while(it.hasNext()){//while you havent gone through every element...
	    dummyNext = (T)it.next();//give dummy var the next value
	    if( dummyNext.equals(o) ){//if this value is equal to the given object...
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
	return (new AscendingIterator()); //construct an Ascending Iterator object and return it >> default iterator is ascending
    }

    /**
     *Returns an iterator over the elements in this deque in reverse sequential order.
     *@return Iterator
     */
    public Iterator<T> descendingIterator(){
	return (new DescendingIterator()); //construct a descending Iterator object and return it
    }

    /**
     *Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque).
     *@return T
     */
    public T element(){
	return _front.getValue();
    }
    
    /**
     *Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     *@return T
     */
    public T peek(){
	if (isEmpty()){
	    return null;
	}
	return (_front.getValue());
    }

    /**
     *Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
     *@returns T
     */
    public T peekFirst(){
	return peek();
    }

    /**
     *Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     *@return T
     */
    public T peekLast(){
	if(isEmpty()){
	    return null;
	}
	
	return (_end.getValue());
    }
    
    /**
     *Retrieves, but does not remove, the first element of this deque.
     *@return T
     */
    public T getFirst() {
	return peek();
    }

    /**
     *Retrieves, but does not remove, the last element of this deque.
     *@return T
     */
    public T getLast() {
	return peekLast();
    }

    /**
     *Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and false if no space is currently available.
     *@param T value to be offered
     *@return boolean
     */
    public boolean offer(T value){
	addLast(value);
	return true;//Linked Lists do not have a capacity restriction
    }

    /**
     *Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
     *@param T value to be offered
     *@return boolean
     */
    public boolean offerFirst(T value){
	addFirst(value);
	return true;
    }

    /**
     *Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
     *@param T value to be offered
     *@return boolean
     */
    public boolean offerLast(T value){
	addLast(value);
	return true;
    }

    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     *@return T removed item
     */
    public T poll(){
	return remove();
    }

    /**
     *Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     *@return T removed element
     */
    public T pollFirst(){
	return remove();
    }

    /**
     *Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     *@return T removed element
     */
    public T pollLast(){
	return removeLast();
    }

    /**
     *Pops an element from the stack represented by this deque.
     *@return T
     */
    public T pop(){
	return getFirst();
    }

    /**
     *Pushes an element onto the stack represented by this deque (in other words, at the head of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
     *@param T value to be pushed
     */
    public void push(T value){
	addFirst(value);
    }
    
    /**
     *Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
     *@return T The removed element
     */
<<<<<<< HEAD
    public T remove(){ 
	//If deque is empty, return null 
	if(isEmpty()){
=======
    public T remove(){
	if(isEmpty()){ //if it is empty, you cant remove anything
>>>>>>> 1243676833438ee64dcee22c78e9e6fa3622b8c2
	    return null;
	}

	//Else, set the new front to _front.getNext() and remove linkage to the old front node 
	else{
	    T retVal = _front.getValue();  //save the return value of the node to be removed
	    _front = _front.getNext(); //set the new front to be the value behind front
	    _front.setPrev(null); //disconnect the old front from the new one
	    _size--; //deincrement the size
	    return retVal;
	}
    }
	    

    /**
     *Removes the first occurrence of the specified element from this deque.
     *@param Object Desired Object to be removed
     *@return boolean
     */
    public boolean remove(Object o) {
	//If deque is empty, return null 
	if (isEmpty()) {
	    return false;
	}

	//Creates a pointer node that will traverse the deque 
	DLLNode temp = _front;
	
	while (temp.getNext() != null){
<<<<<<< HEAD
	    //If the pointer node's value matches the value of the object: 
	    if (temp.getValue().equals(o)){
		//If pointer node is not the front node: 
		if (temp.getPrev() != null ) {
		    //Remove linkage of the current node's previous and next nodes from current
		    //Reset their linkage so they now point to each other as the previous or next node
		    //Current node is now no longer linked to any element of the deque (thus removing it from the deque) 
		    temp.getPrev().setNext(temp.getNext());
		    temp.getNext().setPrev(temp.getPrev());
		}

		else {
		    //The new front will be old _front.getNext() 
		    _front = temp.getNext();
=======
	    if (temp.getValue().equals(o)){//if there is a node that matches an object...
		if (temp.getPrev() != null ) { //if there is a value in front of the target
		    temp.getPrev().setNext(temp.getNext()); // connect the nodes before and after the target to each other
		    temp.getNext().setPrev(temp.getPrev()); 
		}

		else {
		    _front = temp.getNext(); 
>>>>>>> 1243676833438ee64dcee22c78e9e6fa3622b8c2
		}

		_size--; //deincrement
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    /**
     *Removes the first occurrence of the specified element from this deque.
     *@param Object Desired Object to be removed
     *@return boolean
     */
    public boolean removeFirstOccurrence(Object o){
	return remove(o);
    }

    /**
     *Removes the last occurrence of the specified element from this deque.
     *@param Object Desired Object to be removed
     *@return boolean
     */
    public boolean removeLastOccurrence(Object o){
	if (isEmpty()) {
	    return false;
	}
	
	DLLNode temp = _end;
	
	while (temp.getPrev() != null){
	    if (temp.getValue().equals(o)){//if there is a node that matches an object...
		if (temp.getNext() != null ) { //if there is a value in front of the target
		    temp.getPrev().setNext(temp.getNext()); // connect the nodes before and after the target to each other
		    temp.getNext().setPrev(temp.getPrev()); 
		}

		else {
		    _end = temp.getPrev(); 
		}

		_size--; //deincrement
		return true;
	    }
	    temp = temp.getPrev();
	}
	return false;
    }

    /**
     *Retrieves and removes the first element of this deque.
     *@return T
     */
    public T removeFirst(){
	return remove();
    }

    /**
     *Retrieves and removes the last element of this deque.
     *@return T Removed element
     */
    public T removeLast() {
	//If deque is empty, return null 
	if (isEmpty()) {
	    return null;
	}
	
	T retVal = _end.getValue(); //save the return value from the last element

<<<<<<< HEAD
	//If there is only one element left, point all elements to null so deque is now empty
	if (_size == 1) {
=======
	if (_size == 1) {//if there is only one element, disband the linkedList
>>>>>>> 1243676833438ee64dcee22c78e9e6fa3622b8c2
	    _front = _end = null;
	}

	else {
<<<<<<< HEAD
	    //New end will now be the element previous of the old end 
	    _end = _end.getPrev();
	    _end.setNext(null); 
=======
	    _end = _end.getPrev(); //make the new end the node before the current end
	    _end.setNext(null);  //disconect the nodes
>>>>>>> 1243676833438ee64dcee22c78e9e6fa3622b8c2
	}

	_size--; //deincrement
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

    //Helpful function for developing
    public String toString(){
	DLLNode temp = _front; 
	String retStr = "";
	while(temp != null){
	    retStr += temp.getValue() + " ";
	    temp = temp.getNext();
	}
	return retStr;
    }
	    

    /******************************************************
    -------------------ITERATORS---------------------------
    ******************************************************/
    
    private class AscendingIterator implements Iterator<T>{

	private DLLNode<T> _dummy;
	private boolean _okToRemove;

	public AscendingIterator(){
	    _dummy = new DLLNode(null, null, _front); //create a dummy node that points to the _front in order to iterate through the forward connections
	    _okToRemove = false; //since next() hasnt been called, make it false
	}
	
	public boolean hasNext(){
	    return (_dummy.getNext() != null);
	}

	public T next(){
	    if ( hasNext() ) {//if there is another element to be returned...
		_dummy = _dummy.getNext(); //make the dummy node the next node in the chain
	    }
	    
	    else { //if you are trying to call next on an empty iterator then throw an exception
		throw new NoSuchElementException();
	    }
	    _okToRemove = true;//you have called next() so remove has something to remove
	    return _dummy.getValue(); 
	}

	
	public void remove(){
	    if(! _okToRemove ){ //if next() hasnt been called...
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{

		if( _dummy.equals(_front)) { //if the target node is the first node, just call the normal remove method
		    remove();
		}
		
		else if(_dummy.equals(_end)) {//if the target node is the last node, call removeLast()	    
		    removeLast();		    
		}
		
		else{ //otherwise disconnect the target node by connecting its next and prev nodes to each other
		    _dummy.getPrev().setNext((_dummy.getNext()));
		    _dummy.getNext().setPrev(_dummy.getPrev());
		    _size--; //deincrement since you removed the elem
		}
       	    }
	}
    }

    private class DescendingIterator implements Iterator<T>{
	private DLLNode<T> _dummy;
	private boolean _okToRemove;

	public DescendingIterator(){
	    _dummy = new DLLNode(null, _end, null); //initialize dummy node that points backwards to the end in order to iterate through the prev nodes
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
	    return _dummy.getValue();
	}

	public void remove(){
	    if(! _okToRemove ){
		throw new IllegalStateException("must call next() beforehand");
	    }
	    else{
		if( _dummy.equals(_front)) {
		    remove();
		}
		
		else if(_dummy.equals(_end)) {	    
		    removeLast();		    
		}
		else{
		    _dummy.getPrev().setNext((_dummy.getNext()));
		    _dummy.getNext().setPrev(_dummy.getPrev());
		    _size--;
		}
	    }
	}
    }
    
}
