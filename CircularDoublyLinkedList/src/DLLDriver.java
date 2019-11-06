
public class DLLDriver {
	public static void main(String[] args) {
		CDList<String> dll = new CDList<>();
		dll.addFirst("A");
		System.out.println(dll);
		dll.addFirst("B");
		System.out.println(dll);
		dll.addLast("C");
		
		dll.addFirst("D");
		
		System.out.println(dll);
		dll.removeFirst();
		System.out.println("After removal of first:\n"+dll);
		
		dll.removeLast();
		System.out.println("After removal of last:\n"+dll);
		
	}
}
