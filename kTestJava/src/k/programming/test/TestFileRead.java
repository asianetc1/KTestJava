package k.programming.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestFileRead {

	public static void main(String[] args) {
		try {
			int read;
			String lineString = "";
			ArrayList lineStrings = new ArrayList();
			ArrayList list = new ArrayList();
			
			readFileContents(lineString, lineStrings);
			printContents(lineStrings);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void readFileContents(String lineString,
		ArrayList lineStrings) throws FileNotFoundException, IOException {
		int read;
		FileInputStream fileInputStream = new FileInputStream("D:/java_project/study1/datafile/file1.txt");

		while (true) {
			read = fileInputStream.read();
			if(read == -1) break;
			if ((char)read == '\n') {
				lineStrings.add(lineString);
				lineString = "";
			}else{
				lineString += (char)read;
			}
		}
	}

	private static void printContents(ArrayList lineStrings) {
		String lineString;
		for (int i = 0; i < lineStrings.size(); i++) {
			lineString = (String)lineStrings.get(i);
			System.out.print(i+":"+lineString);
			StringTokenizer stringTokenizer = new StringTokenizer(lineString);
			while(stringTokenizer.hasMoreTokens()){
				System.out.println(stringTokenizer.nextToken());
			}
		}
	}

}
