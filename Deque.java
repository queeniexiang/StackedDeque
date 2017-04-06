import java.util.Iterator;

public interface Deque<T>{

    public boolean add(T value);

    public void addFirst(T value);

    public void addLast(T value);

    public boolean contains(T value);

    public Iterator<T> iterator();

    public Iterator<T> descendingIterator();

    public T element();

    public T peek();

    public T peekFirst();

    public T peekLast();

    public T getFirst();

    public T getLast();

    public boolean offer(T value);

    public boolean offerFirst(T value);

    public boolean offerLast(T value);

    public T poll();

    public T pollFirst();

    public T pollLast();

    public T pop();

    public void push(T value);

    public T remove();

    public boolean remove(Object o);

    public boolean removeFirstOccurrence(Object o);

    public boolean removeLastOccurrence(Object o);

    public T removeFirst();

    public T removeLast();

    public int size();

}
