/*
  Team QQ -- Rihui Zheng, YuQi Wu, Elaina Chung
  APCS2 pd3
  HW29 Stress is the Best
  2017-04-05
 */

public class DequeTester{

    public static void main(String[] args){
	// test case
	Deque<String> test = new LLDeque<String>();

	// test add()
	test.add("I");	
	test.add("am");	
	test.add("a");
	test.add("test");
	test.add("case");
	System.out.println(test + "\n"); // I am a test case

	// test addFirst
	test.addFirst("Hello,");
	System.out.println(test + "\n"); // Hello, I am a test case

	// test getFirst() and getLast()
	System.out.println("First: " + test.getFirst()); // Hello,
	System.out.println("Last: " + test.getLast() + "\n"); // case
	
	// test remove()
	test.remove();
	System.out.println(test); // Hello, I am a test
	test.remove();
	System.out.println(test); // Hello, I am a
	test.remove();
	System.out.println(test + "\n"); // Hello, I am
 
	// test removeFirst()
	test.removeFirst();
	System.out.println(test + "\n"); // I am

	// test size()
	System.out.println(test.size()); // 2

	// test contains(Object o)	
	System.out.println(test.contains("I") ); // true
	System.out.println(test.contains("am") ); // true
	System.out.println(test.contains("Hello,") ); // false
	
	// test clear()
	test.clear();
	System.out.println("\ntest: " + test); //
	System.out.println("size: " + test.size() ); // 0
	
	// test isEmpty()
	System.out.println("empty? " + test.isEmpty() ); // true
    }
}
