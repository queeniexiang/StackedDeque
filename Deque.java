import java.util.Iterator;

public interface Deque<t>{

    public boolean add(t value);

    public void addFirst(t value);

    public void addLast(t value);

    public boolean contains(t value);

    public Iterator<t> iterator();

    public Iterator<t> descendingIterator();

    public t element();

    public t peek();

    public t peekFirst();

    public t peekLast();

    public t getFirst();

    public t getLast();

    public boolean offer(t value);

    public boolean offerFirst(t value);

    public boolean offerLast(t value);

    public t poll();

    public t pollFirst();

    public t pollLast();

    public t pop();

    public void push(t value);

    public t remove();

    public boolean remove(Object o);

    public boolean removeFirstOccurrence(Object o);

    public boolean removeLastOccurrence(Object o);

    public t removeFirst();

    public t removeLast();

    public int size();

}
