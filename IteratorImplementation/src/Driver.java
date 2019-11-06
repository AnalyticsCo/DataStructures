




public class Driver {

	
	
	public static void main(String args[]) {
		
		
		LinkedPositionalList<String> list =new LinkedPositionalList<String>();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		list.addFirst("e");
		System.out.println(list);
		LinkedPositionalList.ElementListIterator Iterator=list.listIterator(4);
		System.out.println(Iterator.previousIndex());
		Iterator.previous();
		System.out.println(Iterator.previousIndex());
		
		Iterator.add("k");
		//System.out.println(Iterator.next().toString());
		Iterator.add("f");
		Iterator.add("C");
		Iterator.add("l");
		Iterator.add("n");
		System.out.println(list);
		System.out.println(Iterator.hasPrevious());	
		System.out.println(Iterator.previous().toString());
		Iterator.remove();
		System.out.println(list);
		System.out.println(Iterator.nextIndex());
		
		
		
		//Iterator.previous();
		System.out.println(list);
		System.out.println((Iterator).getRecent());
		System.out.println(Iterator.next());
		//Iterator.add("V");
		//Iterator.add("N");
		System.out.println(list);
		
		
	 while(Iterator.hasPrevious()) {
		 System.out.println(Iterator.previous().toString());
		 
		 
	 }
	 /* System.out.println(Iterator_new.next());
		System.out.println(Iterator_new.next());
		System.out.println(Iterator_new.next());
		System.out.println(Iterator_new.next());
		System.out.println(Iterator_new.previous());
	System.out.println(Iterator_new.previous());
System.out.println(Iterator_new.previous());*/
		
	}
}
