
import java.io.*;
import java.util.Scanner;

public class SimpleIOTest3 {
	public static void main(String[] args) throws IOException  {
		String[] words = new String[10];
		Scanner fileInput = new Scanner (new File("sample_words_in.txt"));
		File fileOutput = new File("sample_words_out.txt");
		PrintWriter wordsOutput = new PrintWriter(fileOutput);
		while (fileInput.hasNext()){
			words = fileInput.nextLine().split("\\s+");
			for (int i=0; i<words.length; i++){
				wordsOutput.print(words[i] + " ");
			}
			wordsOutput.println();
		}
		fileInput.close();
		wordsOutput.close();
	}
}
