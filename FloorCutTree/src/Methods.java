import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Methods {

	private FloorCutTree<String> tree = new FloorCutTree<>();
	
	public void Create_root(String a) {
		
		tree.addRoot(a);
		
	}
public void assign_w(String a,int n) {
		
		tree.assign_width(a, n);
		
	}
public void assign_h(String a,int n) {
	
	tree.assign_heigth(a, n);
	
}
public void display() {
	tree.Display();
	
}
public void cut_vertical(String A,String B,String C) {

	tree.cut_vertical(A, B, C);
	
}

public void cut_horizantal(String A,String B,String C) {

	tree.cut_horizontal(A, B, C);
	
}


public void compact() {

tree.Compact();	
}
	public void methodCall(String methodcall) {
		if (methodcall.contains("create-root")) {
			String[] input = methodcall.split(" ");
			this.Create_root(input[1]);
			return;

		} else if (methodcall.contains("assign-w")) {
			String[] input = methodcall.split(" ");
this.assign_w(input[1], Integer.parseInt(input[2]));

return;
		}
		else if (methodcall.contains("assign-h")) {
			String[] input = methodcall.split(" ");
this.assign_h(input[1], Integer.parseInt(input[2]));
			return;
		}
		

		else if (methodcall.contains("display")) {
			this.display();
			return;
			
		} else if (methodcall.contains("cut-v")) {
			String[] input = methodcall.split(" ");
this.cut_vertical(input[1], input[2], input[3]);
			return;
		} 
		else if (methodcall.contains("cut-h")) {
			String[] input = methodcall.split(" ");
			this.cut_horizantal(input[1], input[2], input[3]);
			
return;
		}
		else if (methodcall.contains("compact")) {
			this.compact();
			return;
		} else if (methodcall.contains("quit")) {
System.exit(0);
			return;
		}

	}

	public void mainMethod(String filename) {


		// String d_File = readText(filename);

		BufferedReader b_reader;
		try {
			b_reader = new BufferedReader(new FileReader(filename));
			String line = b_reader.readLine();
			while (line != null) {
				// read next line
				methodCall(line);
				line = b_reader.readLine();

			}
			b_reader.close();
		} catch (IOException e) {
			System.out.println("File not found");
			Scanner K = new Scanner(System.in);
			int counter =0;
			String input="";
			while(counter!=1) {
				System.out.println("Enter new directive filename by using .txt");
				input =K.nextLine(); 
			if(input.indexOf(".txt")!=-1)
				counter =1;
			}
			
			
			mainMethod(input);
			System.exit(0);
		}

	}

	public String readText(String filename) {

		File file = new File(filename);
		String document = "";
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (input.hasNextLine()) {
			String line = input.nextLine();
			line = line.toLowerCase();
			document += line;
		}

		return document;
	}

// Kelimedeki harf disindakileri silme 
	public String pure(String metin) {

		return metin = metin.replaceAll("[^a-zA-Z]+", "");

	}

	public String readDirectory(String name) {

		return readText(name);

	}



}
