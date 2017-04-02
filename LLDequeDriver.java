public class LLDequeDriver{

    public static void main(String[] args){
	Deque test = new LLDeque();

	//Adding to the Deque
	test.add("juan");
	test.add("too");
	test.add("tree");
	test.add("for");
	test.add("vive");
	test.add("zix");

	//Tests for peek()
	System.out.println("Now testing peek() methods");
	System.out.print(peek());
	System.out.print(peekLast());

	//Tests for Iterators
	System.out.println("Now printing ascending iterator");
	for(Iterator i = test.iterator(); i.hasNext(); ){
	    System.out.println(i.next());
	}

	System.out.println("Now printing descending iterator");
	for(Iterator k = test.descendingIterator(); k.hasNext(); ){
	    System.out.println(k.next());
	}

	//Test for contains() method
	System.out.println("Now testing contains() method");
	String inDeque = "weven";
	String notInDeque = "ate";

	test.add(inDeque);

	System.out.println(contains(inDeque));
	System.out.println(contains(notInDeque));
    }
}
