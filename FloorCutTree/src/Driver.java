import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		
		Methods method = new Methods();
		
		Scanner K = new Scanner(System.in);
		int counter =0;
		String input="";
		while(counter!=1) {
			System.out.println("Enter new directive filename by using .txt");
			input =K.nextLine(); 
		if(input.indexOf(".txt")!=-1)
			counter =1;
		}
		
		
		method.mainMethod(input);
		
		
		
		
		/*FloorCutTree<String> tree= new FloorCutTree<String>();
		tree.create_root("A");
		System.out.println(tree.root.getElement());
		
		tree.assign_heigth("A", 100);
		tree.assign_width("A", 200);
		tree.cut_horizontal("A", "B", "C");
		tree.assign_heigth("B", 23);
		tree.assign_width("B", 80);
		tree.assign_heigth("C", 40);
		tree.assign_width("C", 70);
		tree.InOrder(tree.root);
		tree.Compact();
		tree.InOrder(tree.root);
		tree.cut_vertical("B", "D", "E");
		tree.assign_heigth("D", 20);
		tree.assign_width("D", 100);
		tree.assign_heigth("E", 50);
		tree.assign_width("E", 100);
		tree.InOrder(tree.root);*/
	}

}
