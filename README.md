# Team StackedDeque: Queenie Xiang, James Smith, and Herman Lin Present To You…
# All Hands on Deque!

## Method Selections: 
We included every method from the Deque interface itself. If we were given an extra day, we would have implemented the methods that the true Deque interface inherits from the Collection interface: addAll, clear, containsAll, equals, hashCode, removeAll, retainAll, toArray, toArray. For a complete outline of our LLDeque class, please refer to the java API documentation in the repo we created using JavaDoc comments.

### add  
<p>  public boolean add(T value) 
<p>  Inserts the specified element into the queue represented by this deque at the tail or last position. 

### addFirst
<p>  public void addFirst(T value) 
<p>  Inserts the specified element at the front of this deque 

### contains
<p>  public boolean contains(T value)
<p>  Returns true if this deque contains the specified element

### iterator 
<p>  public Iterator<T> iterator() 
<p>  Returns an iterator over the elements in this deque in proper sequence.


### descendingIterator
<p>  public Iterator<T> descendingIterator()
<p>  Returns an iterator over the elements in this deque in reverse sequential order.


### peek 
<p>  public T peek()
<p>  Retrieves the head or first element of the deque. If the deque is empty, null is returned. 


### peekLast  
<p>  public T peekLast()
<p>  Retrieves the last element of this deque. If the deque is empty, return null. 


### getFirst 
<p>  public T getFirst()
* Retrieves the first element of this deque.


### getLast 
<p>  public T getLast()
* Retrieves the last element of this deque.


### remove
<p>  public T remove() 
* Retrieves and removes the head or the front of the queue represented by this deque. 


### remove(Object) 
<p>  public boolean remove(Object o) 
<p>  Removes the first occurrence of the specified element from this deque.


### removeLast 
<p>  public T removeLast()
<p>  Retrieves and removes the last element of this deque.


### size
<p>  public int size()
<p>  Returns the number of elements in this deque.


### isEmpty 
<p>  public boolean isEmpty() 
<p>  Returns if the deque is empty. 
</p>


## Structure Rationale
### Our Choice: Doubly-linked node-based architecture 

We chose to use doubly-linked nodes as the underlying structure for our deque implementation for 2 primary reasons: unrestricted size and runtime. With nodes you never have to worry about size because they are linked objects which means that you can incrementally add them one by one in the front or the back. The runtime was the huge decider in our architecture descision. With an arrayList or array, adding to the front (assuming the structure is _front -> _end) is O(n) and removing from the front can be O(1) with a simple optimization. Adding and removing from the end is O(1). With a doubly linked node architecture, they are all O(1). When adding to the front you are simply making the front's previous node a new node, an O(1) operation.
