import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Methods {

	private CDList<String> list;

	public void methodCall(String methodcall) {
		methodcall = methodcall.toLowerCase();
		if (methodcall.contains("load")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall);
			list = loadText(input[1]);
			return;

		} else if (methodcall.contains("print-range")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall + "\n");
			this.printRange(list, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			return;
		}

		else if (methodcall.contains("print-max")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall + "\n");
			this.printMax(list, Integer.parseInt(input[1]));
			return;
		} else if (methodcall.contains("print-min")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall + "\n");
			this.printMin(list, Integer.parseInt(input[1]));
			return;
		} else if (methodcall.contains("print-nth")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall + "\n");
			this.printNth(list, Integer.parseInt(input[1]));
			return;
		} else if (methodcall.contains("print-freq")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall + "\n");
			this.freqWord(list, (input[1]));
			return;
		} else if (methodcall.contains("truncate-list")) {
			String[] input = methodcall.split(" ");
			System.out.println("Directive : " + methodcall + "\n");
			this.truncateList(list, Integer.parseInt(input[1]));
			return;
		}

	}

	public void mainMethod(String filename) {

		Methods methodObject = new Methods();

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
			e.printStackTrace();
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

	public CDList<String> loadText(String Filename) {

		this.list = new CDList<String>();
		String metin = readText(Filename);
		Scanner scn = new Scanner(metin);
		while (scn.hasNext()) {
			String dummy = pure(scn.next());
			list.addWords(dummy);

		}
		scn.close();
		System.out.println("Output :" + list);
		return list;

	}

	public void printRange(CDList<String> list, int rangeLow, int rangeUpper) {

		list.printRange(rangeLow, rangeUpper);

	}

	public void printMax(CDList<String> list, int N) {

		list.printMax(N);

	}

	public void printMin(CDList<String> list, int N) {

		list.printMin(N);

	}

	public void printNth(CDList<String> list, int N) {

		list.printNth(N);

	}

	public void freqWord(CDList<String> list, String word) {
		word = word.toLowerCase();
		list.freqWords(word);

	}

	public void truncateList(CDList<String> list, int N) {
		list.truncateList(N);

	}
}
