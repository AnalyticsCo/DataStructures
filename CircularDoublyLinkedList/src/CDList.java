
/**
 * A basic doubly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CDList<E> {

	// ---------------- nested Node class ----------------
	/**
	 * Node of a doubly linked list, which stores a reference to its element and to
	 * both the previous and next node in the list.
	 */
	public static class Node<E> {

		/** The element stored at this node */
		public E element; // reference to the element stored at this node

		/** A reference to the preceding node in the list */
		public Node<E> prev; // reference to the previous node in the list

		/** A reference to the subsequent node in the list */
		public Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param p reference to a node that should precede the new node
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		// public accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that precedes this one (or null if no such node).
		 * 
		 * @return the preceding node
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Update methods
		/**
		 * Sets the node's previous reference to point to Node n.
		 * 
		 * @param p the node that should precede this one
		 */
		public void setPrev(Node<E> p) {
			prev = p;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	/** Sentinel node at the beginning of the list */
	public Node<E> header; // header sentinel

	/** Number of elements in the list (not including sentinels) */
	public int size = 0; // number of elements in the list

	/** Constructs a new empty list. */
	public CDList() {
		Words max;
		Words min;

		header = new Node<>(null, null, null);
		header.setNext(header);
		header.setPrev(header);// create header
	}

	// public accessor methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list.
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		if (isEmpty())
			return null;
		return header.getElement(); // first element is beyond header
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		if (isEmpty())
			return null;
		return header.getPrev().getElement(); // last element is before header
	}

	// public update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) {
		if (size == 0) {
			header.element = e;
			size++;
			return;

		}

		addBetween(e, header, header.getNext()); // place just after the header

	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) {
		if (size == 0) {
			header.element = e;
			return;

		}

		addBetweenLast(e, header.getPrev(), header); // place just before the trailer
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() {
		if (isEmpty())
			return null;
		// nothing to remove
		return remove(header); // first element is beyond header
	}

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		if (isEmpty())
			return null; // nothing to remove
		return remove(header.getPrev()); // last element is before trailer
	}

	// public update methods
	/**
	 * Adds an element to the linked list in between the given nodes. The given
	 * predecessor and successor should be neighboring each other prior to the call.
	 *
	 * @param predecessor node just before the location where the new element is
	 *                    inserted
	 * @param successor   node just after the location where the new element is
	 *                    inserted
	 */
	public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// create and link a new node
		if (successor.equals(header)) {
			Node<E> dummy = new Node<E>(header.getElement(), header.getPrev(), header.getNext());
			Node<E> newest = new Node<>(e, predecessor, dummy);
			if (predecessor.equals(header)) {
				newest.setPrev(dummy);
				dummy.setNext(newest);
			}
			dummy.setPrev(newest);
			header = newest;
		} else {
			Node<E> newest = new Node<>(e, predecessor, successor);
			predecessor.setNext(newest);
			successor.setPrev(newest);
		}
		size++;
	}

	// Method for adding element at the end of the link while not changing header
	public void addBetweenLast(E e, Node<E> predecessor, Node<E> successor) {
		// create and link a new node

		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);

		size++;
	}

	/**
	 * Removes the given node from the list and returns its element.
	 * 
	 * @param node the node to be removed (must not be a sentinel)
	 */
	public E remove(Node<E> node) {
		
		if(size==1) {
			header =null;
		return null;
		}
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		if (node.equals(header))// Changing Header
			header = header.getNext();
		return node.getElement();
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {

		if(header==null)
			return "This list is empty";
		
		
		
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = header;
		do {
			sb.append(walk.getElement());
			walk = walk.getNext();
			if (walk != header)
				sb.append(", ");
		} while (walk != header);
		sb.append(")");
		return sb.toString();
	}

	public void writeelement() {
		Node<E> walk = header;
		do {

			System.out.println(walk.element);
			walk = header.getNext();
		} while (walk != header);

	}

// Is there a word recorded in list
	public boolean wordControl(E word, CDList list) {

		Node<E> walk = header;
		do {
			if (word.equals(walk.getElement()))
				return true;
			walk = header.getNext();
		} while (walk != header);
		return false;

	}

	public int FreqControl(Words word1, Words word2) {
		String one = word1.value;
		String two = word2.value;
		one.equals(two);
		if (word1.Freq > word2.Freq)
			return 1;
		else if (word1.Freq == word2.Freq)
			return 0;
		return -1;

	}

	public boolean alphabetContol(Node<E> First, Node<E> Second) {
		if (Second.equals(header))
			return false;
		Words value1 = (Words) First.getElement();
		Words value2 = (Words) Second.getElement();
		if (value1.value.compareTo(value2.value) > 0) {
			swapNode(First, Second);
			return true;
		}
		return false;

	}

	public void swapNode(Node<E> First, Node<E> Second) {
		if (Second.equals(header))
			return;
		boolean change = false;
		Node<E> dummyFirst = new Node<>(First.getElement(), First.getPrev(), First.getNext());
		Node<E> dummySecond = new Node<>(Second.getElement(), Second.getPrev(), Second.getNext());
		if (size == 2) {

			First.setNext(Second);
			First.setPrev(Second);
			Second.setNext(First);
			Second.setPrev(First);
			header = Second;
			First = First;
			return;

		}

		if (First.equals(header))
			change = true;
		dummyFirst.getPrev().setNext(Second);
		dummySecond.getNext().setPrev(First);
		Second.setPrev(First.getPrev());
		Second.setNext(First);
		First.setNext(dummySecond.getNext());
		First.setPrev(Second);
		if (change) {
			header = Second;
			return;
		}

	}

	@SuppressWarnings("unchecked")
	public void addWords(String word) {
		if (this.isEmpty()) {
			E element = (E) (new Words(word));
			addFirst(element);
			return;

		}

		Node<E> walk = header;

		do {
			if (((Words) walk.getElement()).value.equals(word)) {
				((Words) walk.getElement()).Freq++;

				FreqSwap(walk.getPrev(), walk);
				return;
			}
			walk = walk.getNext();
		} while (walk != header);
		E element = (E) (new Words(word));
		addLast(element);
		if (size == 2) {
			FreqSwap(header, header.getNext());
			return;
		}
		FreqSwap(header.getPrev().getPrev(), header.getPrev());
		return;
	}

	public Words FreqSwap(Node<E> First, Node<E> Second) {
		if (Second.equals(header))
			return (Words) (Second.getElement());

		int isSwap = FreqControl((Words) (First.getElement()), (Words) (Second.getElement()));
		if (isSwap == -1) {
			swapNode(First, Second);
			if (Second.equals(header))
				return (Words) (Second.getElement());

			return FreqSwap(Second.getPrev(), Second);
		} else if (isSwap == 0) {
			boolean isChanged = alphabetContol(First, Second);
			if (isChanged)
				return FreqSwap(Second.getPrev(), Second);
			return null;
		}

		else
			return (Words) (Second.getElement());

	}

	public void printRange(int rangeLow, int rangeUpper) {
		boolean kontrol = false;
		StringBuilder sb = new StringBuilder(" ");
		Node<E> walk = header;
		do {
			if (((Words) (walk.getElement())).Freq >= rangeLow && ((Words) (walk.getElement())).Freq <= rangeUpper) {
				sb.append(walk.getElement());
				kontrol = true;
			}
			walk = walk.getNext();
			if (walk != header)
				sb.append("\n");
		} while (walk != header);

		if (!kontrol) {
			System.out.println("This range is empty");
			kontrol = false;
			return;
		}
		sb.append("// end of the list ");
		System.out.println(sb);
		return;

	}

	public void printMax(int size) {
		StringBuilder sb = new StringBuilder("");
		if (size > this.size) {
			System.out.println(this.toString());
			return;
		}
		Node<E> walk = header;
		int sayac = size;
		while (sayac > 0) {
			sb.append(walk.getElement());
			walk = walk.getNext();
			sayac--;
			if (walk != header)
				sb.append("\n");
		}
		System.out.println(sb);

	}
	public void printMin(int size) {
		StringBuilder sb = new StringBuilder("");
		if (size > this.size) {
			System.out.println(this.toString());
			return;
		}
		Node<E> walk = header.getPrev();
		int sayac = size;
		while (sayac > 0) {
			sb.append(walk.getElement());
			walk = walk.getPrev();
			sayac--;
			if (walk != header)
				sb.append("\n");
		}
		System.out.println(sb);

	}
	public void freqWords(String word) {
		StringBuilder sb = new StringBuilder("");
		
		Node<E> walk = header;
		int sayac = size;
		do {
			if (((Words) (walk.getElement())).value.equals(word) ) {
				sb.append(((Words) (walk.getElement())).value+"  Freq: "+((Words) (walk.getElement())).Freq);
break;
			}
			walk = walk.getNext();
			if (walk != header)
				sb.append("");
		} while (walk != header);
		System.out.println("Output:   "+sb);

	}
	public void printNth(int N) {
if(N>size) {
	System.out.println("Given number is larger then size");
return;	
}
StringBuilder sb = new StringBuilder("");
		Node<E> walk = header;
		int sayac = 1;
		do {
			if (sayac==N ) {
				sb.append(((Words) (walk.getElement())).value+"  Freq: "+((Words) (walk.getElement())).Freq);
break;
			}
			walk = walk.getNext();
			sayac++;
			if (walk != header)
				sb.append("\n");
		} while (walk != header);
		System.out.println(sb);

	}
	public void truncateList(int N) {
if(N>size) {
	truncateList(size);
return ;	
}
StringBuilder sb = new StringBuilder("");
		Node<E> walk = header.getPrev();
		int sayac = N;
		do {
		
			
			this.remove(walk);
			walk = header.getPrev();
			sayac--;
			if (walk != header)
				sb.append("\n");
			if(this.size==1) {
				this.remove(header);
				break;}
		} while (sayac>0);
		System.out.println("Output Truncate :"+this);

	}


} // ----------- end of DoublyLinkedList class -----------
