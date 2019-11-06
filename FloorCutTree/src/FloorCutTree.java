import java.util.List;

public class FloorCutTree<E> extends LinkedBinaryTree<E> {

	public FloorCutTree() {
		super();
	}

	public void create_root(E v) {

		this.addRoot(v);

	}

	public void Compact() {
		
		List<Position<E>> list =(List<Position<E>>) this.postorder();
		for(Position<E> c :list) {
			if(isInternal(c)) {
				Node<E> dummy = this.validate(c);
				int width = this.calculateWidth(dummy);
				int height = this.calculateHeigth(dummy);
				dummy.setHeight(height);
				dummy.setWeight(width);
			}
			
			
		}
		
		
	}
	
	
	public void cut_horizontal(String v, String lv, String rv) throws IllegalArgumentException {
		Node<E> dummy = this.validate(this.findPosition(this.root(), (E) v));
	//Cut Node Never Cut Again
		if (this.isInternal(dummy)) {
			System.out.println("Internal Node Should not be cut");
			return;
		}
		dummy.setLabel((E) "-");
		dummy.setLeft(new Node<E>((E) lv, dummy, null, null));
		dummy.setRight(new Node<E>((E) rv, dummy, null, null));
	}

	public void cut_vertical(String v, String lv, String rv) throws IllegalArgumentException {
		Node<E> dummy = this.validate(this.findPosition(this.root(), (E) v));
		//Cut Node Never Cut Again
		if (this.isInternal(dummy)) {
			System.out.println("Internal Node Should not be cut");
			return;
		}
		dummy.setLabel((E) "|");
		dummy.setLeft(new Node<E>((E) lv, dummy, null, null));
		dummy.setRight(new Node<E>((E) rv, dummy, null, null));
	}

	public Node<E> assign_heigth(String v, int height) {
		Node<E> dummy = null;
		if ((this.root.getElement().equals(v))) {
			dummy = this.root;

			dummy.setHeight(height);

			return dummy;

		} else
			dummy = this.validate(this.findPosition(this.root(), (E) v));
		dummy.setHeight(height);
		if (this.isInternal(dummy)) {
			throw new IllegalStateException();
		}
		if (((Node<E>) this.parent(dummy)).getLabel().equals("-")) {
			Node<E> Parent = ((Node<E>) this.parent(dummy));
			if (Parent.getLeft().getHeight() + Parent.getRight().getHeight() > Parent.getHeight()) {
				dummy.setHeight(0);
				System.out.println("Height shouldn't be assigned ");
				return null;
			}
			this.setParentZero(dummy.getParent());
			return dummy;

		} else {
			Node<E> Parent = ((Node<E>) this.parent(dummy));
			if (dummy.getHeight() > Parent.getHeight()) {
				dummy.setHeight(0);
				System.out.println("Height shouldn't be assigned ");
				return null;
			}
			this.setParentZero(dummy.getParent());
			return dummy;

		}

	}

	public Node<E> assign_width(String v, int width) {

		Node<E> dummy = null;
		if ((this.root.getElement().equals(v))) {
			dummy = this.root;
			dummy.setWeight(width);

			return dummy;
		} else
			dummy = this.validate(this.findPosition(this.root(), (E) v));
		dummy.setWeight(width);
		if (this.isInternal(dummy)) {
			throw new IllegalStateException();
		}
		if (((Node<E>) this.parent(dummy)).getLabel().equals("|")) {
			Node<E> Parent = ((Node<E>) this.parent(dummy));
			if (Parent.getLeft().getWeight() + Parent.getRight().getWeight() > Parent.getWeight()) {
				dummy.setWeight(0);
				System.out.println("Weight should be assigned smaller  ");
				return null;
			}
			this.setParentZero(dummy.getParent());
			return dummy;

		} else {
			Node<E> Parent = ((Node<E>) this.parent(dummy));
			if (dummy.getWeight() > Parent.getWeight()) {
				dummy.setWeight(0);
				System.out.println("Weight should be assigned smaller ");
				return null;
			}
			this.setParentZero(dummy.getParent());
			return dummy;

		}

	}

	public int calculateWidth(Node<E> Node) {
		if (this.isExternal(Node))
			return Node.getWeight();

		else if (Node.getLabel().equals("-")) {
			return Math.max(calculateWidth(Node.getLeft()), calculateWidth(Node.getRight()));
		} else {

			return calculateWidth(Node.getLeft()) + calculateWidth(Node.getRight());

		}
	}

	public int calculateHeigth(Node<E> Node) {
		if (this.isExternal(Node))
			return Node.getHeight();

		else if (Node.getLabel().equals("|")) {
			return Math.max(calculateHeigth(Node.getLeft()), calculateHeigth(Node.getRight()));
		} else {

			return calculateHeigth(Node.getLeft()) + calculateHeigth(Node.getRight());

		}
	}
	
	public void setParentZero(Node<E> N) {
		
		if(N.getLeft().getHeight()!= 0 && N.getRight().getHeight()!=0 &&
				N.getLeft().getWeight()!= 0 && N.getRight().getWeight()!=0 )
		{
			N.setHeight(0);
			N.setWeight(0);
		}
		
		
	}
	

	public void Display() {
		
		System.out.println("******************************DISPLAY*********************************");
this.InOrder(root);
		
	}

	String makingDot(int i) {

		String dummy = "";
		for (int j = 0; j < i; j++) {
			dummy += ".";
		}
		return dummy;

	}

	public int dot(Node<E> N) {

		if (N == null)
			return -1;
		return 1 + dot(N.getParent());
	}

	public void InOrder(Node<E> Node) {
		String dot = "";
		if (Node == null)
			return;
		if (!(Node.hasLeft() && Node.hasRight())) {

			System.out.println(makingDot(dot(Node)) + "(" + (String) Node.getLabel() + ":" + "(" + Node.getWeight()
					+ "," + Node.getHeight() + "))");
			return;
		}
		InOrder(Node.getLeft());
		System.out.println(makingDot(dot(Node)) + "(" + (String) Node.getLabel() + ":" + "(" + Node.getWeight() + ","
				+ Node.getHeight() + "))");
		InOrder(Node.getRight());

	}

}
