/*
  Henry Zheng
  APCS2 pd3
  HW29 -- Stress is the Best
  2017-04-04
*/


public class DequeTester2{
    
    public static void main(String[] args) {

	Deque<String> Bob = new LLDeque<String>();

	//if nullPointerException, addFirst likely does not account for the situation when size == 0
	System.out.println("---Adding---");
	Bob.addFirst("a");
	Bob.addLast("b");
	Bob.add("c");

	System.out.println("---Testing toString---");
	System.out.println(Bob);
	
	System.out.println("---Polling---");
	System.out.println(Bob.pollFirst()); //a
	System.out.println(Bob.pollLast()); //c

	System.out.println("---Containing---");
	System.out.println(Bob.contains("a"));//false
	System.out.println(Bob.contains("b"));//true
	
	System.out.println("---Iterating---");
	Bob.add("test");
	System.out.println(Bob.iterator()); //b test
	System.out.println(Bob.descendingIterator()); //test b

	System.out.println("---Getting---");
	System.out.println(Bob.element()); // b
	System.out.println(Bob.getFirst()); // b
	System.out.println(Bob.getLast()); // test

	System.out.println("---Peeking---");
	System.out.println(Bob.size()); // 2
	System.out.println(Bob.peekFirst()); // b
	System.out.println(Bob.peek()); // b
	System.out.println(Bob.peekLast()); // test

	System.out.println("---Removing---");
	System.out.println(Bob.remove());//b
	System.out.println(Bob.remove("test"));//true
	System.out.println(Bob.remove("test2"));//false

	Bob.add("b");
	Bob.add("test");
	System.out.println(Bob.removeFirst());//b
	System.out.println(Bob.removeFirstOccurrence("test"));//true
	System.out.println(Bob.removeFirstOccurrence("test2"));//false

	Bob.add("b");
	Bob.add("test");
	System.out.println(Bob.removeLast());
	System.out.println(Bob.removeLastOccurrence("b"));//true
	System.out.println(Bob.removeLastOccurrence("test2"));//false
	
	System.out.println("---Queueing---");
	Bob.push("a");
	System.out.println(Bob.pop());//a
	
	System.out.println("---Offering---");
	//true or false depending on which implementation used
	System.out.println(Bob.offer("a"));
	System.out.println(Bob.offerFirst("b"));
	System.out.println(Bob.offerLast("c"));
    }
}
