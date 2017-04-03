import java.util.Iterator;

public class LLDequeDriver{

    public static void main(String[] args){
	Deque<String> test = new LLDeque<String>();

	//Adding to the Deque
	test.add("for");
	test.add("vive");
	test.add("zix");
	test.addFirst("tree");
	test.addFirst("too");
	test.addFirst("juan");

	//toString test
	System.out.println("Now printing the toString()");
	System.out.println(test);
	
	//Tests for peek()
	System.out.println("Now testing peek() methods");
	System.out.println(test.peek());
	System.out.println(test.peekLast());

	//Tests for get()
	System.out.println("Now testing get() methods");
	System.out.println(test.getFirst());	
	System.out.println(test.getLast());
	
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

	System.out.println(test.contains(inDeque));
	System.out.println(test.contains(notInDeque));

	//Tests for Remove Methods

	//Juan 
	test.remove();
	System.out.println(test);

	//Too 
	test.remove();
	System.out.println(test);

	//Tree
	test.remove();
	System.out.println(test);

	//Zix
	DLLNode temp = new DLLNode("zix", null, null);
	test.remove(temp);
	System.out.println(test);

	//Vive
	test.removeLast();
	System.out.println(test);

	//For
	test.removeLast();
	System.out.println(test);

	//Deque should now be empty: SOP null 
	test.remove();
	System.out.println(test);
	
	
    }
}
